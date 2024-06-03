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

import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;

public class Launcher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        try {
                            UIManager.setLookAndFeel(info.getClassName());
                        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                                | UnsupportedLookAndFeelException e) {
                            e.printStackTrace();
                        }
                        break;
                    }
                }

                MainWindow mainFrame = new MainWindow();
                mainFrame.show();
            }
        });
    }
}