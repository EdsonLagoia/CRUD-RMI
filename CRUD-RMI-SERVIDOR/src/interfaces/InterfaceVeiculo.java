package interfaces;

import classes.Veiculo;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface InterfaceVeiculo extends Remote {
    public void setId(int id) throws RemoteException;
    public void setMarca(String marca) throws RemoteException;
    public void setModelo(String modelo) throws RemoteException;
    public void setPlaca(String placa) throws RemoteException;
    public int getId() throws RemoteException;
    public String getMarca() throws RemoteException;
    public String getModelo() throws RemoteException;
    public String getPlaca() throws RemoteException;
    public void insert() throws RemoteException;
    public ArrayList<Veiculo> select() throws RemoteException;
    public void delete(int id) throws RemoteException;
}
