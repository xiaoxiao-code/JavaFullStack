package lzt.lztbatis.mapping;

/**
 * 核心映射语句类
 * 专门用于封装 Mapper XML 文件中每一个 SQL 标签的详细信息
 */
public class LztMappedStatement {

    /**
     * SQL 语句的唯一标识
     * 对应 XML 标签的 id 属性，或者是 namespace + id（例如："insertCar" 或 "car.insertCar"）
     */
    private String sqlId;

    /**
     * 返回值类型的全限定类名
     * 对应 XML 中的 resultType 属性（例如："com.lzt.pojo.Car"）
     * 注意：insert/update/delete 通常不需要专门配置 resultType，但 select 查询通常必须有
     */
    private String resultType;

    /**
     * 真正要交给 JDBC 执行的 SQL 语句文本
     * （在完善的框架中，这里会将 XML 里的 #{xxx} 预先转换成 ? 的预编译 SQL）
     */
    private String sql;

    // --- 以下为标准的无参/有参构造方法，以及 Getter/Setter 方法 ---

    public LztMappedStatement() {
    }

    public LztMappedStatement(String sqlId, String resultType, String sql) {
        this.sqlId = sqlId;
        this.resultType = resultType;
        this.sql = sql;
    }

    public String getSqlId() {
        return sqlId;
    }

    public void setSqlId(String sqlId) {
        this.sqlId = sqlId;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    @Override
    public String toString() {
        return "LztMappedStatement{" +
                "sqlId='" + sqlId + '\'' +
                ", resultType='" + resultType + '\'' +
                ", sql='" + sql + '\'' +
                '}';
    }
}