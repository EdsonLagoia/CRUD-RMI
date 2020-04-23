package views;

import interfaces.InterfaceHora;
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

public class adicionarHora extends JPanel implements ActionListener {
    JTextField campo_horas;
    JTextField campo_minutos;
    JButton botao_salvar;
    
    public adicionarHora(){
        JLabel label_horas = new JLabel("Hora(as):");
        campo_horas = new JTextField(10);
        JLabel label_minutos = new JLabel("Minuto(os):");
        campo_minutos = new JTextField(10);
        
        botao_salvar = new JButton("Salvar");
        botao_salvar.addActionListener(this);
        
        add(label_horas);
        add(campo_horas);
        add(label_minutos);
        add(campo_minutos);
        add(botao_salvar);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String string_horas = campo_horas.getText();
        String string_minutos = campo_minutos.getText();
        
        int horas = Integer.parseInt(string_horas);
        int minutos = Integer.parseInt(string_minutos);
        
        try {
            InterfaceHora horaRemoto;
            horaRemoto = (InterfaceHora) Naming.lookup("rmi://192.168.1.118:1099/Hora");
            
            horaRemoto.setHoras(horas);
            horaRemoto.setMinutos(minutos);
            
            horaRemoto.insert();
            
            String texto_retorno = horaRemoto.getHoras()
                    + ":" + horaRemoto.getMinutos();
            
            JOptionPane.showMessageDialog(null, texto_retorno, "Horario de Entrega", JOptionPane.INFORMATION_MESSAGE);
        } catch(RemoteException re) {
            JOptionPane.showMessageDialog(null, "Erro Remoto:" + re.toString(), "Erro Remoto", JOptionPane.WARNING_MESSAGE);
        } catch (NotBoundException ex) {
            Logger.getLogger(adicionarHora.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(adicionarHora.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
