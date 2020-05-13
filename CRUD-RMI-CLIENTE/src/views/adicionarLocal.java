package views;

import interfaces.InterfaceLocal;
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

public class adicionarLocal extends JPanel implements ActionListener {
    JTextField campo_cliente;
    JTextField campo_endereco;
    JButton botao_salvar;
    
    public adicionarLocal(){
        JLabel label_cliente = new JLabel("Cliente:");
        campo_cliente = new JTextField(50);
        JLabel label_endereco = new JLabel("Endereço:");
        campo_endereco = new JTextField(50);
        
        botao_salvar = new JButton("Salvar");
        botao_salvar.addActionListener(this);
        
        add(label_cliente);
        add(campo_cliente);
        add(label_endereco);
        add(campo_endereco);
        add(botao_salvar);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String string_cliente = campo_cliente.getText();
        String string_endereco = campo_endereco.getText();
        
        String cliente = string_cliente;
        String endereco = string_endereco;
        
        try {
            InterfaceLocal localRemoto;
            localRemoto = (InterfaceLocal) Naming.lookup("rmi://192.168.1.136:1099/Local");
            
            localRemoto.setCliente(cliente);
            localRemoto.setEndereco(endereco);
            
            localRemoto.insert();
            
            String texto_retorno = "\n Cliente: " + localRemoto.getCliente()
                    + "\n Endereço: " + localRemoto.getEndereco();
            
            JOptionPane.showMessageDialog(null, texto_retorno, "Cliente", JOptionPane.INFORMATION_MESSAGE);
        } catch(RemoteException re) {
            JOptionPane.showMessageDialog(null, "Erro Remoto:" + re.toString(), "Erro Remoto", JOptionPane.WARNING_MESSAGE);
        } catch (NotBoundException ex) {
            Logger.getLogger(adicionarLocal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(adicionarLocal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
