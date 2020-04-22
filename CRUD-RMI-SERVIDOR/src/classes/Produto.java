package classes;

import interfaces.InterfaceProduto;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Produto extends UnicastRemoteObject implements InterfaceProduto {
    public String descricao;
    public double preco;
    public int quantidade;
    
    public Produto() throws RemoteException {
        System.out.println("A classe Produto está disponível remotamente");
    }
    
    @Override
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    @Override
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
        
    @Override
    public String getDescricao() {
        return descricao;
    }
    
    @Override
    public double getPreco() {
        return preco;
    }
    
    @Override
    public int getQuantidade() {
        return quantidade;
    }
}
