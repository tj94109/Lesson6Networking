import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Lesson6NetworkingClient {

    public static void main(String[] args){

        String arg = "";
        String server = "";
        int portNumber = 0;

        int i = 0;

        while (i < args.length) {
            if(args[i].equalsIgnoreCase("--server"))
                server = args[i+1];
            if (args[i].equalsIgnoreCase("--port")) {
                portNumber = Integer.parseInt(args[i + 1]);
            }
            i++;
        }

        try {
            Socket s = new Socket(server,portNumber);
            Scanner scanner = new Scanner(s.getInputStream(),"UTF-8");
            while(scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
