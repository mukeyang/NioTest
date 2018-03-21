package server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by CS on 2018/3/21.
 */
public class NioTcpServer {
    public static final int PORT = 5555;
    private static ByteBuffer buffer = ByteBuffer.allocate(10240);

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(PORT));
        serverSocketChannel.configureBlocking(false);
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("server start on port" + PORT + "...");
        while (true) {
            int n = selector.select();
            if (n == 0) continue;
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                if (selectionKey.isAcceptable()) {
                    ServerSocketChannel channel = (ServerSocketChannel) selectionKey.channel();
                    SocketChannel accept = channel.accept();
                    accept.configureBlocking(false);
                    accept.register(selector, selectionKey.OP_READ);
                    new Thread(new SendRunnable(accept)).start();
                    System.out.println("remote" + accept.getRemoteAddress());
                }
                if (selectionKey.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    socketChannel.socket().setReceiveBufferSize(102400);
                    processByHead(socketChannel);
//                    processByFixLength(socketChannel);
//                    processNormally(socketChannel);

                }
                iterator.remove();
            }
        }
    }

    private static class SendRunnable implements Runnable {

        private SocketChannel socketChannel;

        public SendRunnable(SocketChannel socketChannel) {
            this.socketChannel = socketChannel;
        }

        public void run() {
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            Scanner in = new Scanner(System.in);
            while (true) {
                try {
                    String msg = in.nextLine();
                    System.out.println(msg);
                    ByteBuffer wrap = ByteBuffer.wrap(msg.getBytes());
//                    System.out.println(wrap.position()+""+wrap.limit());
//                    wrap.flip();
                    System.out.println(wrap.position()+""+wrap.limit());

                    System.out.println(wrap.remaining());
                    while (wrap.hasRemaining())
                        this.socketChannel.write(wrap);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void processNormally(SocketChannel channel) throws IOException {
        StringBuilder sb = new StringBuilder();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int count;
        while ((count = channel.read(buffer)) > 0) {
            buffer.flip();
            sb.append(new String(buffer.array()));
            buffer.clear();
        }
        if (count == -1) {
            System.out.println(channel.getRemoteAddress() + "closed");
        }
        System.out.println(sb.toString() + ";;;;;");
    }

    private static void processByHead(SocketChannel channel) throws IOException {
        int count;
        while ((count = channel.read(buffer)) > 0) {
            int position = buffer.position();
            int limit = buffer.limit();
            buffer.flip();
            if (buffer.remaining() < 4) {
                buffer.position(position).limit(limit);
                continue;
            }
            int length = buffer.getInt();
            if (buffer.remaining() < length) {
                buffer.position(position).limit(limit);
                continue;
            }
            byte[] data = new byte[length];

            buffer.get(data, 0, length);
            System.out.println(new String(data) + " <---> " );
            buffer.compact();
        }
        if (count == -1) {
            System.out.println(channel.getRemoteAddress() + "closed");
        }
    }
    private static void processByFixLength(SocketChannel socketChannel) throws IOException {
        int count;

        while ((count=socketChannel.read(buffer)) > 0) {

            buffer.flip();
            while (buffer.remaining() >= 32) {
                byte[] data = new byte[32];
                buffer.get(data, 0, 32);
                System.out.println(new String(data) + " <---> " );
            }
            buffer.compact();
        }
        if (count == -1) {
            System.out.println(socketChannel.getRemoteAddress() + "closed");
        }
    }
}
