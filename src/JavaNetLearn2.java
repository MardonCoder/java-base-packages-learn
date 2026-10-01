import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.Socket;

public class JavaNetLearn2 {
    public static void main(String[] args) throws IOException {

        var inetAddress = Inet4Address.getByName("google.com");
        try (var socket = new Socket(inetAddress, 80);
             var outputStream = new DataOutputStream(socket.getOutputStream());
             var inputStream = new DataInputStream(socket.getInputStream())) {
            outputStream.writeUTF("Hello world!");
            var response = inputStream.readAllBytes();
            System.out.println(response.length);
        }
    }
}
