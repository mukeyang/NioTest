package nettyDemo;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.util.CharsetUtil;

/**
 * Created by CS on 2018/4/10.
 */
public class TimeClient {
    public void connect(String host, int port) throws Exception {
        NioEventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group).
                    channel(NioSocketChannel.class)
                    .option(ChannelOption.TCP_NODELAY, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
                            ch.pipeline().addLast(new StringDecoder());
                          ch.pipeline().addLast(new SimpleChannelInboundHandler<String>() {
                              @Override
                              protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
                                  System.out.println("client"+msg);

                              }

//                              @Override
                              protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
                                  System.out.println("client"+msg.toString(CharsetUtil.UTF_8));
                              }

                              @Override
                              public void channelActive(ChannelHandlerContext ctx) throws Exception {
                                  ctx.writeAndFlush(Unpooled.copiedBuffer("hgfjhs"+System.getProperty("line.separator"), CharsetUtil.UTF_8));
                              }
                          });
                        }
                    }).remoteAddress(host, port);
            ChannelFuture sync = bootstrap.connect().sync();
            sync.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        new TimeClient().connect("127.0.0.1",9090);
    }
}
