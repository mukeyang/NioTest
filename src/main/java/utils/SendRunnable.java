package utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by CS on 2018/3/21.
 */
public class SendRunnable {
    private DataOutputStream dos;

    public SendRunnable(DataOutputStream dos) {
        this.dos = dos;
    }

    public void run() {

        while (true) {
            BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in));
            try {
                String msgToSend = bufReader.readLine();
                dos.writeUTF(msgToSend);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
