package org.cqipu.edu.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @RequestMapping(value = "/api/user/{id}", method = RequestMethod.GET)
    public String getById(@PathVariable("id") Integer id){
        System.out.println("根据用户id查询用户信息，用户id是" + id);
        return "ok";
    }

    @RequestMapping(value = "/api/user", method = RequestMethod.GET)
    public String getAll(){
        System.out.println("查询所有用户信息");
        return "ok";
    }

    @RequestMapping(value = "/api/user", method = RequestMethod.POST)
    public String save(){
        System.out.println("保存用户信息");
        return "ok";
    }

    @RequestMapping(value = "/api/user", method = RequestMethod.PUT)
    public String update(@RequestParam("username") String username){
        System.out.println("修改用户信息，用户名：" + username);
        return "ok";
    }
}

