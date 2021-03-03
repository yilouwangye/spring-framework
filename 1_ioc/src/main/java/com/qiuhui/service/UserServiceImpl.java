package com.qiuhui.service;

import com.qiuhui.dao.UserDao;
import com.qiuhui.dao.UserDaoImpl;

public class UserServiceImpl implements UserService {
//    private UserDao userDao = new UserDaoImpl();
    private  UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void getUser() {
        userDao.getUser();
    }
}