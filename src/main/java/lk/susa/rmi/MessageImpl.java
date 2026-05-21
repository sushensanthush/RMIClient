package lk.susa.rmi;

import lk.susa.rmi.client.Message;
import lk.susa.rmi.model.Data;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MessageImpl extends UnicastRemoteObject implements Message, Remote {

   MessageImpl() throws RemoteException{}

    @Override
    public String hello() throws RemoteException {
        return "hello";

    }

    @Override
    public Data getData() throws RemoteException {
       return new Data(10,"App Version");
    }

    @Override
    public String getResult(int num1, int num2) throws RemoteException {
        return "Result is: " + (num1 + num2);
    }
}
