package edu.blitstein.calc.engine.op;

import edu.blitstein.calc.engine.Calculator;
import edu.blitstein.calc.exception.DivideByZeroException;
import edu.blitstein.calc.exception.UnknownOpException;

import java.util.InputMismatchException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class UnaryCalculatorApp {

        public static void main(String[] args)
                throws DivideByZeroException{
            System.out.println("Calculator is on.");
            System.out.print("Format of each line: ");
            System.out.println("operator space number");
            System.out.println("For example: + 3");
            System.out.println("To end, enter the letter stop.");
            UnaryCalculator clerk = new UnaryCalculator();
            System.out.println("Starting with = " + clerk.getResult());
            System.out.println("");

            String inputFileName = "src/main/resources/" + args[0];
            String outputFileName = "src/main/resources/" + args[1];


            Scanner input = null;
            PrintWriter pw = null;

            try {
                File file = new File(inputFileName);
                input = new Scanner(file);

                pw = new PrintWriter(outputFileName);
                pw.println("Calculator set to 0.0");

                while(input.hasNextLine()){
                    String op = input.next();
                    if (op.equalsIgnoreCase("Stop"))
                        break;
                    else {
                        try {
                            double nextNum = input.nextDouble();
                            double result = clerk.evaluate(op, nextNum);
                            pw.println("result of " + op + " " + nextNum + " = " + result);
                        } catch (DivideByZeroException e) {
                            System.out.println(e.getMessage());
                        } catch (UnknownOpException e) {
                            System.out.println(e.getMessage());
                        } catch (NumberFormatException e) {
                            System.out.println(e.getMessage());
                        } catch (InputMismatchException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }pw.println("The final result is " + clerk.getResult());
                pw.println("Calculator program ending.");
            }catch(FileNotFoundException e){
                e.getMessage();
            }finally{
                if(pw != null){
                    pw.close();
                }if(input != null){
                    input.close();
                }
            }
        }
}

