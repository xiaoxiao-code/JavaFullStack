package org.cqipu.edu.controller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RequestMappingTestController {

    // 1. 通配符映射
    @RequestMapping("/x*z/testValueAnt")    // * 匹配本级任意字符
    public String testValueAnt(){
        return "testValueAnt"; // 视图名，自动拼接前缀/后缀
    }

    // 2. RESTful 映射
    @RequestMapping(value="/testRESTful/{id}/{username}/{age}")
    public String testRESTful(
            @PathVariable("id") int id,
            @PathVariable("username") String username,
            @PathVariable("age") int age){
        return "testRESTful";
    }

    // 3. 登录表单处理（POST请求）
    @RequestMapping(value="/login", method = RequestMethod.PUT)
    //@PostMapping("/login")
    public String testMethod(){
        return "testMethod";
    }

    @RequestMapping(value="/testParams", params = {"username", "password"})
    public String testParams(){
        return "testParams";
    }

    @RequestMapping(value="/testHeaders", headers = {"Referer=http://localhost:8080/"})
    public String testHeaders(){
        return "testHeaders";
    }
}