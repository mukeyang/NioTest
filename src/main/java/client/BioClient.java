package client;

import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by CS on 2018/3/21.
 */
public class BioClient {
    public static final int PORT = 5555;

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress(InetAddress.getLocalHost(), PORT));
        Scanner in = new Scanner(socket.getInputStream());
        Scanner scanner = new Scanner(System.in);
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        boolean done = false;
        while (!done && in.hasNextLine()) {
            String line = in.nextLine();
            System.out.println(line);
            if (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                out.println(s);
                out.flush();
                if (s.trim().equals("88")) break;
            }
        }
    }
}
