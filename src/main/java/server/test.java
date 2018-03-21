package server;

import java.nio.ByteBuffer;
import java.util.Scanner;

/**
 * Created by CS on 2018/3/21.
 */
public class test {
    public static void main(String[] args) {
        ByteBuffer wrap = ByteBuffer.wrap("231".getBytes());
//        wrap.flip();

        System.out.println(wrap.position()+""+wrap.limit());
        System.out.println(new Scanner(System.in).nextLine());
    }
}
