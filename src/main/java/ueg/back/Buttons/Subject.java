package ueg.back.Buttons;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<Observer> observers = new ArrayList<>();
    private String state;
    private String currentOperator;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setState(String newState) {
        state = newState;
        notifyDisplayObservers();
    }

    public void setCurrentOperator(String operator) {
        currentOperator = operator;
        notifyOperationObservers();
    }

    public void performOperation() {
        // Lógica para realizar a operação com base no operador atual
        // Atualize o estado e notifique os observadores do display
        // Exemplo simples: apenas concatenação, você precisa implementar a lógica apropriada
        state = state + currentOperator;
        notifyDisplayObservers();
    }

    private void notifyDisplayObservers() {
        for (Observer observer : observers) {
            observer.updateDisplay(state);
        }
    }

    private void notifyOperationObservers() {
        for (Observer observer : observers) {
            observer.performOperation(currentOperator);
        }
    }
}
