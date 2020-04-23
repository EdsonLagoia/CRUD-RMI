package classes;

import dao.HoraDAO;
import interfaces.InterfaceHora;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Hora extends UnicastRemoteObject implements InterfaceHora {
    public int horas;
    public int minutos;
    
    public Hora() throws RemoteException {
        System.out.println("A classe Data está disponível remotamente");
    }
    
    @Override
    public void setHoras(int horas) {
        this.horas = horas;
    }

    @Override
    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    @Override
    public int getHoras() {
        return horas;
    }

    @Override
    public int getMinutos() {
        return minutos;
    }
    
    public void insert(){
        HoraDAO.insert(this);
    }
}
