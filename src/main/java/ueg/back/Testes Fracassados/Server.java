package ueg.back;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server {

        private List<Observer> observers = new ArrayList<>();

        public void attach(Observer observer) {
            observers.add(observer);
        }

        public void detach(Observer observer) {
            observers.remove(observer);
        }

        public void notifyObservers(String message) {
            for (Observer observer : observers) {
                observer.update(message);
            }
        }

        /*
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server is running...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected");

            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            String message = reader.readLine();
            System.out.println("Message received: " + message);

            writer.println("Message received: " + message);
            socket.close();
        }
    }*/
}