package org.cqipu.edu.service;

import org.cqipu.edu.User;
import org.cqipu.edu.dao.UserDao;
import org.cqipu.edu.service.UserService;

public class UserServiceImpl implements UserService {
    // 移除硬编码new，保留私有属性
    private UserDao userDao;

    // 添加setter方法（Spring将通过此方法注入依赖）
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    // 原login方法完全不变
    @Override
    public boolean login(String username, String password) {
        User user = userDao.selectByUsernameAndPassword(username, password);
        return user != null;
    }
}