package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface InterfaceLocal extends Remote {
    public void setId(int id) throws RemoteException;
    public void setCliente(String cliente) throws RemoteException;
    public void setEndereco(String endereco) throws RemoteException;
    public int getId() throws RemoteException;
    public String getCliente() throws RemoteException;
    public String getEndereco() throws RemoteException;
    public void insert() throws RemoteException;
    public ArrayList<InterfaceLocal> select() throws RemoteException;
    public void delete(int id) throws RemoteException;
}
