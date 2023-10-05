package ueg.back;

import java.util.Observer;
import java.util.Observable;
import javax.swing.JTextField;

public class Display implements Observer {
    private JTextField display;

    public Display(JTextField display) {
        this.display = display;
    }

    @Override
    public void update(Observable o, Object arg) {
        display.setText(String.valueOf(arg));
    }
}
