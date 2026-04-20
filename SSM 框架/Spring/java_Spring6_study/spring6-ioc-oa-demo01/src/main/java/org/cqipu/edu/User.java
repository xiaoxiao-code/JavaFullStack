package org.cqipu.edu;

public class User {
    private Long id;
    private String username;
    private String password;

    // Getter和Setter方法（必须提供，用于Spring数据注入）
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}