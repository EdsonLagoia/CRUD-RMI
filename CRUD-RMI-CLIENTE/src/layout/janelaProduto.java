package layout;

import javax.swing.JFrame;
import views.adicionarProduto;

public class janelaProduto extends JFrame {
    public janelaProduto(){
        add(new adicionarProduto());
        setSize(280, 225);
        show();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
