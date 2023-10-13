package ueg.back.Operations;

public class CalculatorFactory {
    public static Operation getOperation(String operation) {
        switch (operation) {
            case "+":
                return new Addition();
            case "-":
                return new Subtraction();
            case "*":
                return new Multiplication();
            case "/":
                return new Division();
            default:
                throw new IllegalArgumentException("Operação não suportada: " + operation);
        }
    }
}
