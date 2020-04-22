package principal;

import classes.Data;
import classes.Hora;
import classes.Local;
import classes.Produto;
import classes.Veiculo;
import dao.ConexaoDB;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.sql.Connection;

public class IniciarServidor {
    
    public static void main(String[] args) {
        try{
            System.out.println("Iniciando Servidor");
            Connection conn = null;
            
            try {
                conn = ConexaoDB.retornaConexao();
                
                if(conn == null){
                    System.out.println("Erro de Conexão");
                } else {
                    System.out.println("Conectado ao Banco de Dados");
                }
            } catch (Exception edb) {
                System.out.println("Erro de Banco: " + edb.toString());
            }
            
            LocateRegistry.createRegistry(1099);
            
            Produto objetoProduto = new Produto();
            Hora objetoHora = new Hora();
            Data objetoData = new Data();
            Local objetoLocal = new Local();
            Veiculo objetoVeiculo = new Veiculo();
            Naming.rebind("rmi://192.168.1.118:1099/Produto", objetoProduto);
            Naming.rebind("rmi://192.168.1.118:1099/Hora", objetoHora);
            Naming.rebind("rmi://192.168.1.118:1099/Data", objetoData);
            Naming.rebind("rmi://192.168.1.118:1099/Local", objetoLocal);
            Naming.rebind("rmi://192.168.1.118:1099/Veiculo", objetoVeiculo);
        } catch(RemoteException re) {
            System.out.println("Erro Remoto: " +re.toString());
        } catch(Exception e){
            System.out.println("Erro Local: " + e.toString());
        }
    }
    
}
