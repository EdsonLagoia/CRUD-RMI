package dao;

import classes.Veiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
            System.err.println("Erro no Adicionar Veiculo: " + e.toString());
        }
    }
    
    public static ArrayList<Veiculo> select(){
        
        ArrayList<Veiculo> veiculos = new ArrayList<>();
        
        String sql = "SELECT * FROM veiculo";
        
        try{
            Connection conexao = ConexaoDB.retornaConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet registro = stmt.executeQuery();
            
            while (registro.next()){
                Veiculo temporario = new Veiculo();
                    temporario.setMarca(registro.getString("marca"));
                    temporario.setModelo(registro.getString("modelo"));
                    temporario.setPlaca(registro.getString("placa"));
                veiculos.add(temporario);
            }
            
            return veiculos;
        } catch(Exception e){
            System.err.println("Erro no Listar Veiculo: " + e.toString());
        }
        
        return null;
    }
    
    public static void delete(int id){
        String sql = "DELETE FROM veiculo WHERE id = ?";
        
        try{
            Connection conexao = ConexaoDB.retornaConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } catch(Exception e) {
            System.err.println("Erro no Excluir Veiculo: " + e.toString());
        }
    }
    
    public void update(){
        
    }
}
