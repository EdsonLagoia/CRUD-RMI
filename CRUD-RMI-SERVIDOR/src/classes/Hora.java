package classes;

import dao.HoraDAO;
import interfaces.InterfaceHora;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Hora extends UnicastRemoteObject implements InterfaceHora {
    private int id;
    private int horas;
    private int minutos;
    
    public Hora() throws RemoteException {
        System.out.println("A classe Data está disponível remotamente");
    }
    
    @Override
    public void setId(int id) {
        this.id = id;
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
    public int getId() {
        return id;
    }

    @Override
    public int getHoras() {
        return horas;
    }

    @Override
    public int getMinutos() {
        return minutos;
    }
    
    @Override
    public void insert(){
        HoraDAO.insert(this);
    }

    @Override
    public ArrayList<Hora> select() {
        return HoraDAO.select();
    }
    
    @Override
    public void delete(int id){
        HoraDAO.delete(id);
    }
}
