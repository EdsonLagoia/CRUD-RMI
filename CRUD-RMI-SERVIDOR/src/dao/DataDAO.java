package dao;

import classes.Data;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class DataDAO {
    public static void insert(Data data){
        String sql = "INSERT INTO data (dia, mes, ano) VALUES (?, ?, ?)";
        
        try {
            Connection conexao = ConexaoDB.retornaConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, data.getDia());
            stmt.setInt(2, data.getMes());
            stmt.setInt(3, data.getAno());
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
