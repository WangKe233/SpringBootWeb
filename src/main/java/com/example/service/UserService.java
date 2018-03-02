package com.example.service;

import com.example.Entity.User;
import com.example.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by WK on 2018/3/1.
 */
@Service
public class UserService {

    @Autowired
    UserDao userDao;

    @Transactional(rollbackFor = Exception.class)
    public boolean  save(User user){
        userDao.save(user);
        return true;

    }
}
