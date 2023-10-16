package ueg.back.Servers;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SubtractionServer {
    public static void main(String[] args) throws IOException {

        try {
            int port = 12348;
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Servidor de Subtração está ouvindo na porta " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Cliente conectado: " + socket);

                try (DataInputStream in = new DataInputStream(socket.getInputStream());
                     DataOutputStream out = new DataOutputStream(socket.getOutputStream())
                ) {
                    socket.setSoTimeout(5000);

                    System.out.println("Aguardando a leitura dos números");
                    int number1 = in.readInt();
                    int number2 = in.readInt();
                    System.out.println("Números lidos: " + number1 + ", " + number2);

                    // Realize a operação de subtração
                    int result = number1 - number2;

                    // Envie o resultado de volta para o cliente
                    out.writeInt(result);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    socket.close();
                    System.out.println("Cliente desconectado: " + socket);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
