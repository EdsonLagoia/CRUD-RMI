package views;

import interfaces.InterfaceVeiculo;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class listarVeiculo extends JPanel{
    public listarVeiculo() throws NotBoundException, MalformedURLException{
        try{
            InterfaceVeiculo veiculoRemoto = (InterfaceVeiculo) Naming.lookup("rmi://192.168.1.118:1099/Veiculo");
            ArrayList<InterfaceVeiculo> veiculos = veiculoRemoto.select();
           
            for(InterfaceVeiculo veiculo: veiculos){
                add(new JLabel("\n" + veiculo.getModelo() + " - " + veiculo.getPlaca()));
            }
            
        }catch(RemoteException re){
            
        }
    }
}
