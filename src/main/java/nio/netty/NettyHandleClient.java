package nio.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/*
 * @breif:
 * @Author: lyq
 * @Date: 2020/7/20 16:04
 * @Month:07
 */
public class NettyHandleClient extends SimpleChannelInboundHandler {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("[form]"+msg);
    }
}
