package views;

import interfaces.InterfaceProduto;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class listarProduto extends JPanel{
    public listarProduto() throws NotBoundException, MalformedURLException{
        try{
            InterfaceProduto produtoRemoto = (InterfaceProduto) Naming.lookup("rmi://192.168.1.118:1099/Produto");
            ArrayList<InterfaceProduto> produtos = produtoRemoto.select();
           
            for(InterfaceProduto produto: produtos){
                add(new JLabel(produto.getDescricao() + " - " + produto.getQuantidade()));
            }
            
        }catch(RemoteException re){
            
        }
    }
}
