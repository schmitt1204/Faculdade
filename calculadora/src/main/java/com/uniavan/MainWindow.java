/********************************************************************
* OS: Windows 11 Home                                               *
* Java version: 22.0.0                                              *
* Data: 02/jun/2024                                                 *
* Autor: Leandro Mengarda Schmitt                                   *
* Materia: Programacao 1                                            *
* Professor: Cristiano R. Siebert                                   *
*                                                                   *
********************************************************************/

package com.uniavan;

import java.awt.*;
import javax.swing.*;

public class MainWindow {
    
    private JFrame window;

    public MainWindow() {
        initialize();
    }

    private void initialize() {
        window = new JFrame();
        window.setIconImage(new ImageIcon(getClass().getResource("../image/calc.png")).getImage());
        window.setTitle("Calculadora");
        window.setLayout(new BorderLayout(10, 10));
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(325, 500);
        window.setResizable(false);
        window.setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu1_Opcoes = new JMenu("Opcoes");
        JMenuItem menu1_item1_Padrao = new JMenuItem("Padrao");
        JMenuItem menu1_item2_Cientifica = new JMenuItem("Cientifica");
        JMenu menu1_submenu1_Converter = new JMenu("Converter");
        JMenuItem menu1_submenu1_item1_Medida = new JMenuItem("Medida");
        JMenuItem menu1_submenu1_item2_Peso = new JMenuItem("Peso");
        JMenuItem menu1_submenu1_item3_Temperatura = new JMenuItem("Temperatura");

        menu1_item2_Cientifica.setEnabled(false);
        menu1_submenu1_item1_Medida.setEnabled(false);
        menu1_submenu1_item2_Peso.setEnabled(false);
        menu1_submenu1_item3_Temperatura.setEnabled(false);

        {
            menu1_Opcoes.add(menu1_item1_Padrao);   
            menu1_Opcoes.add(menu1_item2_Cientifica);
            menu1_Opcoes.add(menu1_submenu1_Converter);
                {
                menu1_submenu1_Converter.add(menu1_submenu1_item1_Medida);
                menu1_submenu1_Converter.add(menu1_submenu1_item2_Peso);
                menu1_submenu1_Converter.add(menu1_submenu1_item3_Temperatura);
                }
        }
        menuBar.add(menu1_Opcoes);
        
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
        
        JTextField displayField = new JTextField();    
        //displayField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        displayField.setFont(displayField.getFont().deriveFont(50f));
        displayField.setEditable(false);

        JPanel keyboardPanel = new JPanel(new GridLayout(6, 4, 5, 5));
        
        Buttons keyboardButtons = new Buttons(displayField);
        keyboardButtons.insertButtons(keyboardPanel, displayField);

        Calculate calculate = new Calculate();
        calculate.check_x(displayField, keyboardButtons);

        window.add(displayField, BorderLayout.NORTH);
        window.add(keyboardPanel, BorderLayout.CENTER);
        window.setJMenuBar(menuBar);

    }

    public void show() {
        //window.pack();
        window.setVisible(true);
    }



}
