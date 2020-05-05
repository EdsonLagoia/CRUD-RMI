package interfaces;

import classes.Produto;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface InterfaceProduto extends Remote {
    public void setDescricao(String descricao) throws RemoteException;
    public void setPreco(double preco) throws RemoteException;
    public void setQuantidade(int quantidade) throws RemoteException;
    public String getDescricao() throws RemoteException;
    public double getPreco() throws RemoteException;
    public int getQuantidade() throws RemoteException;
    public void insert() throws RemoteException;
    public ArrayList<Produto> select() throws RemoteException;
}
