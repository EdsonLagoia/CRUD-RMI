package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceVeiculo extends Remote {
    public void setMarca(String marca) throws RemoteException;
    public void setModelo(String modelo) throws RemoteException;
    public void setPlaca(String placa) throws RemoteException;
    public String getMarca() throws RemoteException;
    public String getModelo() throws RemoteException;
    public String getPlaca() throws RemoteException;
    public void insert() throws RemoteException;
}
