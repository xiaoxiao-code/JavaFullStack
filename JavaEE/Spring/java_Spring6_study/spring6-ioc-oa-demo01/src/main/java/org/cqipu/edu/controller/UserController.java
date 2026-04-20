package org.cqipu.edu.controller;

import org.cqipu.edu.service.UserService;

public class UserController {
    // 移除硬编码new，保留私有属性
    private UserService userService;

    // 添加setter方法（Spring将通过此方法注入依赖）
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    // 原login方法完全不变
    public void login() {
        String username = "admin";
        String password = "123456";
        boolean success = userService.login(username, password);
        if (success) {
            System.out.println("登录成功！欢迎回来，" + username);
        } else {
            System.out.println("登录失败：用户名或密码错误");
        }
    }
}