package views;

import interfaces.InterfaceProduto;
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

public class adicionarProduto extends JPanel implements ActionListener {
    JTextField campo_nome;
    JTextField campo_preco;
    JTextField campo_quantidade;
    JButton botao_salvar;
    
    public adicionarProduto(){
        JLabel label_nome = new JLabel("Nome:");
        campo_nome = new JTextField(20);
        JLabel label_preco = new JLabel("Preço:");
        campo_preco = new JTextField(20);
        JLabel label_quantidade = new JLabel("Quantidade:");
        campo_quantidade = new JTextField(20);
        
        botao_salvar = new JButton("Salvar");
        botao_salvar.addActionListener(this);
        
        add(label_nome);
        add(campo_nome);
        add(label_preco);
        add(campo_preco);
        add(label_quantidade);
        add(campo_quantidade);
        add(botao_salvar);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String string_nome = campo_nome.getText();
        String string_preco = campo_preco.getText();
        String string_quantidade = campo_quantidade.getText();
        
        String descricao = string_nome;
        double preco = Double.parseDouble(string_preco);
        int quantidade = Integer.parseInt(string_quantidade);
        
        try {
            InterfaceProduto produtoRemoto;
            produtoRemoto = (InterfaceProduto) Naming.lookup("rmi://192.168.1.118:1099/Produto");
            
            produtoRemoto.setDescricao(descricao);
            produtoRemoto.setPreco(preco);
            produtoRemoto.setQuantidade(quantidade);
            
            produtoRemoto.insert();
            
            String texto_retorno = "\n Descrição: " + produtoRemoto.getDescricao()
                    + "\n Preço: " + produtoRemoto.getPreco()
                    + "\n Quantidade: " + produtoRemoto.getQuantidade();
            
            JOptionPane.showMessageDialog(null, texto_retorno, "Dados do Produto", JOptionPane.INFORMATION_MESSAGE);
        } catch(RemoteException re) {
            JOptionPane.showMessageDialog(null, "Erro Remoto:" + re.toString(), "Erro Remoto", JOptionPane.WARNING_MESSAGE);
        } catch (NotBoundException ex) {
            Logger.getLogger(adicionarProduto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(adicionarProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
