package demo.RMI.server;

import demo.RMI.service.UserService;
import demo.RMI.service.impl.UserServiceImpl;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * RMI Server 端
 */
public class RmiServer {

    public static void main(String[] args) {
        try {
            UserService userService = new UserServiceImpl();
            LocateRegistry.createRegistry(1900);
            Naming.rebind("rmi://localhost:1900/user", userService);
            System.out.println("start server,port is 1900");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}