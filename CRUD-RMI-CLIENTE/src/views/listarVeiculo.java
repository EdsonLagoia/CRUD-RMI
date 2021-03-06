package views;

import interfaces.InterfaceVeiculo;
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

public class listarVeiculo extends JPanel {
    
    private JButton btnAdicionar;
    private JButton btnEditar;
    private JButton btnExcluir;
    
    private static JTable tabela;
    private String[] colunas = {"ID", "MARCA", "MODELO", "PLACA"};
    private Object[][] dados;    
    private static DefaultTableModel modelo;
    
    public listarVeiculo() throws NotBoundException, MalformedURLException{
        
        modelo = new DefaultTableModel(dados, colunas);
        
        btnAdicionar = new JButton("Adicionar");
        btnEditar = new JButton("Editar");
        btnExcluir = new JButton("Excluir");
        
        btnAdicionar.addActionListener(new BotaoAdicionarVeiculoListener());
        btnEditar.addActionListener(new BotaoEditarVeiculoListener());
        btnExcluir.addActionListener(new BotaoExcluirVeiculoListener());
        
        try{
            InterfaceVeiculo veiculoRemoto = (InterfaceVeiculo) Naming.lookup("rmi://192.168.1.136:1099/Veiculo");  
           
            tabela = new JTable(modelo);
           
            ArrayList<InterfaceVeiculo> veiculos = veiculoRemoto.select();
           
            for(InterfaceVeiculo veiculo: veiculos){
                String id = Integer.toString(veiculo.getId());
                String marca = veiculo.getMarca();
                String modelos = veiculo.getModelo();
                String placa = veiculo.getPlaca();
             
                String[] registro = new String[]{id, marca, modelos, placa};   
             
                modelo.addRow(registro);             
            }
            
            add(tabela);
            add(btnAdicionar);
            add(btnEditar);
            add(btnExcluir);
        }catch(RemoteException re){
            
        }
    }
    
    private static class BotaoAdicionarVeiculoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            centro.removeAll();
            centro.add( new adicionarVeiculo());
            centro.repaint();
            centro.validate();
        }
    }

    private static class BotaoEditarVeiculoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {}
    }
    
    private static class BotaoExcluirVeiculoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int registroSelecionado = tabela.getSelectedRow();
            if(registroSelecionado >= 0){            
                try {
                    int idVeiculo = Integer.parseInt(tabela.getValueAt(registroSelecionado, 0).toString());
                    
                    InterfaceVeiculo veiculoRemotoExcluir = (InterfaceVeiculo) Naming.lookup("rmi://192.168.1.136:1099/Veiculo");
                    
                    veiculoRemotoExcluir.delete(idVeiculo);
                    modelo.removeRow(registroSelecionado);
                    
                    JOptionPane.showMessageDialog(null, "o Registro foi  excluido");
                } catch (RemoteException ex) {
                    
                } catch (NotBoundException ex) {
                    Logger.getLogger(listarVeiculo.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(listarVeiculo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Selecione um Registro");
            }
        }
    }
}
