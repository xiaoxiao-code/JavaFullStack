package lzt.lztbatis.core;

import lzt.lztbatis.datasource.LztUNPOOLEDDataSource;
import lzt.lztbatis.mapping.LztMappedStatement;
import lzt.lztbatis.transaction.LztJDBCTransaction;
import lzt.lztbatis.transaction.TransactionManager;
import lzt.lztbatis.utils.Resources;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * lztBatis 框架的核心构建器类
 * 专门用于解析 XML 配置文件，并构建 SqlSessionFactory 对象
 */
public class SqlSessionFactoryBuilder {

    public SqlSessionFactoryBuilder() {
    }

    /**
     * 核心 build 方法：通过读取输入流来构建会话工厂
     * @param inputStream 指向核心配置文件的输入流 (mybatis-config.xml)
     * @return SqlSessionFactory 工厂对象
     */
    public SqlSessionFactory build(InputStream inputStream) {
        try {
            // 1. 创建 dom4j 的解析器
            SAXReader reader = new SAXReader();
            Document document = reader.read(inputStream);
            Element root = document.getRootElement();

            // ==================== 第一部分：解析数据库环境配置 ====================

            // 获取默认的环境 id (对应 <environments default="development">)
            String defaultEnvId = root.element("environments").attributeValue("default");

            // 使用 XPath 语法定位到默认的 environment 标签
            String xpath = "/configuration/environments/environment[@id='" + defaultEnvId + "']";
            Element environment = (Element) root.selectSingleNode(xpath);

            // 1.1 解析 DataSource (数据源)
            Element dataSourceElt = environment.element("dataSource");
            String driver = "", url = "", username = "", password = "";
            List<Element> properties = dataSourceElt.elements("property");
            for (Element property : properties) {
                String name = property.attributeValue("name");
                String value = property.attributeValue("value");
                if ("driver".equals(name)) driver = value;
                if ("url".equals(name)) url = value;
                if ("username".equals(name)) username = value;
                if ("password".equals(name)) password = value;
            }
            // 实例化我们在第六步写好的 UNPOOLED 数据源
            DataSource dataSource = new LztUNPOOLEDDataSource(driver, url, username, password);

            // 1.2 解析 TransactionManager (事务管理器)
            Element txManagerElt = environment.element("transactionManager");
            String txType = txManagerElt.attributeValue("type");
            TransactionManager transactionManager = null;
            if ("JDBC".equals(txType.toUpperCase())) {
                // 实例化我们在第五步写好的 JDBC 事务管理器，默认关闭自动提交
                transactionManager = new LztJDBCTransaction(dataSource, false);
            }


            // ==================== 第二部分：解析所有的 Mapper SQL 映射 ====================

            Map<String, LztMappedStatement> mappedStatements = new HashMap<>();

            // 获取所有的 <mapper resource="..."> 标签
            List<Node> mapperNodes = root.selectNodes("//mapper");
            for (Node mapperNode : mapperNodes) {
                Element mapperElt = (Element) mapperNode;
                String resource = mapperElt.attributeValue("resource");

                // 读取具体的 Mapper XML 文件 (例如 CarMapper.xml)
                InputStream mapperInputStream = Resources.getResourceAsStream(resource);
                Document mapperDoc = reader.read(mapperInputStream);
                Element mapperRoot = mapperDoc.getRootElement();

                // 为了简化，这里我们假设直接使用 namespace + id 作为 key，或者像你的测试代码里那样直接用 id。
                // 真正的 MyBatis 是用 namespace.id。为了匹配你的测试类 sqlSession.insert("insertCar", car);
                // 我们这里以 SQL 标签的 id 作为 Map 的 key。

                // 遍历 <select>, <insert>, <update>, <delete> 标签
                List<Element> sqlElements = mapperRoot.elements();
                for (Element sqlElement : sqlElements) {
                    String id = sqlElement.attributeValue("id");
                    String resultType = sqlElement.attributeValue("resultType");
                    // 获取标签内部的文本 (即具体的 SQL 语句)
                    String sql = sqlElement.getTextTrim();

                    // 实例化我们在第七步写好的 LztMappedStatement，把 SQL 信息存进去
                    LztMappedStatement mappedStatement = new LztMappedStatement(id, resultType, sql);

                    // 放入 Map 集合中
                    mappedStatements.put(id, mappedStatement);
                }
            }

            // ==================== 第三部分：组装并返回 SqlSessionFactory ====================

            // 实例化第八步写好的默认工厂，并将解析好的“事务管理器”和“SQL字典”交由它保管
            //return new LztDefaultSqlSessionFactory(transactionManager, mappedStatements);

            // 1. 先把解析出来的数据塞进大管家
            LztConfiguration configuration = new LztConfiguration(transactionManager, mappedStatements);

            // 2. 实例化工厂，并把大管家交给它
            return new LztDefaultSqlSessionFactory(configuration);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("解析 XML 配置文件失败，无法构建 SqlSessionFactory！", e);
        }
    }
}