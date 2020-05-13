package layout;

import java.awt.BorderLayout;
import java.awt.Component;
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
import views.adicionarProduto;
import views.listarData;
import views.listarHora;
import views.listarLocal;
import views.listarProduto;
import views.listarVeiculo;

public class Janela extends JFrame {

    public JPanel menuTopo = new JPanel();
    public JPanel menuBase = new JPanel();
    public static JPanel centro = new JPanel();

    public GridLayout layoutTopo = new GridLayout();
    public GridLayout layoutBase = new GridLayout();
    public BorderLayout layoutJanela = new BorderLayout();

    public JButton botaoProduto = new JButton("Produtos");
    public JButton botaoData = new JButton("Data");
    public JButton botaoHora = new JButton("Hora");
    public JButton botaoLocal = new JButton("Local");
    public JButton botaoVeiculo = new JButton("Veiculo");

    public Janela() {

        botaoProduto.addActionListener(new ActionListener() {
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

        botaoData.addActionListener(new ActionListener() {
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

        botaoHora.addActionListener(new ActionListener() {
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

        botaoLocal.addActionListener(new ActionListener() {
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

        botaoVeiculo.addActionListener(new ActionListener() {
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

        menuTopo.setLayout(layoutTopo);
        menuTopo.add(botaoProduto);
        menuTopo.add(botaoData);
        menuTopo.add(botaoHora);

        menuBase.setLayout(layoutBase);
        menuBase.add(botaoLocal);
        menuBase.add(botaoVeiculo);

        setLayout(layoutJanela);
        add(menuTopo, BorderLayout.NORTH);
        add(menuBase, BorderLayout.SOUTH);

        add(centro, BorderLayout.CENTER);
        setSize(1000, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
