package edu.blitstein.calc.engine;

import edu.blitstein.calc.exception.DivideByZeroException;

public class Calculator {
    private double result;
    private final double precision = 0.001;

    public Calculator() {
        this(0.0);
    }

    public Calculator(double initialValue) {
        result = initialValue;
    }

    public void reset() {
        result = 0;
    }

    public void setResult(double newResult) {
        result = newResult;
    }

    public double getResult() {
        return result;
    }

    /**
     * Returns n1 op n2, provided op is one of '+', '', '*',or '/'.
     * Any other value of op throws UnknownOpException.
     */
    public double evaluate(char op, double n1, double n2)
            throws DivideByZeroException {
        double answer;
        switch (op) {
            case '+':
                answer = n1 + n2;
                break;
            case '-':
                answer = n1 - n2;
                break;
            case '*':
                answer = n1 * n2;
                break;
            case '/':
                if ((-precision < n2) && (n2 < precision))
                    throw new DivideByZeroException();
                answer = n1 / n2;
                break;
            default:
                throw new UnknownOpException(op);
        }
        return answer;
    }
}
