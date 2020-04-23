package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceLocal extends Remote {
    public void setCliente(String cliente) throws RemoteException;
    public void setEndereco(String endereco) throws RemoteException;
    public String getCliente() throws RemoteException;
    public String getEndereco() throws RemoteException;
    public void insert() throws RemoteException;
}
