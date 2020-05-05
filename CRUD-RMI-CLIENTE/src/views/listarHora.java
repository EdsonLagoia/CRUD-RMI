package views;

import interfaces.InterfaceHora;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class listarHora extends JPanel{
    public listarHora() throws NotBoundException, MalformedURLException{
        try{
            InterfaceHora horaRemoto = (InterfaceHora) Naming.lookup("rmi://192.168.1.118:1099/Hora");
            ArrayList<InterfaceHora> horas = horaRemoto.select();
           
            for(InterfaceHora hora: horas){
                add(new JLabel(hora.getHoras()+ ":" + hora.getMinutos()));
            }
            
        }catch(RemoteException re){
            
        }
    }
}
