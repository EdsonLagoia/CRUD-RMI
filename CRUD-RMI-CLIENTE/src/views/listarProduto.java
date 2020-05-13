package views;

import interfaces.InterfaceProduto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static layout.Janela.centro;

public class listarProduto extends JPanel {
    
    private JButton btnAdicionar;
    private JButton btnEditar;
    private JButton btnExcluir;
    
    private static JTable tabela;
    private String[] colunas = {"ID", "DESCRICAO", "PRECO", "QUANTIDADE"};
    private Object[][] dados;    
    private static DefaultTableModel modelo;
    
    public listarProduto() throws NotBoundException, MalformedURLException{
        
        modelo = new DefaultTableModel(dados, colunas);
        
        btnAdicionar = new JButton("Adicionar");
        btnEditar = new JButton("Editar");
        btnExcluir = new JButton("Excluir");
        
        btnAdicionar.addActionListener(new BotaoAdicionarProdutoListener());
        btnEditar.addActionListener(new BotaoEditarProdutoListener());
        btnExcluir.addActionListener(new BotaoExcluirProdutoListener());
        
        try{
            InterfaceProduto produtoRemoto = (InterfaceProduto) Naming.lookup("rmi://192.168.1.136:1099/Produto");  
           
            tabela = new JTable(modelo);
           
            ArrayList<InterfaceProduto> produtos = produtoRemoto.select();
           
            for(InterfaceProduto produto: produtos){
                String id = Integer.toString(produto.getId());
                String descricao = produto.getDescricao();
                String preco = Double.toString(produto.getPreco());
                String quantidade = Integer.toString(produto.getQuantidade());
             
                String[] registro = new String[]{id, descricao, preco, quantidade};   
             
                modelo.addRow(registro);             
            }
            
            add(tabela);
            add(btnAdicionar);
            add(btnEditar);
            add(btnExcluir);
        }catch(RemoteException re){
            
        }
    }
    
    private static class BotaoAdicionarProdutoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            centro.removeAll();
            centro.add( new adicionarProduto());
            centro.repaint();
            centro.validate();
        }
    }

    private static class BotaoEditarProdutoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {}
    }
    
    private static class BotaoExcluirProdutoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int registroSelecionado = tabela.getSelectedRow();
            if(registroSelecionado >= 0){            
                try {
                    int idProduto = Integer.parseInt(tabela.getValueAt(registroSelecionado, 0).toString());
                    
                    InterfaceProduto produtoRemotoExcluir = (InterfaceProduto) Naming.lookup("rmi://192.168.1.136:1099/Produto");
                    
                    produtoRemotoExcluir.delete(idProduto);
                    modelo.removeRow(registroSelecionado);
                    
                    JOptionPane.showMessageDialog(null, "o Registro foi  excluido");
                } catch (RemoteException ex) {
                    
                } catch (NotBoundException ex) {
                    Logger.getLogger(listarProduto.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(listarProduto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Selecione um Registro");
            }
        }
    }
}
