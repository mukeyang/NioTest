package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by CS on 2018/3/21.
 */
public class BioTcpServer {
    public static final int Port=5555;
    public static final String Msg="from server: ";

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(Port);
            while (true) {
                Socket accept = server.accept();
                System.out.println("ip addr"+accept.getRemoteSocketAddress());
                new Thread(new handler(accept)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

class handler implements Runnable {
    public handler(Socket incoming) {
        this.incoming = incoming;
    }

    private Socket incoming;
    public void run() {
        try {
            try {
                InputStream in = incoming.getInputStream();
                OutputStream out = incoming.getOutputStream();
                Scanner scanner = new Scanner(in);
                PrintWriter writer = new PrintWriter(out, true);
                writer.println("say bey to exit");
                boolean done = false;
                while (!done && scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    System.out.println(line);
                    writer.println(BioTcpServer.Msg+ line);
                    if (line.trim().equals("88")) done=true;
                }
            } finally {
                incoming.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}