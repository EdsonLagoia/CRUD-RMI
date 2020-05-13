package dao;

import classes.Local;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
            System.err.println("Erro no Adicionar Local: " + e.toString());
        }
    }
    
    public static ArrayList<Local> select(){
        
        ArrayList<Local> locais = new ArrayList<>();
        
        String sql = "SELECT * FROM local";
        
        try{
            Connection conexao = ConexaoDB.retornaConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet registro = stmt.executeQuery();
            
            while (registro.next()){
                Local temporario = new Local();
                    temporario.setCliente(registro.getString("cliente"));
                    temporario.setEndereco(registro.getString("endereco"));
                locais.add(temporario);
            }
            
            return locais;
        } catch(Exception e){
            System.err.println("Erro no Listar Local: " + e.toString());
        }
        
        return null;
    }
    
    public static void delete(int id){
        String sql = "DELETE FROM local WHERE id = ?";
        
        try{
            Connection conexao = ConexaoDB.retornaConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } catch(Exception e) {
            System.err.println("Erro no Excluir Local: " + e.toString());
        }
    }
    
    public void update(){
        
    }
}
