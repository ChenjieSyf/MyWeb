package com.example.demo.test.service.impl;

import com.example.demo.test.dao.UserDao;
import com.example.demo.test.entity.User;
import com.example.demo.test.service.IUSerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chenjie15
 * @Title: ${file_name}
 * @Package ${package_name}
 * @Description: ${todo}
 * @date 2018/6/25 19:47
 */
@Service
public class UserImpl implements IUSerService {

    @Autowired
    private  UserDao userDao;

    @Override
    public List<User> getAll(User user) {
        return userDao.getAll(user);
    }
}
