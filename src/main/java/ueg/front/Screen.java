package ueg.front;

import ueg.back.ConnectOperation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Screen extends JFrame {
    private static Screen instance;
    private JTextField display;
    private JButton[] buttons;
    private JButton buttonEqual;

    private String[] buttonLabels;

    private JPanel mainPanel;
    private JPanel buttonPanel;

    private Action actionListener;

    public static final int width = 350;
    public static final int height = 550;

    private Screen() {
        setTitle("Calculadora");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(Screen.width, Screen.height);
        setResizable(false);
        setLocation(100, 100);
        getContentPane().setLayout(new BorderLayout());
        setIconImage(new ImageIcon(getClass().getResource("/icon.png")).getImage());

        actionListener = new Action();

        buildLayout();


        setVisible(true);
    }

    public static Screen getInstance() {
        if (instance == null) {
            instance = new Screen();
        }
        return instance;
    }

    private void buildLayout() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        display = new JTextField();
        display.setFont(new Font("Times New Roman", Font.BOLD, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setPreferredSize(new Dimension(300, 50));
        display.setBackground(new Color(252, 252, 252));
        display.setForeground(new Color(4, 42, 43));
        display.setEnabled(false);
        mainPanel.add(display, BorderLayout.NORTH);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4)); // 4 linhas, 4 colunas

        buttonLabels = new String[]{
                "+", "7", "8", "9",
                "-", "4", "5", "6",
                "*", "1", "2", "3",
                "/", ".", "0", "C",
        };

        buttons = new JButton[buttonLabels.length];
        for (int i = 0; i < buttonLabels.length; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            buttons[i].setFont(new Font("Times New Roman", Font.BOLD, 24));
            buttons[i].setPreferredSize(new Dimension(70, 70)); // Define o tamanho desejado para cada botão

            if (buttonLabels[i].equals("C")) {
                buttons[i].setForeground(new Color(4, 42, 43));
                buttons[i].setBackground(new Color(244, 224, 77));
                buttons[i].addActionListener(actionListener);
            } else if (buttonLabels[i].matches("[0-9]")) {
                buttons[i].setForeground(new Color(4, 42, 43));
                buttons[i].setBackground(new Color(84, 242, 242));
                buttons[i].addActionListener(actionListener);
            } else if (buttonLabels[i].matches("[+\\-*./]")) {
                buttons[i].setForeground(new Color(252, 252, 252));
                buttons[i].setBackground(new Color(94, 177, 191));
                buttons[i].addActionListener(actionListener);
            }
            buttonPanel.add(buttons[i]);
        }

        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        buttonEqual = new JButton("=");
        buttonEqual.setFont(new Font("Times New Roman", Font.BOLD, 30));
        buttonEqual.setPreferredSize(new Dimension(70, 70));  // Define o tamanho desejado para o botão de igual
        buttonEqual.setForeground(new Color(252, 252, 252));
        buttonEqual.setBackground(new Color(4, 42, 43));
        buttonEqual.addActionListener(actionListener);
        mainPanel.add(buttonEqual, BorderLayout.SOUTH);

        getContentPane().add(mainPanel);
    }

    class Action implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            String buttonText = source.getText();

            if (display.getText().equals("Sem operador")) {
                display.setText("");
            } else if (display.getText().equals("Divisão por zero")) {
                display.setText("");
            } else if (display.getText().equals("Servidor não encontrado")) {
                display.setText("");
            }

            switch (buttonText) {
                case "+":
                    display.setText(display.getText() + " " + buttonText + " ");
                    break;
                case "-":
                    display.setText(display.getText() + " " + buttonText + " ");
                    break;
                case "*":
                    display.setText(display.getText() + " " + buttonText + " ");
                    break;
                case "/":
                    display.setText(display.getText() + " " + buttonText + " ");
                    break;
                case ".":
                    display.setText(display.getText() + buttonText);
                    break;
                case "=":
                    try {
                        calculateResult();
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    break;
                case "C":
                    display.setText("");
                    break;
                default:
                    // Assume que é um número
                    display.setText(display.getText() + buttonText);
                    break;
            }
        }

        private void calculateResult() throws Exception {
            String expression = display.getText();

            String[] parts = expression.split(" ");

            if (parts.length != 3) {
                // Expressão inválida
                display.setText("Sem operador");
                return;
            }

            String operator = parts[1];

            float result = 0.0F;


            switch (operator) {
                case "+":
                    result = ConnectOperation.execute(Float.parseFloat(parts[0]), Float.parseFloat(parts[2]), 12345);
                    break;
                case "-":
                    result = ConnectOperation.execute(Float.parseFloat(parts[0]), Float.parseFloat(parts[2]), 12348);
                    break;
                case "*":
                    result = ConnectOperation.execute(Float.parseFloat(parts[0]), Float.parseFloat(parts[2]), 12347);
                    break;
                case "/":
                    if(Integer.parseInt(parts[2]) == 0) {
                        display.setText("Divisão por zero");
                        throw new IllegalArgumentException("Divisão por zero não permitida.");
                    }
                    result = ConnectOperation.execute(Float.parseFloat(parts[0]), Float.parseFloat(parts[2]), 12346);
                    break;
            }

            display.setText(String.valueOf(result));
        }

    }

    public void setDisplay(String text){
        display.setText(text);
    }
}
