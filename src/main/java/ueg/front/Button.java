package ueg.front;


import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button {

  // screen = new Screen();



}

private class ButtonClickListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.equals("=")) {
            try {
                String expression = display.getText();
                double result = eval(expression);
                display.setText(Double.toString(result));
            } catch (Exception ex) {
                display.setText("Erro");
            }
        } else if (command.equals("C")) {
            display.setText("");
        } else {
            display.setText(display.getText() + command);
        }
    }

    private double eval(String expression) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        try {
            Object result = engine.eval(expression);
            if (result instanceof Number) {
                return ((Number) result).doubleValue();
            } else {
                throw new IllegalArgumentException("Expressão inválida");
            }
        } catch (ScriptException e) {
            throw new IllegalArgumentException("Erro na expressão");
        }
    }
}