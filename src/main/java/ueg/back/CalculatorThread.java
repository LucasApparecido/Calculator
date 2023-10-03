package ueg.back;

public class CalculatorThread extends Thread {
    private final String operation;
    private final int num1, num2;

    public CalculatorThread(String operation, int num1, int num2) {
        this.operation = operation;
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public void run() {
        int result = switch (operation) {
            case "somar" -> Operations.addition(num1, num2);
            case "subtrair" -> Operations.subtraction(num1, num2);
            case "multiplicar" -> Operations.multiplication(num1, num2);
            case "dividir" -> Operations.division(num1, num2);
            default -> 0;
        };

        System.out.println("Resultado da operação " + operation + ": " + result);
    }
}
