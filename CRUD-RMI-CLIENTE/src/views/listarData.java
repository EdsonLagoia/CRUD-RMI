package views;

import interfaces.InterfaceData;
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

public class listarData extends JPanel {
    
    private JButton btnAdicionar;
    private JButton btnEditar;
    private JButton btnExcluir;
    
    private static JTable tabela;
    private String[] colunas = {"ID", "DIA", "MES", "ANO"};
    private Object[][] dados;    
    private static DefaultTableModel modelo;
    
    public listarData() throws NotBoundException, MalformedURLException{
        
        modelo = new DefaultTableModel(dados, colunas);
        
        btnAdicionar = new JButton("Adicionar");
        btnEditar = new JButton("Editar");
        btnExcluir = new JButton("Excluir");
        
        btnAdicionar.addActionListener(new BotaoAdicionarDataListener());
        btnEditar.addActionListener(new BotaoEditarDataListener());
        btnExcluir.addActionListener(new BotaoExcluirDataListener());
        
        try{
            InterfaceData dataRemoto = (InterfaceData) Naming.lookup("rmi://192.168.1.136:1099/Data");  
           
            tabela = new JTable(modelo);
           
            ArrayList<InterfaceData> datas = dataRemoto.select();
           
            for(InterfaceData data: datas){
                String id = Integer.toString(data.getId());
                String dia = Integer.toString(data.getDia());
                String mes = Integer.toString(data.getMes());
                String ano = Integer.toString(data.getAno());
             
                String[] registro = new String[]{id, dia, mes, ano};   
             
                modelo.addRow(registro);             
            }
            
            add(tabela);
            add(btnAdicionar);
            add(btnEditar);
            add(btnExcluir);
        }catch(RemoteException re){
            
        }
    }
    
    private static class BotaoAdicionarDataListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            centro.removeAll();
            centro.add( new adicionarData());
            centro.repaint();
            centro.validate();
        }
    }

    private static class BotaoEditarDataListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {}
    }
    
    private static class BotaoExcluirDataListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int registroSelecionado = tabela.getSelectedRow();
            if(registroSelecionado >= 0){            
                try {
                    int idData = Integer.parseInt(tabela.getValueAt(registroSelecionado, 0).toString());
                    
                    InterfaceData dataRemotoExcluir = (InterfaceData) Naming.lookup("rmi://192.168.1.136:1099/Data");
                    
                    dataRemotoExcluir.delete(idData);
                    modelo.removeRow(registroSelecionado);
                    
                    JOptionPane.showMessageDialog(null, "o Registro foi  excluido");
                } catch (RemoteException ex) {
                    
                } catch (NotBoundException ex) {
                    Logger.getLogger(listarData.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(listarData.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Selecione um Registro");
            }
        }
    }
}
