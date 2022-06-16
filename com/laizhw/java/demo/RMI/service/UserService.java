package demo.RMI.service;

import demo.RMI.model.User;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UserService extends Remote {

    /**
     * 查找用户
     * 
     * @param userId
     * @return
     * @throws RemoteException
     */
    User findUser(String userId) throws RemoteException;
}