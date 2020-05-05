package classes;

import dao.ProdutoDAO;
import interfaces.InterfaceProduto;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Produto extends UnicastRemoteObject implements InterfaceProduto {
    private String descricao;
    private double preco;
    private int quantidade;
    
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
    
    public void insert(){
        ProdutoDAO.insert(this);
    }
    
    @Override
    public ArrayList<Produto> select(){
        return ProdutoDAO.select();
    }

}
