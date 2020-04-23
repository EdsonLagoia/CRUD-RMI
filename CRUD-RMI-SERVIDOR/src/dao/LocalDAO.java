package dao;

import classes.Local;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class LocalDAO {
    public static void insert(Local local){
        String sql = "INSERT INTO local (cliente, endereco) VALUES (?, ?)";
        
        try {
            Connection conexao = ConexaoDB.retornaConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, local.getCliente());
            stmt.setString(2, local.getEndereco());
            stmt.execute();
        } catch(Exception e) {
            System.out.println("Erro na função insert: " + e.toString());
        }
    }
    
    public void update(){
        
    }
    
    public void select(){
        
    }
    
    public void delete(){
        
    }
}
