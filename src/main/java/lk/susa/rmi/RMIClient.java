package lk.susa.rmi;

import lk.susa.rmi.client.Message;
import lk.susa.rmi.client.UserService;
import lk.susa.rmi.model.Data;
import lk.susa.rmi.model.User;

import javax.naming.InitialContext;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Properties;

public class RMIClient {
    public static void main(String[] args) {
        try{

//            Registry registry = LocateRegistry.getRegistry("localhost",6666);
//            String[] list =registry.list();
//            for (String s : list){
//                System.out.println(s);
//            }

            //UserService userService = (UserService) Naming.lookup("rmi://127.0.0.1:6666/user_service");

            Properties prop = new Properties();
            prop.put(InitialContext.PROVIDER_URL, "rmi://127.0.0.1:6666");
            prop.put(InitialContext.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.rmi.registry.RegistryContextFactory");


            InitialContext ic = new InitialContext(prop);
            UserService userService = (UserService) ic.lookup("user_service");
//
            ///Message message = (Message)registry.lookup("message_service");
//            //String msg = message.hello();
//
//            //System.out.println(msg);

            //Data data = message.getData();


            //System.out.println(data.getId());
            //System.out.println(data.getName());

//            UserService userService = (UserService) registry.lookup("user_service");
            userService.addUser(1,new User(1,"Sushen","Colombo","sushen@example.com"));

            userService.getAllUsers().forEach(user -> System.out.println(user.getName() + " - " + user.getAddress() + " - " + user.getEmail()));

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
