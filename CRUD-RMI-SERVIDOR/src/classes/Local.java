package classes;

import dao.LocalDAO;
import interfaces.InterfaceLocal;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Local extends UnicastRemoteObject implements InterfaceLocal {
    private String cliente;
    private String endereco;
    
    public Local() throws RemoteException{
        System.out.println("A classe Local está disponível remotamente");
    }

    @Override
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    @Override
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String getCliente() {
        return cliente;
    }

    @Override
    public String getEndereco() {
        return endereco;
    }
    
    public void insert(){
        LocalDAO.insert(this);
    }

    @Override
    public ArrayList<Local> select() {
        return LocalDAO.select();
    }
}
