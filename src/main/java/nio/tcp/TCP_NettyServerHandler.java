package nio.tcp;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/*
 * @author: lyq
 * @date: 2020/7/22 14:50
 */
public class TCP_NettyServerHandler extends SimpleChannelInboundHandler<ByteBuf> {


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("来人了");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        byte[] b=new byte[msg.readableBytes()];
        msg.readBytes(b);
        System.out.println(new String(b));
    }
}
