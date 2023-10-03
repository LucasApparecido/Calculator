package ueg.front;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Screen extends JFrame {
    private JTextField display;
    private JButton[] buttons;

    public static final int width = 350;
    public static final int height = 550;

    public Screen() {
        setTitle("Calculadora");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(Screen.width, Screen.height);
        setResizable(false);
        setLocation(100, 100);
        getContentPane().setLayout(new BorderLayout());
        setIconImage(new ImageIcon("./logo.png").getImage());

        buildLayout();

        setVisible(true);
    }

    private void buildLayout() {
        // Painel principal para conter todos os componentes
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Visor
        display = new JTextField();
        display.setFont(new Font("Times New Roman", Font.BOLD, 24));
        display.setHorizontalAlignment(JTextField.RIGHT);
        setDisplaySize(display, 300, 50);
        mainPanel.add(display, BorderLayout.NORTH);

        // Painel para os botões numéricos e de operação
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 4, 4)); // 4 linhas, 4 colunas

        // Rótulos para os botões
        String[] buttonLabels = {
                "+", "7", "8", "9",
                "-", "4", "5", "6",
                "*", "1", "2", "3",
                "/", ".", "0", "C"
        };

        // Adicionar botões ao painel
        buttons = new JButton[buttonLabels.length];
        for (int i = 0; i < buttonLabels.length; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            buttons[i].setFont(new Font("Times New Roman", Font.BOLD, 18));
            setButtonSize(buttons[i], 70, 70); // Define o tamanho desejado para cada botão
            buttonPanel.add(buttons[i]);
        }

        // Adicionar o painel de botões ao painel principal
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        // Botão de igual
        JButton buttonEqual = new JButton("=");
        buttonEqual.setFont(new Font("Times New Roman", Font.BOLD, 24));
        setButtonSize(buttonEqual, 70, 70); // Define o tamanho desejado para o botão de igual
        mainPanel.add(buttonEqual, BorderLayout.SOUTH);

        // Adicionar o painel principal ao JFrame
        getContentPane().add(mainPanel);
    }

    private void setButtonSize(JButton button, int width, int height) {
        button.setPreferredSize(new Dimension(width, height));
    }

    private void setDisplaySize(JTextField display, int width, int height) {
        display.setPreferredSize(new Dimension(width, height));
    }
}