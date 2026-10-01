package servletslearn.server;

import java.io.IOException;
import java.net.ServerSocket;

public class HttpServer {
    private final int PORT;

    public HttpServer(int port){
        this.PORT = port;
    }

    public void run(){
        try {
            var server = new ServerSocket(PORT);
            var socket = server.accept();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
