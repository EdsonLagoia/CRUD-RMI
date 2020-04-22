package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceHora extends Remote {
    public void setHoras(int horas) throws RemoteException;
    public void setMinutos(int minutos) throws RemoteException;
    public int getHoras() throws RemoteException;
    public int getMinutos() throws RemoteException;
}
