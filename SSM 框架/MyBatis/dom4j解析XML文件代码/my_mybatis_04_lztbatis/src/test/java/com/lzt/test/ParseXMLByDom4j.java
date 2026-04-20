package com.lzt.test;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class ParseXMLByDom4j {

    @Test
    public void testLztBatisConfig() throws Exception {
        // 1. 获取核心配置文件的输入流 (模拟 SqlSessionFactoryBuilder 接收 InputStream)
        // 使用类加载器从类路径下读取 lztbatis-config.xml
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("lztbatis-config.xml");

        // 2. 创建 dom4j 的 SAXReader 对象，用于读取 XML
        SAXReader reader = new SAXReader();

        // 3. 读取输入流，生成 Document 文档对象 (这代表了整个 XML 文件的树形结构)
        Document document = reader.read(is);

        // 4. 解析数据库连接信息：利用 XPath 表达式 //property 极速定位所有 property 标签
        System.out.println("====== LztBatis 正在加载数据库连接池配置 ======");
        List<Node> propertyNodes = document.selectNodes("//property");
        for (Node node : propertyNodes) {
            Element element = (Element) node;
            // 获取 name 和 value 属性的值
            String name = element.attributeValue("name");
            String value = element.attributeValue("value");
            System.out.println("解析到配置: " + name + " = " + value);

            // 在真正的框架中，这里会将抓取到的 driver, url, username(root), password(20060329)
            // 存入一个自定义的 Configuration 对象，或者直接用来创建 DataSource 数据库连接池。
        }

        System.out.println("\n====== LztBatis 正在加载 SQL 映射文件 ======");
        // 5. 解析 Mapper 映射文件位置：利用 XPath 表达式 //mapper 定位
        List<Node> mapperNodes = document.selectNodes("//mapper");
        for (Node node : mapperNodes) {
            Element element = (Element) node;
            String resource = element.attributeValue("resource");
            System.out.println("发现 Mapper 映射文件: " + resource);

            // 在真正的框架中，读取到 CarMapper.xml 后，会立刻触发对 CarMapper.xml 的解析，
            // 把里面的 SQL 语句提取出来存入内存（通常是一个 Map<String, MappedStatement>）。
        }
    }
    @Test
    public void testCarMapper() throws Exception {
        // 1. 获取 Mapper 映射文件的输入流
        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("CarMapper.xml");

        // 2. 创建 SAXReader 对象，读取 XML 文档
        SAXReader reader = new SAXReader();
        Document document = reader.read(is);

        // 3. 解析根标签 <mapper> 获取 namespace (命名空间)
        // 使用 selectSingleNode 直接获取唯一的 mapper 节点
        Element mapperElement = (Element) document.selectSingleNode("//mapper");
        String namespace = mapperElement.attributeValue("namespace");

        System.out.println("====== LztBatis 正在解析 Mapper 命名空间 ======");
        System.out.println("发现 Namespace: " + namespace);

        // 4. 解析所有的 <select> 查询标签
        System.out.println("\n====== LztBatis 正在解析 <select> 标签 ======");
        List<Node> selectNodes = document.selectNodes("//select");
        for (Node node : selectNodes) {
            Element element = (Element) node;

            // 提取核心属性
            String id = element.attributeValue("id");
            String resultType = element.attributeValue("resultType");

            // 提取 SQL 语句，getTextTrim() 可以自动去除 SQL 文本首尾的换行符和空格
            String sql = element.getTextTrim();

            // 框架底层动作：将 namespace 和 id 拼接，作为这条 SQL 的全局唯一坐标
            String statementId = namespace + "." + id;

            System.out.println("全局唯一标识 (Statement ID): " + statementId);
            System.out.println("返回结果类型 (Result Type): " + resultType);
            System.out.println("原始 SQL 语句: \n" + sql);
            System.out.println("-------------------------------------------------");

            // 在手写框架的后续步骤中，我们会把这三个变量存入 MappedStatement 对象中。
        }

        // 5. 解析所有的 <insert> 插入标签
        System.out.println("\n====== LztBatis 正在解析 <insert> 标签 ======");
        List<Node> insertNodes = document.selectNodes("//insert");
        for (Node node : insertNodes) {
            Element element = (Element) node;

            String id = element.attributeValue("id");
            String sql = element.getTextTrim();

            String statementId = namespace + "." + id;

            System.out.println("全局唯一标识 (Statement ID): " + statementId);
            System.out.println("原始 SQL 语句: \n" + sql);
            System.out.println("-------------------------------------------------");
        }
    }
}