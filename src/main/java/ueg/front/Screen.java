package ueg.front;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Screen extends JFrame {
    private JTextField display;
    private JTextField displayHistory;
    private JButton[] buttons;

    public static final int width = 350;
    public static final int height = 550;

    private ActionListener actionListener;

    public Screen() {

        setTitle("Calculadora");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(Screen.width, Screen.height);
        setResizable(false);
        setLocation(100, 100);

        getContentPane().setLayout(new BorderLayout());
        setIconImage(new ImageIcon("./logo.png").getImage());
        // actionListener = new ActionListenerBotoes();

        buildlayout();

        setVisible(true);
    }


    private void buildlayout () {
        // Painel principal para conter todos os componentes
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new BorderLayout());


        /*displayHistory = new JTextField();
        displayHistory.setFont(new Font("Arial", Font.PLAIN, 18));
        displayHistory.setHorizontalAlignment(JTextField.RIGHT);
        displayPanel.add(displayHistory, BorderLayout.NORTH);*/

        // Visor
        display = new JTextField();
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        displayPanel.add(display, BorderLayout.SOUTH);

        mainPanel.add(displayPanel, BorderLayout.NORTH);

        // Painel para os botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 5, 5)); // 5 linhas, 4 colunas

        // Rótulos para os botões
        String[] buttonLabels = {
                "CE", "C", "DEL", "/",
                "7", "8", "9", "*",
                "4", "5", "6", "-",
                "1", "2", "3", "+",
                "H", "0", ".", "="
        };

        // Adicionar botões ao painel
        buttons = new JButton[buttonLabels.length];
        for (int i = 0; i < buttonLabels.length; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 18));
            buttonPanel.add(buttons[i]);
        }

        // Adicionar o painel de botões ao painel principal
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        // Adicionar o painel principal ao JFrame
        getContentPane().add(mainPanel);
    }
}
