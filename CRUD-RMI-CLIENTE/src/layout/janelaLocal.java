package layout;

import javax.swing.JFrame;
import views.adicionarLocal;

public class janelaLocal extends JFrame {
    public janelaLocal(){
        add(new adicionarLocal());
        setSize(600, 200);
        show();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
