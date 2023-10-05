package ueg.back;

class AddCommand implements Command {
    private int a, b;
    private Calculator1 calculator;

    public AddCommand(int a, int b, Calculator1 calculator) {
        this.a = a;
        this.b = b;
        this.calculator = calculator;
    }

    public void execute() {
        int result = calculator.add(a, b);
    }
}
