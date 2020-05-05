package dao;

import classes.Hora;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
    
    public static ArrayList<Hora> select(){
        
        ArrayList<Hora> horas = new ArrayList<>();
        
        String sql = "SELECT * FROM hora";
        
        try{
            Connection conexao = ConexaoDB.retornaConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet registro = stmt.executeQuery();
            
            while (registro.next()){
                Hora temporario = new Hora();
                    temporario.setHoras(registro.getInt("horas"));
                    temporario.setMinutos(registro.getInt("minutos"));
                horas.add(temporario);
            }
            
            return horas;
        } catch(Exception e){
            System.err.println("Erro na Listagem de Hora: " + e.toString());
        }
        
        return null;
    }

    
    public void delete(){
        
    }
}
