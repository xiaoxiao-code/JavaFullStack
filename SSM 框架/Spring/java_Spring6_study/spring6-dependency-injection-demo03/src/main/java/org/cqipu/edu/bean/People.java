package org.cqipu.edu.bean;
import java.util.Set;
import java.util.Properties;
import java.util.Map;
public class People {
    // 一个人有多个电话
    private Set<String> phones;
    // 一个人的多个名字（别名）
    private Set<String> names;
    // 一个人有多个住址
    private Map<Integer, String> addrs;
    private Properties properties;

    // ==================== 无参构造函数 ====================
    public People() {
    }

    // ==================== Setter 方法 ====================
    public void setPhones(Set<String> phones) {
        this.phones = phones;
    }

    public void setNames(Set<String> names) {
        this.names = names;
    }

    public void setAddrs(Map<Integer, String> addrs) {
        this.addrs = addrs;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    // ==================== Getter 方法 ====================
    public Set<String> getPhones() {
        return phones;
    }

    public Set<String> getNames() {
        return names;
    }

    // ==================== toString 方法 ====================
    @Override
    public String toString() {
        return "People{" +
                "properties=" + properties +
                ", addrs=" + addrs +
                ", phones=" + phones +
                ", names=" + names +
                '}';
    }
}