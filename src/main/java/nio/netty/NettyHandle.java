package nio.netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.nio.channels.SocketChannel;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/*
 * @breif:
 * @Author: lyq
 * @Date: 2020/7/20 15:07
 * @Month:07
 */
public class NettyHandle extends SimpleChannelInboundHandler {
    private static List<Channel> list=new CopyOnWriteArrayList<>();
    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    NettyHandle(){
  }

    /**
     * 往管道里发送消息
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
      //  System.out.println("hhhh");
      //  System.out.println(channelGroup.size());
        list.forEach(channel->{
              if(ctx.channel() != channel){
                //  System.out.println("发送数据给"+channel.remoteAddress());
                  channel.writeAndFlush(channel.remoteAddress().toString()+":"+msg);
              }

          });

    }

    /**
     * 连接时触发调用
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        list.add(channel);
        System.out.println("[user]"+channel.remoteAddress());
        list.forEach(channels->{
            if(ctx.channel() != channels){
                //  System.out.println("发送数据给"+channel.remoteAddress());
                channels.writeAndFlush(channel.remoteAddress()+"--上线了");
            }

        });
    }

    /**
     * 关闭连接时触发
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        list.remove(channel);
        System.out.println("[user]"+channel.remoteAddress()+"离线");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        Channel channel = ctx.channel();
        list.remove(channel);
        System.out.println("[user]"+channel.remoteAddress()+"[error]"+cause);
    }
}
