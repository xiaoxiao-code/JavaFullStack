package org.cqipu.edu.dao.impl;

import org.cqipu.edu.User;
import org.cqipu.edu.dao.UserDao;

public class UserDaoImplForOracle implements UserDao {
    @Override
    public User selectByUsernameAndPassword(String username, String password) {
        // 实际开发中会使用JDBC/MyBatis连接Oracle
        System.out.println("使用Oracle数据库查询用户：" + username);
        return null; // 实际场景需返回查询到的User对象
    }
}