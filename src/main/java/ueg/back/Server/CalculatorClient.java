package ueg.back.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345);



            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
