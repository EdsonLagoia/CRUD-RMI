package views;

import interfaces.InterfaceData;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class adicionarData extends JPanel implements ActionListener {
    JTextField campo_dia;
    JTextField campo_mes;
    JTextField campo_ano;
    JButton botao_salvar;
    
    public adicionarData(){
        JLabel label_dia = new JLabel("Dia:");
        campo_dia = new JTextField(14);
        JLabel label_mes = new JLabel("Mês:");
        campo_mes = new JTextField(14);
        JLabel label_ano = new JLabel("Ano:");
        campo_ano = new JTextField(14);
        
        botao_salvar = new JButton("Salvar");
        botao_salvar.addActionListener(this);
        
        add(label_dia);
        add(campo_dia);
        add(label_mes);
        add(campo_mes);
        add(label_ano);
        add(campo_ano);
        add(botao_salvar);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String string_dia = campo_dia.getText();
        String string_mes = campo_mes.getText();
        String string_ano = campo_ano.getText();
        
        int dia = Integer.parseInt(string_dia);
        int mes = Integer.parseInt(string_mes);
        int ano = Integer.parseInt(string_ano);
        
        try {
            InterfaceData dataRemoto;
            dataRemoto = (InterfaceData) Naming.lookup("rmi://192.168.1.118:1099/Data");
            
            dataRemoto.setDia(dia);
            dataRemoto.setMes(mes);
            dataRemoto.setAno(ano);
            
            dataRemoto.insert();
            
            String texto_retorno = dataRemoto.getDia()
                    + " / " + dataRemoto.getMes()
                    + " / " + dataRemoto.getAno();
            
            JOptionPane.showMessageDialog(null, texto_retorno, "Data de Entrega", JOptionPane.INFORMATION_MESSAGE);
        } catch(RemoteException re) {
            JOptionPane.showMessageDialog(null, "Erro Remoto:" + re.toString(), "Erro Remoto", JOptionPane.WARNING_MESSAGE);
        } catch (NotBoundException ex) {
            Logger.getLogger(adicionarData.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(adicionarData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
