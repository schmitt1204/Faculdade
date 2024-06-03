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

public class Operation {

    public double sum(double num1, double num2) {
        double result = 0.0;

        result = num1 + num2;

        return result;
    }

    public double subtract(double num1, double num2) {
        double result = 0.0;

        result = num1 - num2;

        return result;
    }

    public double multiply(double num1, double num2) {
        double result = 0.0;

        result = num1 * num2;
        
        return result;
    }

    public double divide(double num1, double num2) {
        double result = 0.0;

        result = num1 / num2;

        return result;
    }

    public double oneDividedBy(double num1) {
        double result = 0.0;

        result = 1 / num1;

        return result;
    }

    public double powerOfTwo(double num1) {
        double result = 0.0;

        result = (double) Math.pow(num1, 2);

        return result;
    }

    public double sqrt(double num1) {
        double result = 0.0;

        result = (double) Math.sqrt(num1);

        return result;
    }

    public double changeSign(double num1) {
        double result = 0.0;

        result = num1 * (-1.0);

        return result;
    }
    
    public double percentage(double num1, double num2) {
        double result =0.0;

        result = (num2 / 100) * num1;

        return result;
    }

}
