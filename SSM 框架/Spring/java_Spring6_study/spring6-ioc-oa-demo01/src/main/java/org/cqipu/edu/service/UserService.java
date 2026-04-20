package org.cqipu.edu.service;

public interface UserService {
    /**
     * 登录验证
     * @param username 用户名
     * @param password 密码
     * @return 验证结果（true表示成功，false表示失败）
     */
    boolean login(String username, String password);
}