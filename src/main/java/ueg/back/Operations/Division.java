package ueg.back.Operations;

public class Division implements Operation{
    @Override
    public double calculate(double a, double b) {
        if (b != 0) {
            return a / b;
        }
        else {
            throw new ArithmeticException("Divisão por zero");
        }
    }
}
