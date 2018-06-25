package com.example.demo.test.service;

import com.example.demo.test.entity.User;

import java.util.List;

/**
 * @author chenjie15
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/6/25 19:47
 */
public interface IUSerService {

    List<User> getAll(User user);
}
