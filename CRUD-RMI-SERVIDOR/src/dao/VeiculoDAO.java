package dao;

import classes.Veiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class VeiculoDAO {
    public static void insert(Veiculo veiculo){
        String sql = "INSERT INTO veiculo (marca, modelo, placa) VALUES (?, ?, ?)";
        
        try {
            Connection conexao = ConexaoDB.retornaConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, veiculo.getMarca());
            stmt.setString(2, veiculo.getModelo());
            stmt.setString(3, veiculo.getPlaca());
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
