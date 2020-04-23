package views;

import interfaces.InterfaceVeiculo;
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

public class adicionarVeiculo extends JPanel implements ActionListener {
    JTextField campo_marca;
    JTextField campo_modelo;
    JTextField campo_placa;
    JButton botao_salvar;
    
    public adicionarVeiculo(){
        JLabel label_marca = new JLabel("Marca:");
        campo_marca = new JTextField(20);
        JLabel label_modelo = new JLabel("Modelo:");
        campo_modelo = new JTextField(20);
        JLabel label_placa = new JLabel("Placa:");
        campo_placa = new JTextField(20);
        
        botao_salvar = new JButton("Salvar");
        botao_salvar.addActionListener(this);
        
        add(label_marca);
        add(campo_marca);
        add(label_modelo);
        add(campo_modelo);
        add(label_placa);
        add(campo_placa);
        add(botao_salvar);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String string_marca = campo_marca.getText();
        String string_modelo = campo_modelo.getText();
        String string_placa = campo_placa.getText();
        
        String marca = string_marca;
        String modelo = string_modelo;
        String placa = string_placa;
        
        try {
            InterfaceVeiculo veiculoRemoto;
            veiculoRemoto = (InterfaceVeiculo) Naming.lookup("rmi://192.168.1.118:1099/Veiculo");
            
            veiculoRemoto.setMarca(marca);
            veiculoRemoto.setModelo(modelo);
            veiculoRemoto.setPlaca(placa);
            
            veiculoRemoto.insert();
            
            String texto_retorno = veiculoRemoto.getMarca()
                    + "\n" + veiculoRemoto.getModelo()
                    + "\n" + veiculoRemoto.getPlaca();
            
            JOptionPane.showMessageDialog(null, texto_retorno, "Veículo da Entrega", JOptionPane.INFORMATION_MESSAGE);
        } catch(RemoteException re) {
            JOptionPane.showMessageDialog(null, "Erro Remoto:" + re.toString(), "Erro Remoto", JOptionPane.WARNING_MESSAGE);
        } catch (NotBoundException ex) {
            Logger.getLogger(adicionarVeiculo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(adicionarVeiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
