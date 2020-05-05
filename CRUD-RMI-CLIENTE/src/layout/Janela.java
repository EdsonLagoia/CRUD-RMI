package layout;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import views.adicionarData;
import views.adicionarHora;
import views.adicionarLocal;
import views.adicionarProduto;
import views.adicionarVeiculo;
import views.listarData;
import views.listarHora;
import views.listarLocal;
import views.listarProduto;
import views.listarVeiculo;

public class Janela extends JFrame {
    public JPanel menuAdicionar = new JPanel();
    public JPanel menuListar = new JPanel();
    public JPanel centro = new JPanel();
    
    public GridLayout layoutAdicionar = new GridLayout();
    public GridLayout layoutListar = new GridLayout();
    public BorderLayout layoutJanela = new BorderLayout();
    
    public JButton botaoAdicionarProduto = new JButton("Adicionar Produto");
    public JButton botaoListarProduto = new JButton("Listar Produto");
    public JButton botaoAdicionarData = new JButton("Adicionar Data");
    public JButton botaoListarData = new JButton("Listar Data");
    public JButton botaoAdicionarHora = new JButton("Adicionar Hora");
    public JButton botaoListarHora = new JButton("Listar Hora");
    public JButton botaoAdicionarLocal = new JButton("Adicionar Local");
    public JButton botaoListarLocal = new JButton("Listar Local");
    public JButton botaoAdicionarVeiculo = new JButton("Adicionar Veiculo");
    public JButton botaoListarVeiculo = new JButton("Listar Veiculo");
    
    public Janela(){
        botaoAdicionarProduto.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                centro.removeAll();
                centro.add(new adicionarProduto());
                centro.repaint();
                centro.validate();
            }
        });
        
        botaoListarProduto.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    centro.removeAll();
                    centro.add(new listarProduto());
                    centro.repaint();
                    centro.validate();
                } catch (NotBoundException ex) {
                    Logger.getLogger(Janela.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Janela.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        botaoAdicionarData.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                centro.removeAll();
                centro.add(new adicionarData());
                centro.repaint();
                centro.validate();
            }
        });
        
        botaoListarData.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    centro.removeAll();
                    centro.add(new listarData());
                    centro.repaint();
                    centro.validate();
                } catch (NotBoundException ex) {
                    Logger.getLogger(Janela.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Janela.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        botaoAdicionarHora.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                centro.removeAll();
                centro.add(new adicionarHora());
                centro.repaint();
                centro.validate();
            }
        });
        
        botaoListarHora.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    centro.removeAll();
                    centro.add(new listarHora());
                    centro.repaint();
                    centro.validate();
                } catch (NotBoundException ex) {
                    Logger.getLogger(Janela.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Janela.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        botaoAdicionarLocal.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                centro.removeAll();
                centro.add(new adicionarLocal());
                centro.repaint();
                centro.validate();
            }
        });
        
        botaoListarLocal.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    centro.removeAll();
                    centro.add(new listarLocal());
                    centro.repaint();
                    centro.validate();
                } catch (NotBoundException ex) {
                    Logger.getLogger(Janela.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Janela.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        botaoAdicionarVeiculo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                centro.removeAll();
                centro.add(new adicionarVeiculo());
                centro.repaint();
                centro.validate();
            }
        });
        
        botaoListarVeiculo.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    centro.removeAll();
                    centro.add(new listarVeiculo());
                    centro.repaint();
                    centro.validate();
                } catch (NotBoundException ex) {
                    Logger.getLogger(Janela.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Janela.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        menuAdicionar.setLayout(layoutAdicionar);
        menuAdicionar.add(botaoAdicionarProduto);
        menuAdicionar.add(botaoAdicionarData);
        menuAdicionar.add(botaoAdicionarHora);
        menuAdicionar.add(botaoAdicionarLocal);
        menuAdicionar.add(botaoAdicionarVeiculo);
        menuListar.setLayout(layoutListar);
        menuListar.add(botaoListarProduto);
        menuListar.add(botaoListarData);
        menuListar.add(botaoListarHora);
        menuListar.add(botaoListarLocal);
        menuListar.add(botaoListarVeiculo);
        
        setLayout(layoutJanela);
        add(menuAdicionar, BorderLayout.NORTH);
        add(menuListar, BorderLayout.SOUTH);
        add(centro, BorderLayout.CENTER);
        setSize(1360,720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
