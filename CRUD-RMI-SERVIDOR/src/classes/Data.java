package classes;

import interfaces.InterfaceData;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Data extends UnicastRemoteObject implements InterfaceData {
    public int dia;
    public int mes;
    public int ano;
    
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
}
