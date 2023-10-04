package ueg.back;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Button implements ActionListener {

}

/*



2

        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;

public class ButtonClickListenerImpl implements ActionListener {
    private ButtonClickListener listener;

    public ButtonClickListenerImpl(ButtonClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (listener != null) {
            listener.onButtonClick(((JButton) e.getSource()).getText());
        }
    }
}



3

// Adicione a implementação do ActionListener na classe Screen
public class Screen extends JFrame implements ButtonClickListener {
    // ...

    public Screen() {
        // ...
        addButtonListeners(new ButtonClickListenerImpl(this));
        // ...
    }

    private void addButtonListeners(ActionListener listener) {
        for (JButton button : buttons) {
            button.addActionListener(listener);
        }
    }

    @Override
    public void onButtonClick(String buttonText) {
        // Lógica para lidar com o clique no botão
        // Você pode implementar a lógica de acordo com suas necessidades
        System.out.println("Botão clicado: " + buttonText);
    }
}

*/