package layout;

import javax.swing.JFrame;
import views.adicionarData;

public class janelaData extends JFrame {
    public janelaData(){
        add(new adicionarData());
        setSize(185, 225);
        show();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
