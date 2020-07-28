package nio.netty;

/*
 * @breif:
 * @Author: lyq
 * @Date: 2020/7/20 14:58
 * @Month:07
 */

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class GroupNettyServer {
    private Integer port;
    private NioEventLoopGroup accept;
    private NioEventLoopGroup work;
    public GroupNettyServer(Integer port){
        this.port = port;
        accept = new NioEventLoopGroup(1);
        work   = new NioEventLoopGroup();
    }

    public void startServer() throws InterruptedException {
        ServerBootstrap bootstrap = new ServerBootstrap().group(accept,work)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 128)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .localAddress(port)
                .childHandler(new ChannelInitializer<SocketChannel>() {

                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {

                        //获取到pipeline
                        ChannelPipeline pipeline = ch.pipeline();
                        //向pipeline加入解码器
                        pipeline.addLast("decoder", new StringDecoder());
                        //向pipeline加入编码器
                        pipeline.addLast("encoder", new StringEncoder());
                        //加入自己的业务处理handler
                        pipeline.addLast(new NettyHandle());

                    }
                });
        ChannelFuture sync = bootstrap.bind().sync();
        ChannelFuture close = sync.channel().closeFuture().sync();
    }

    public static void main(String[] args) throws InterruptedException {
        GroupNettyServer groupNettyServer = new GroupNettyServer(9000);
        groupNettyServer.startServer();
    }
}
