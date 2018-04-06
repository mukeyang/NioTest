package server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.util.ByteProcessor;
import io.netty.util.CharsetUtil;

/**
 * Created by CS on 2018/3/21.
 */
public class test {
    public static void main(String[] args) {
//        ByteBuffer wrap = ByteBuffer.wrap("231".getBytes());
////        wrap.flip();
//
//        System.out.println(wrap.position()+""+wrap.limit());
        ByteBuf buf = Unpooled.copiedBuffer("12341", CharsetUtil.UTF_8);
        System.out.println(buf.maxCapacity());
        System.out.println(ByteBufUtil.hexDump(buf));
        System.out.println("find" + buf.forEachByte(ByteProcessor.FIND_CR));
//        System.out.println(new Scanner(System.in).nextLine());
        for (int i = 0; i < buf.capacity(); i++) {
            System.out.println((char) buf.getByte(i));
            System.out.println(buf.readerIndex());
            System.out.println(buf.writerIndex());
        }
        ByteBuf buf2 = Unpooled.copiedBuffer("12341", CharsetUtil.UTF_8);
    }
}
