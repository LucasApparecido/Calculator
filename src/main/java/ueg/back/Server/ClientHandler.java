package ueg.back.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class ClientHandler implements Runnable {
    private Socket clientSocket;
    private List<String> operationsToSend;

    public ClientHandler(Socket clientSocket, List<String> operationsToSend) {
        this.clientSocket = clientSocket;
        this.operationsToSend = operationsToSend;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

            // Processa as operações recebidas do servidor
            for (String operation : operationsToSend) {
                // Aqui, você poderia implementar a lógica de processamento da operação no cliente
                // Por enquanto, apenas imprime no console
                System.out.println("Client received operation: " + operation);
            }

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
