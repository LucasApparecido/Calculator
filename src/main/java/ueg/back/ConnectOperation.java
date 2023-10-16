package ueg.back;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ConnectOperation {
    public static float execute(float operand1, float operand2, int port) throws IOException {
        try (Socket socket = new Socket("localhost", port);
             DataOutputStream out = new DataOutputStream(socket.getOutputStream());
             DataInputStream in = new DataInputStream(socket.getInputStream())
        ) {
            out.writeFloat(operand1);
            out.writeFloat(operand2);
            out.flush();

            float result = in.readFloat();

            socket.close();

            return result;
        }
    }
}
