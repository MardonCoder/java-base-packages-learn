import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;

public class JavaNetLearn {
    public static void main(String[] args) {
        try(Socket s = new Socket("whois.internic.net", 43)){
            InputStream in = s.getInputStream();
            OutputStream out = s.getOutputStream();

            String url = "youtube.com\n";
            byte[] urlByte = url.getBytes();
            out.write(urlByte);

            int c;
            while((c = in.read())!= -1){
                System.out.print((char) c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
