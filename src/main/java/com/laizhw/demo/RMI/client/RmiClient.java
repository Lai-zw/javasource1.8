package com.laizhw.demo.RMI.client;

import com.laizhw.demo.RMI.model.User;
import com.laizhw.demo.RMI.service.UserService;

import java.rmi.Naming;

/**
 *  RMI 客户端
 *
 */
public class RmiClient {
    public static void main(String[] args) {
        User answer;
        String userId = "00002";
        try {
            // lookup method to find reference of remote object
            UserService access = (UserService) Naming.lookup("rmi://localhost:1900/user");
            answer = access.findUser(userId);
            System.out.println("query:" + userId);
            System.out.println("result:" + answer);
        } catch (Exception ae) {
            System.out.println(ae);
        }
    }
}