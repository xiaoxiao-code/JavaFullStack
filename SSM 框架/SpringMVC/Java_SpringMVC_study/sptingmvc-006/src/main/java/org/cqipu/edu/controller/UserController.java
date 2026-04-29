package org.cqipu.edu.controller;
import org.cqipu.edu.entity.User;
import org.cqipu.edu.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/user")
    public String list(Model model){
        // 获取所有的用户
        List<User> users = userDao.selectAll();
        // 存储到request域
        model.addAttribute("users", users);
        // 跳转视图
        return "user_list";
    }

    @PostMapping("/user")
    public String save(User user){
        // 保存用户
        userDao.save(user);
        // 重定向到列表
        return "redirect:/user";
    }

    @GetMapping("/user/{id}")
    public String toUpdate(@PathVariable("id") Long id, Model model){
        // 根据id查询用户信息
        User user = userDao.selectById(id);
        // 将对象存储到request域
        model.addAttribute("user", user);
        // 跳转视图
        return "user_edit";
    }

    @PutMapping("/user")
    public String modify(User user){
        // 更新数据
        userDao.update(user);
        // 重定向
        return "redirect:/user";
    }

    @DeleteMapping("/user/{id}")
    public String del(@PathVariable("id") Long id){
        // 删除
        userDao.deleteById(id);
        // 重定向
        return "redirect:/user";
    }
}

