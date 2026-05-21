package lk.susa.rmi.client;

import lk.susa.rmi.model.Data;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Message extends Remote {
    public String hello() throws RemoteException;
    public Data getData() throws RemoteException;
    public  String getResult(int num1, int num2) throws RemoteException;
}
