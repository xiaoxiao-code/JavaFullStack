package org.cqipu.edu.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ResponseBodyController {

    @PostMapping("/msg")
    @ResponseBody
    public String hello(){
        // 重点是这里：由于使用@ResponseBody注解，因此返回值不再被当做逻辑视图名
        // 底层会使用消息转换器StringHttpMessageConverter，将该字符串直接写入响应体
        return "hello";
    }
}