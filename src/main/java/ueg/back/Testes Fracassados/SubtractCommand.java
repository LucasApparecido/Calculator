package ueg.back;

class SubtractCommand implements Command {
    private int a, b;
    private Calculator1 calculator;

    public SubtractCommand(int a, int b, Calculator1 calculator) {
        this.a = a;
        this.b = b;
        this.calculator = calculator;
    }

    public void execute() {
        int result = calculator.subtract(a, b);
    }
}