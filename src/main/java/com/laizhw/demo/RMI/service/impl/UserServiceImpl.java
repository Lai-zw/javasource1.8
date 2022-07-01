package com.laizhw.demo.RMI.service.impl;

import com.laizhw.demo.RMI.model.User;
import com.laizhw.demo.RMI.service.UserService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class UserServiceImpl extends UnicastRemoteObject implements UserService {

    public UserServiceImpl() throws RemoteException {
    }

    @Override
    public User findUser(String userId) throws RemoteException {
        // 加载在查询
         if ("00001".equals(userId)) {
            User user = new User();
            user.setName("金庸");
            user.setAge(100);
            user.setSkill("写作");
            return user;
        }
        throw new RemoteException("查无此人");
    }
}