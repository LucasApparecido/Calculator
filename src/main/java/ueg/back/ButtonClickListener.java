/*

import ueg.back.ButtonProcessor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Implementação específica para processamento de adição
public class AddButtonProcessor implements ButtonProcessor {
    @Override
    public void processButtonClick(String buttonText) {
        // Lógica para adição
        // Exemplo: exibir no visor ou realizar cálculos
        System.out.println("Operação de adição");
    }
}

// Implementação específica para processamento de igual
public class EqualButtonProcessor implements ButtonProcessor {
    @Override
    public void processButtonClick(String buttonText) {
        // Lógica para igual
        // Exemplo: realizar o cálculo final
        System.out.println("Operação de igual");
    }
}


public class ButtonClickListener implements ActionListener {
    private ButtonProcessorFactory processorFactory;

    public ButtonClickListener() {
        this.processorFactory = new ButtonProcessorFactory();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton sourceButton = (JButton) e.getSource();
        String buttonText = sourceButton.getText();

        // Obtém o processador correspondente ao botão
        ButtonProcessor processor = processorFactory.createProcessor(buttonText);

        // Chama o método de processamento
        if (processor != null) {
            processor.onButtonClick(buttonText);
        }
    }
}


class ButtonProcessorFactory {
    public ButtonProcessor createProcessor(String buttonText) {
        switch (buttonText) {
            case "+":
                return new AddButtonProcessor();
            // Adicione mais casos para outros botões, se necessário
            default:
                return null; // Nenhum processador encontrado
        }
    }
}
*/