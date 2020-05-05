package views;

import interfaces.InterfaceLocal;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class listarLocal extends JPanel{
    public listarLocal() throws NotBoundException, MalformedURLException{
        try{
            InterfaceLocal localRemoto = (InterfaceLocal) Naming.lookup("rmi://192.168.1.118:1099/Local");
            ArrayList<InterfaceLocal> locais = localRemoto.select();
           
            for(InterfaceLocal local: locais){
                add(new JLabel(local.getCliente()+" - "+local.getEndereco()));
            }
            
        }catch(RemoteException re){
            
        }
    }
}
