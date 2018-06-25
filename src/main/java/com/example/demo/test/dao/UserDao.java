package com.example.demo.test.dao;

import com.example.demo.test.entity.User;

import java.util.List;

/**
 * @author chenjie15
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/6/25 19:43
 */
public interface UserDao {

    List<User> getAll(User user);
}
