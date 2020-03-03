package edu.blitstein.calc.engine.op;

public enum BinaryOperation {
    PLUS("+") {
          double apply(double x, double y) {
            return x + y;
          }
        },
    TIMES("*") {
          double apply(double x, double y) {
            return x * y;
          }
        };

    private final String symbol;

    BinaryOperation(String symbol) {
      this.symbol = symbol;
    }

    @Override
    public String toString() {
      return symbol;
    }

    abstract double apply(double x, double y) throws ArithmeticException;
}