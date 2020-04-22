package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceData extends Remote {
    public void setDia(int dia) throws RemoteException;
    public void setMes(int mes) throws RemoteException;
    public void setAno(int ano) throws RemoteException;
    public int getDia() throws RemoteException;
    public int getMes() throws RemoteException;
    public int getAno() throws RemoteException;
}
