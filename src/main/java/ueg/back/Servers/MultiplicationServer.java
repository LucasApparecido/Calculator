package ueg.back.Servers;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiplicationServer {
    public static void main(String[] args) throws IOException {
        try {
            int port = 12347;
            int result = (int) 0.0;
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Servidor de Soma está ouvindo na porta " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Cliente conectado: " + socket);

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                int number1 = in.readInt();
                int number2 = in.readInt();

                result = number1 * number2;

                out.writeInt((int) result);

                socket.close();
                System.out.println("Cliente desconectado: " + socket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}