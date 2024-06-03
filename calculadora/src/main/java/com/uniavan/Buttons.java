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
import java.awt.event.*;
import javax.swing.*;

public class Buttons {
    
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[14];

    JButton percentButton = new JButton("%");
    JButton clearEntryButton = new JButton("CE");
    JButton clearAllButton = new JButton("C");
    JButton clearLastButton = new JButton("<--");
    JButton oneDividedByButton = new JButton("1/x");
    JButton powerOfTwoButton = new JButton("Pow(2)");
    JButton sqrtButton = new JButton("Sqrt x");
    JButton divideButton = new JButton("÷");
    JButton multiplyButton = new JButton("×");
    JButton subtractButton = new JButton("-");
    JButton addButton = new JButton("+");
    JButton decimalButton = new JButton(".");
    JButton equalsButton = new JButton("=");
    JButton changeSignButton = new JButton("+/-");

    double num1 = 0.0;
    double num2 = 0.0;
    double result = 0.0;
    int count = 0;
    char operator = '0';
    char lastOperator = '0';
    
    public Buttons(JTextField displayField) {

        functionButtons[0] = percentButton;
        functionButtons[1] = clearEntryButton;
        functionButtons[2] = clearAllButton;
        functionButtons[3] = clearLastButton;
        functionButtons[4] = oneDividedByButton;
        functionButtons[5] = powerOfTwoButton;
        functionButtons[6] = sqrtButton;
        functionButtons[7] = divideButton;
        functionButtons[8] = multiplyButton;
        functionButtons[9] = subtractButton;
        functionButtons[10] = addButton;
        functionButtons[11] = changeSignButton;
        functionButtons[12] = decimalButton;
        functionButtons[13] = equalsButton;
        

        for (int i = 0; i < 14; i++) {
            functionButtons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Action(e, displayField);
                }
            } );
            functionButtons[i].setFocusable(false);
            functionButtons[i].setFont(functionButtons[i].getFont().deriveFont(Font.BOLD));
            functionButtons[i].setBackground(new Color(92, 92, 92));
            functionButtons[i].setEnabled(false);
        }

        equalsButton.setBackground(new Color(38, 116, 170));

        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Action(e, displayField);
                }
            } );
            numberButtons[i].setFocusable(false);
            numberButtons[i].setFont(functionButtons[i].getFont().deriveFont(Font.BOLD));
            numberButtons[i].setBackground(new Color(127, 127, 127));
        }
    }

    public void insertButtons(JPanel keyboardPanel, JTextField displayField) {
        keyboardPanel.add(percentButton);
        keyboardPanel.add(clearEntryButton);
        keyboardPanel.add(clearAllButton);
        keyboardPanel.add(clearLastButton);
        keyboardPanel.add(oneDividedByButton);
        keyboardPanel.add(powerOfTwoButton);
        keyboardPanel.add(sqrtButton);
        keyboardPanel.add(divideButton);
        keyboardPanel.add(numberButtons[7]);
        keyboardPanel.add(numberButtons[8]);
        keyboardPanel.add(numberButtons[9]);
        keyboardPanel.add(multiplyButton);
        keyboardPanel.add(numberButtons[4]);
        keyboardPanel.add(numberButtons[5]);
        keyboardPanel.add(numberButtons[6]);
        keyboardPanel.add(subtractButton);
        keyboardPanel.add(numberButtons[1]);
        keyboardPanel.add(numberButtons[2]);
        keyboardPanel.add(numberButtons[3]);
        keyboardPanel.add(addButton);
        keyboardPanel.add(changeSignButton);
        keyboardPanel.add(numberButtons[0]);
        keyboardPanel.add(decimalButton);
        keyboardPanel.add(equalsButton);
    }

    public void Action(ActionEvent e, JTextField displayField) {

        Operation operation = new Operation();
        
        try {
            for (int i = 0; i < 10; i++) {
                if (e.getSource() == numberButtons[i]) {
                    if (count == 1) {
                        displayField.setText("");
                        count = 0;
                    }
                    displayField.setText(displayField.getText().concat(String.valueOf(i)));
                    if (equalsButton.isEnabled() == false) {
                        for (int j = 0; j < 14; j++) {
                            functionButtons[j].setEnabled(true);
                        }
                    }
                }
            }

            if (e.getSource() == decimalButton) {
                displayField.setText(displayField.getText().concat("."));
            }

            if (e.getSource() == divideButton) {
                num1 = Double.parseDouble(displayField.getText());
                operator = '/';
                displayField.setText(String.valueOf(num1));
                count = 1;
            }

            if (e.getSource() == multiplyButton) {
                num1 = Double.parseDouble(displayField.getText());
                operator = '*';
                displayField.setText(String.valueOf(num1));
                count = 1;
            }

            if (e.getSource() == subtractButton) {
                num1 = Double.parseDouble(displayField.getText());
                operator = '-';
                displayField.setText(String.valueOf(num1));
                count = 1;
            }

            if (e.getSource() == addButton) {
                num1 = Double.parseDouble(displayField.getText());
                operator = '+';
                displayField.setText(String.valueOf(num1));
                count = 1;
            }

            if (e.getSource() == percentButton) {
                num2 = Double.parseDouble(displayField.getText());
                num2 = operation.percentage(num1, num2);
                displayField.setText(String.valueOf(num2));
                count = 1;
            }

            if (e.getSource() == oneDividedByButton) {
                num1 = Double.parseDouble(displayField.getText());
                num1 = operation.oneDividedBy(num1);
                displayField.setText(String.valueOf(num1));
                count = 1;
            }

            if (e.getSource() == powerOfTwoButton) {
                num1 = Double.parseDouble(displayField.getText());
                num1 = operation.powerOfTwo(num1);
                displayField.setText(String.valueOf(num1));
                count = 1;
            }

            if (e.getSource() == sqrtButton) {
                num1 = Double.parseDouble(displayField.getText());
                num1 = operation.sqrt(num1);
                displayField.setText(String.valueOf(num1));
                count = 1;
            }

            if (e.getSource() == changeSignButton) {
                num1 = Double.parseDouble(displayField.getText());
                num1 = operation.changeSign(num1);
                displayField.setText(String.valueOf(num1));
                count = 1;
            }

            if (e.getSource() == equalsButton) {
                if (operator != '=') {
                    num2 = Double.parseDouble(displayField.getText());
                    lastOperator = operator;
                } else {
                    operator = lastOperator;
                }

                switch(operator) {
                    case '/':
                        result = operation.divide(num1, num2);
                        operator = '=';
                        break;
                    case '*':
                        result = operation.multiply(num1, num2);
                        operator = '=';
                        break;
                    case '-':
                        result = operation.subtract(num1, num2);
                        operator = '=';
                        break;
                    case '+':
                        result = operation.sum(num1, num2);
                        operator = '=';
                        break;
                }
                if (lastOperator == '/' && num2 == 0) {
                    displayField.setText("Err Div by 0.");
                    
                    for (int i = 0; i < 14; i++) {
                        functionButtons[i].setEnabled(false);
                    }
                    for (int i = 0; i < 10; i++) {
                        numberButtons[i].setEnabled(false);
                    }
                    clearAllButton.setEnabled(true);

                } else {
                    displayField.setText(String.valueOf(result));
                    num1 = result;
                }
                
            }

            if (e.getSource() == clearAllButton) {
                displayField.setText("");
                num1 = 0.0;
                num2 = 0.0;
                for (int i = 0; i < 14; i++) {
                    functionButtons[i].setEnabled(false);
                }
                for (int i = 0; i < 10; i++) {
                    numberButtons[i].setEnabled(true);
                }
            }

            if (e.getSource() == clearLastButton) {
                String value = displayField.getText();
                displayField.setText("");
                for (int i = 0; i < value.length() - 1; i++) {
                    displayField.setText(displayField.getText()+value.charAt(i));
                }
                if (displayField.getText().length() == 0) {
                    for (int i = 0; i < 14; i++) {
                        functionButtons[i].setEnabled(false);
                    }
                }
            }

            if (e.getSource() == clearEntryButton) {
                if (operator == '0') {
                    displayField.setText("");
                    num1 = 0.0;
                    for (int i = 0; i < 14; i++) {
                        functionButtons[i].setEnabled(false);
                    }
                } else {
                    displayField.setText("");
                    num2 = 0.0;
                    for (int i = 0; i < 14; i++) {
                        functionButtons[i].setEnabled(false);
                    }
                }
            }

        } catch(Exception err){
            System.out.println(err);
            // num1 = num2 = result = 0;
            // displayField.setText("");
        }
    }

}
