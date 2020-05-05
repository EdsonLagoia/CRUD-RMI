package views;

import interfaces.InterfaceData;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class listarData extends JPanel{
    public listarData() throws NotBoundException, MalformedURLException{
        try{
            InterfaceData dataRemoto = (InterfaceData) Naming.lookup("rmi://192.168.1.118:1099/Data");
            ArrayList<InterfaceData> datas = dataRemoto.select();
           
            for(InterfaceData data: datas){
                add(new JLabel(data.getDia() + "/" + data.getMes() + "/" + data.getAno()));
            }
            
        }catch(RemoteException re){
            
        }
    }
}
