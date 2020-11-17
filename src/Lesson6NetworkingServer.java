import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Lesson6NetworkingServer {

    public static void main(String[] args) throws IOException {

        String arg = "";
        int portNumber = 0;
        int i = 0;

        while (i < args.length) {
            if (args[i].equalsIgnoreCase("--port")) {
                portNumber = Integer.parseInt(args[i + 1]);
            }
            i++;
        }

        try (ServerSocket s = new ServerSocket(portNumber)) {
            System.out.println("Server Running on Port: " + portNumber);
            try(Socket socketConnection = s.accept()){
                System.out.println("Made Connection");
                PrintWriter writer = new PrintWriter(socketConnection.getOutputStream());
                writer.print("HTTP/1.1 200\r\n");
                writer.print("Content-Type: text/html\r\n\r\n\r\n");
                writer.print("<html>\r\n" +
                        "<head><title>Java Networking</title></head>\r\n" +
                        "<body>\r\n" +
                        "<h1>Java Networking</h1>\r\n" +
                        "</body>\r\n" +
                        "</html>\r\n");

                writer.flush();

                System.out.println("Now closing connection");
                writer.close();
            }
        }catch(IOException e){
            e.printStackTrace();
        }

    }

}
