package ueg.back.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class CalculatorServer {
    private ServerSocket serverSocket;
    private List<String> operationsToSend;

    public CalculatorServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        operationsToSend = new ArrayList<>();
    }

    public void start() {
        System.out.println("Server is listening on port " + serverSocket.getLocalPort());

        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                new Thread(new ClientHandler(clientSocket, operationsToSend)).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Método para adicionar operações à lista
    public synchronized void addOperation(String operation) {
        operationsToSend.add(operation);
    }

    public static void main(String[] args) {
        try {
            CalculatorServer server = new CalculatorServer(8888);
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
