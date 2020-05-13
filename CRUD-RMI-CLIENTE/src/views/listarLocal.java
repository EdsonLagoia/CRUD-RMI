package views;

import interfaces.InterfaceLocal;
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

public class listarLocal extends JPanel {
    
    private JButton btnAdicionar;
    private JButton btnEditar;
    private JButton btnExcluir;
    
    private static JTable tabela;
    private String[] colunas = {"ID", "CLIENTE", "ENDERECO"};
    private Object[][] dados;    
    private static DefaultTableModel modelo;
    
    public listarLocal() throws NotBoundException, MalformedURLException{
        
        modelo = new DefaultTableModel(dados, colunas);
        
        btnAdicionar = new JButton("Adicionar");
        btnEditar = new JButton("Editar");
        btnExcluir = new JButton("Excluir");
        
        btnAdicionar.addActionListener(new BotaoAdicionarLocalListener());
        btnEditar.addActionListener(new BotaoEditarLocalListener());
        btnExcluir.addActionListener(new BotaoExcluirLocalListener());
        
        try{
            InterfaceLocal localRemoto = (InterfaceLocal) Naming.lookup("rmi://192.168.1.136:1099/Local");  
           
            tabela = new JTable(modelo);
           
            ArrayList<InterfaceLocal> locais = localRemoto.select();
           
            for(InterfaceLocal local: locais){
                String id = Integer.toString(local.getId());
                String cliente = local.getCliente();
                String endereco = local.getEndereco();
             
                String[] registro = new String[]{id, cliente, endereco};   
             
                modelo.addRow(registro);             
            }
            
            add(tabela);
            add(btnAdicionar);
            add(btnEditar);
            add(btnExcluir);
        }catch(RemoteException re){
            
        }
    }
    
    private static class BotaoAdicionarLocalListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            centro.removeAll();
            centro.add( new adicionarLocal());
            centro.repaint();
            centro.validate();
        }
    }

    private static class BotaoEditarLocalListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {}
    }
    
    private static class BotaoExcluirLocalListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int registroSelecionado = tabela.getSelectedRow();
            if(registroSelecionado >= 0){            
                try {
                    int idLocal = Integer.parseInt(tabela.getValueAt(registroSelecionado, 0).toString());
                    
                    InterfaceLocal localRemotoExcluir = (InterfaceLocal) Naming.lookup("rmi://192.168.1.136:1099/Local");
                    
                    localRemotoExcluir.delete(idLocal);
                    modelo.removeRow(registroSelecionado);
                    
                    JOptionPane.showMessageDialog(null, "o Registro foi  excluido");
                } catch (RemoteException ex) {
                    
                } catch (NotBoundException ex) {
                    Logger.getLogger(listarLocal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(listarLocal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Selecione um Registro");
            }
        }
    }
}
