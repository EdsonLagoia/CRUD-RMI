package classes;

import interfaces.InterfaceLocal;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Local extends UnicastRemoteObject implements InterfaceLocal {
    String cliente;
    String endereco;
    
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
}
