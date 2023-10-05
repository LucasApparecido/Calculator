package ueg.back;

public class Client extends Observer {
    private String name;

    public Client(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received message: " + message);
    }
}