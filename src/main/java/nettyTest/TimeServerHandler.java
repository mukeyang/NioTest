package nettyTest;

import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by CS on 2018/4/6.
 */
public class TimeServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(final ChannelHandlerContext ctx) throws Exception {
//        ByteBuf buffer = ctx.alloc().buffer(4);
//        buffer.writeInt((int) (System.currentTimeMillis() / 1000L + 2208988800L));
//        ChannelFuture channelFuture = ctx.writeAndFlush(buffer);
//        channelFuture.addListener(new ChannelFutureListener() {
//            public void operationComplete(ChannelFuture channelFuture) throws Exception {
//                ctx.close();
//            }
//        });
//        channelFuture.addListener(ChannelFutureListener.CLOSE);
        ctx.channel().writeAndFlush(new UnixTime()).addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//        super.exceptionCaught(ctx, cause);
        cause.printStackTrace();
        ctx.close();
    }
}
