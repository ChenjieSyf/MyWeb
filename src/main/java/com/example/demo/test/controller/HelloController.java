package com.example.demo.test.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.test.entity.User;
import com.example.demo.test.service.IUSerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author chenjie15
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/6/25 13:26
 */
@RestController
public class HelloController {
    @Value("${name}")
    private String name;

    @Value("${age}")
    private String age;

    @Autowired
    private IUSerService iuSerService;
    @RequestMapping("/hello")
    public String hello() {
        return name +"--"+age;
    }

    @RequestMapping("/get/all/user")
    public String getAll(){
       List<User> userList =  iuSerService.getAll(null);
       return JSON.toJSONString(userList);
    }
}
