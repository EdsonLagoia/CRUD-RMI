package views;

import interfaces.InterfaceHora;
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

public class listarHora extends JPanel {
    
    private JButton btnAdicionar;
    private JButton btnEditar;
    private JButton btnExcluir;
    
    private static JTable tabela;
    private String[] colunas = {"ID", "HORAS", "MINUTOS"};
    private Object[][] dados;    
    private static DefaultTableModel modelo;
    
    public listarHora() throws NotBoundException, MalformedURLException{
        
        modelo = new DefaultTableModel(dados, colunas);
        
        btnAdicionar = new JButton("Adicionar");
        btnEditar = new JButton("Editar");
        btnExcluir = new JButton("Excluir");
        
        btnAdicionar.addActionListener(new BotaoAdicionarHoraListener());
        btnEditar.addActionListener(new BotaoEditarHoraListener());
        btnExcluir.addActionListener(new BotaoExcluirHoraListener());
        
        try{
            InterfaceHora horaRemoto = (InterfaceHora) Naming.lookup("rmi://192.168.1.136:1099/Hora");  
           
            tabela = new JTable(modelo);
           
            ArrayList<InterfaceHora> horarios = horaRemoto.select();
           
            for(InterfaceHora horario: horarios){
                String id = Integer.toString(horario.getId());
                String horas = Integer.toString(horario.getHoras());
                String minutos = Integer.toString(horario.getMinutos());
             
                String[] registro = new String[]{id, horas, minutos};   
             
                modelo.addRow(registro);             
            }
            
            add(tabela);
            add(btnAdicionar);
            add(btnEditar);
            add(btnExcluir);
        }catch(RemoteException re){
            
        }
    }
    
    private static class BotaoAdicionarHoraListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            centro.removeAll();
            centro.add( new adicionarHora());
            centro.repaint();
            centro.validate();
        }
    }

    private static class BotaoEditarHoraListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {}
    }
    
    private static class BotaoExcluirHoraListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int registroSelecionado = tabela.getSelectedRow();
            if(registroSelecionado >= 0){            
                try {
                    int idHora = Integer.parseInt(tabela.getValueAt(registroSelecionado, 0).toString());
                    
                    InterfaceHora horaRemotoExcluir = (InterfaceHora) Naming.lookup("rmi://192.168.1.136:1099/Hora");
                    
                    horaRemotoExcluir.delete(idHora);
                    modelo.removeRow(registroSelecionado);
                    
                    JOptionPane.showMessageDialog(null, "o Registro foi  excluido");
                } catch (RemoteException ex) {
                    
                } catch (NotBoundException ex) {
                    Logger.getLogger(listarHora.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(listarHora.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Selecione um Registro");
            }
        }
    }
}
