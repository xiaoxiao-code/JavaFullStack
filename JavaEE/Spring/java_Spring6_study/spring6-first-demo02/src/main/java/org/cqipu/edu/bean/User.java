package org.cqipu.edu.bean;

/**
 * bean，封装用户信息。
 */
public class User {
    private String username;
    private String password;
    public User() {
        System.out.println("User的无参数构造方法执行");
    }
//    public User(String name){
//        System.out.println("User的有参数构造方法执行");
//    }
// setter/getter方法（必须，否则无法调用setUsername等）
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
}
