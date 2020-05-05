package classes;

import dao.DataDAO;
import interfaces.InterfaceData;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Data extends UnicastRemoteObject implements InterfaceData {
    private int dia;
    private int mes;
    private int ano;
    
    public Data() throws RemoteException {
        System.out.println("A classe Data está disponível remotamente");
    }

    @Override
    public void setDia(int dia) {
        this.dia = dia;
    }

    @Override
    public void setMes(int mes) {
        this.mes = mes;
    }

    @Override
    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public int getDia() {
        return dia;
    }

    @Override
    public int getMes() {
        return mes;
    }

    @Override
    public int getAno() {
        return ano;
    }
    
    @Override
    public void insert(){
        DataDAO.insert(this);
    }

    @Override
    public ArrayList<Data> select() {
        return DataDAO.select();
    }
}
