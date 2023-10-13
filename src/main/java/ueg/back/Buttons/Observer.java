package ueg.back.Buttons;

public interface Observer {
    void updateDisplay(String newState);
    void performOperation(String operation);
}
