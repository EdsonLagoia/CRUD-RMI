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
            System.err.println("Erro na função insert: " + e.toString());
        }
    }
    
    public void update(){
        
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
            System.err.println("Erro na Listagem de Produto: " + e.toString());
        }
        
        return null;
    }
    
    public void delete(){
        
    }
}
