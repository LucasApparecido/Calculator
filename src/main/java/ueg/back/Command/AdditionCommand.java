package ueg.back.Command;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

public class AdditionCommand implements Command{
    public static int execute(int operand1, int operand2) throws IllegalArgumentException, IOException {

        int result = 0;

        try (Socket socket = new Socket("localhost", 12345);
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream())
        ) {
            out.writeInt(operand1);
            out.writeInt(operand2);
            out.flush();

            result = in.readInt();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}