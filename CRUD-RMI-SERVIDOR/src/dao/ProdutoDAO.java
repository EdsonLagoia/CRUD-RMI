package dao;

import classes.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProdutoDAO {
    public static void insert(Produto produto){
        String sql = "INSERT Into produto (descricao, preco, quantidade) VALUES (?, ?, ?)";
        
        try {
            Connection conexao = ConexaoDB.retornaConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, produto.getDescricao());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getQuantidade());
            stmt.execute();
        } catch(Exception e) {
            System.err.println("Erro no Adicionar Produto: " + e.toString());
        }
    }
    
    public static ArrayList<Produto> select(){
        
        ArrayList<Produto> produtos = new ArrayList<>();
        
        String sql = "SELECT * FROM produto";
        
        try{
            Connection conexao = ConexaoDB.retornaConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet registro = stmt.executeQuery();
            
            while (registro.next()){
                Produto temporario = new Produto();
                        temporario.setDescricao(registro.getString("descricao"));
                        temporario.setPreco(registro.getDouble("preco"));
                        temporario.setQuantidade(registro.getInt("quantidade"));
                produtos.add(temporario);
            }
            
            return produtos;
        } catch(Exception e){
            System.err.println("Erro no Listar Produto: " + e.toString());
        }
        
        return null;
    }
    
    public static void delete(int id){
        String sql = "DELETE FROM produto WHERE id = ?";
        
        try{
            Connection conexao = ConexaoDB.retornaConexao();
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } catch(Exception e) {
            System.err.println("Erro no Excluir Produto: " + e.toString());
        }
    }
    
    public void update(){
        
    }
}
