package ueg.back;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

public class ButtonListener implements ActionListener {
    private Calculator calculator;
    private Display display;

    public ButtonListener(Calculator calculator, Display display) {
        this.calculator = calculator;
        this.display = display;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonText = e.getActionCommand();
        switch (buttonText) {
            case "+":
            case "-":
            case "*":
            case "/":
                calculator.setOperation(buttonText);
                break;
            case "C":
                calculator.clear();
                break;
            case ".":
                calculator.setOperand(Double.parseDouble(buttonText));
                break;
            default:
                calculator.setOperand(Double.parseDouble(buttonText));
                calculator.calculateResult();
                break;
        }
    }
}
