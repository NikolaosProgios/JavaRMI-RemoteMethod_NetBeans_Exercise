package example.hello;

import java.rmi.Remote;
import java.rmi.RemoteException;

//H method sayHello() ilopoieite sto Server.java
public interface Hello extends Remote {
    
    String CHECK(int[][] t1, int[][] t2, String operation) throws RemoteException ;
}