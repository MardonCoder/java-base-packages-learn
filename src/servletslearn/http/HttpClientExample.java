package servletslearn.http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

public class HttpClientExample {
    public static void main(String[] args) throws IOException, InterruptedException {
        try(var httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1).build()){
            HttpRequest request = HttpRequest.newBuilder(URI.create("https://www.google.com")).GET()
                    .build();
            var response = httpClient.send(request, BodyHandlers.ofString());
            System.out.println(response.body());
            System.out.println(response.headers());
        } catch (IOException | InterruptedException e){
            throw e;
        }
    }
}
//12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678