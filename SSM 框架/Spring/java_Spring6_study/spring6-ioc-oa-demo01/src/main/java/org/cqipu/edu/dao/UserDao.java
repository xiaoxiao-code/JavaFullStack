package org.cqipu.edu.dao;

import org.cqipu.edu.User;

public interface UserDao {
    /**
     * 根据用户名和密码查询用户
     * @param username 用户名
     * @param password 密码
     * @return 用户对象（null表示未找到）
     */
    User selectByUsernameAndPassword(String username, String password);
}