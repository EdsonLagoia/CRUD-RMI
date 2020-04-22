package layout;

import javax.swing.JFrame;
import views.adicionarHora;

public class janelaHora extends JFrame {
    public janelaHora(){
        add(new adicionarHora());
        setSize(180, 175);
        show();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
