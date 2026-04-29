package org.cqipu.edu.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.cqipu.edu.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

@Controller
public class UserController {
    @RequestMapping("/")
    public String toRegisterPage(){
        return "register";
    }

//    @PostMapping(value="/register")
//    public String register(HttpServletRequest request){
//        // 通过当前请求对象获取提交的数据
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        String sex = request.getParameter("sex");
//        String[] hobbies = request.getParameterValues("hobby");
//        String intro = request.getParameter("intro");
//        System.out.println(username + "," + password + "," + sex + "," + Arrays.toString(hobbies) + "," + intro);
//        return "success";
//    }

    @GetMapping("/down")
    public void downloadJpg(HttpServletRequest request, HttpServletResponse response) {
        try {
            // 获取ServletContext对象。
            ServletContext application = request.getServletContext();
            // 通过ServletContext获取文件绝对路径。
            String realPath = application.getRealPath("/img/image.jpg");
            File file = new File(realPath);

            // 设置图片相关的响应头
            response.setContentType("image/jpeg");
            // 设置文件下载行为：attachment 强制下载，不直接在浏览器中显示
            response.setHeader("Content-Disposition", "attachment; filename=\"image.jpg\"");
            response.setHeader("Content-Length", String.valueOf(file.length()));

            // 写入响应流
            Files.copy(file.toPath(), response.getOutputStream());
            response.flushBuffer();

        } catch (IOException e) {
            // 处理异常
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }
//    @PostMapping("/register")
//    public String register(User user){
//        System.out.println(user);
//        return "success";
//    }

//    @PostMapping("/register")
//    public String register(User user,
//                           @RequestHeader(value="Referer", required = false, defaultValue = "")
//                           String referer){
//        System.out.println(user);
//        System.out.println(referer);
//        return "success";
//    }

    @GetMapping("/register")
    public String register(User user,
                           @RequestHeader(value="Referer", required = false, defaultValue = "")
                           String referer,
                           @CookieValue(value="id", required = false, defaultValue = "2222222222")
                           String id){
        System.out.println(user);
        System.out.println(referer);
        System.out.println(id);
        return "success";
    }

//    @PostMapping(value = "/register")
//    public String register(
//            @RequestParam(value="username")
//            String a,
//            @RequestParam(value="password")
//            String b,
//            @RequestParam(value="sex")
//            String c,
//            @RequestParam(value="hobby")
//            String[] d,
//            @RequestParam(name="intro")
//            String e,
//            @RequestParam(value="age",required=false)
//            Integer age) {
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);
//        System.out.println(Arrays.toString(d));
//        System.out.println(e);
//        System.out.println("age = "+age);
//        return "success";
//    }
}
