package utils;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by CS on 2018/3/21.
 */
public class PrintRunnable {private DataInputStream dis;
    private String remoteName;

    public PrintRunnable(DataInputStream dis, String remoteName) {
        this.dis = dis;
        this.remoteName = remoteName;
    }

    public void run() {

        while (true) {
            try {
                String msgReceived = dis.readUTF();
                System.out.println(this.remoteName + " : " + msgReceived);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
