package edu.blitstein.calc;

import edu.blitstein.calc.calculator.Calculator;
import edu.blitstein.calc.exception.DivideByZeroException;

import java.util.Scanner;

public class CalculatorApp {

    //Numbers this close to zero are treated as if equal to zero.
    public static void main(String[] args)
            throws DivideByZeroException {
        System.out.println("Calculator is on.");
        System.out.print("Format of each line: ");
        System.out.println("operator space number");
        System.out.println("For example: + 3");
        System.out.println("To end, enter the letter e.");
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter initial value: ");
        double initialValue = keyboard.nextDouble();
        Calculator clerk = new Calculator(initialValue);
        System.out.println("Starting with = " + clerk.getResult());
        boolean done = false;
        while (!done) {
            char nextOp = (keyboard.next()).charAt(0);
            if ((nextOp == 'e') || (nextOp == 'E'))
                done = true;
            else {
                double nextNumber = keyboard.nextDouble();
                double result = clerk.evaluate(nextOp, clerk.getResult(), nextNumber);
                System.out.println("result " + nextOp + " " + nextNumber + " = " + result);
                System.out.println("updated result = " + result);
            }
        }
        System.out.println("The final result is " + clerk.getResult());
        System.out.println("Calculator program ending.");
    }
}