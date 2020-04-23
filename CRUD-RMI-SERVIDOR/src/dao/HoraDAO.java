package dao;

import classes.Hora;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class HoraDAO {
    public static void insert(Hora hora){
        String sql = "INSERT INTO hora (horas, minutos) VALUES (?, ?)";
        
        try {
            Connection conexao = ConexaoDB.retornaConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, hora.getHoras());
            stmt.setInt(2, hora.getMinutos());
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
