package interfaces;

import classes.Data;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface InterfaceData extends Remote {
    public void setDia(int dia) throws RemoteException;
    public void setMes(int mes) throws RemoteException;
    public void setAno(int ano) throws RemoteException;
    public int getDia() throws RemoteException;
    public int getMes() throws RemoteException;
    public int getAno() throws RemoteException;
    public void insert() throws RemoteException;
    public ArrayList<Data> select() throws RemoteException;
}
