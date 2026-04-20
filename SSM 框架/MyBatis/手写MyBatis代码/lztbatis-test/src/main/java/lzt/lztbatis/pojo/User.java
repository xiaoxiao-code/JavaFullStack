package lzt.lztbatis.pojo;

/**
 * 对应数据库 t_user 表的实体类
 */
public class User {

    // 属性名与数据库表的字段名保持一致（或者符合下划线转驼峰的规则）
    private String id;
    private String name;
    private String email;
    private String address;

    /**
     * 无参构造方法
     * 框架在 selectOne 方法中，需要利用反射调用它来创建空对象：
     * resultClass.getDeclaredConstructor().newInstance();
     */
    public User() {
    }

    /**
     * 全参构造方法，方便我们在测试 insert 的时候快速 new 一个对象
     */
    public User(String id, String name, String email, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    // --- 下面是 Getter 和 Setter 方法 ---
    // 你的框架在 insert 时会调用 Getter 取值，在 selectOne 时会调用 Setter 赋值

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 重写 toString 方法，方便我们在测试台直接打印出对象的内容，而不是内存地址
     */
    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}