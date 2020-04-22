package layout;

import javax.swing.JFrame;
import views.adicionarVeiculo;

public class janelaVeiculo extends JFrame {
    public janelaVeiculo(){
        add(new adicionarVeiculo());
        setSize(280, 225);
        show();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
