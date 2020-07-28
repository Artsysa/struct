package nio.tcp;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.sctp.SctpChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import nio.netty.NettyHandle;

/*
 *tcp粘包拆包
 * @author: lyq
 *
 * @date: 2020/7/22 14:33
 */
public class NettyStickAndSplit {

    private Integer port;
    NioEventLoopGroup accept;
    NioEventLoopGroup work;

    NettyStickAndSplit(){
        this.port=9000;
        accept=new NioEventLoopGroup();
        work=new NioEventLoopGroup();
    }

    public void startSocket() throws InterruptedException {
        ServerBootstrap boot = new ServerBootstrap();
        boot.group(accept,work).channel(NioServerSocketChannel.class)
                .localAddress(9000)
               .childOption(ChannelOption.SO_KEEPALIVE,true)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();
                        pipeline.addLast(new TCP_NettyServerHandler());
                    }
                });
        ChannelFuture channel = boot.bind().sync();
        ChannelFuture clos = channel.channel().closeFuture().sync();
      //  ChannelFuture clos = channel.channel().close().sync();
//        ServerBootstrap bootstrap = new ServerBootstrap().group(accept,work)
//                .channel(NioServerSocketChannel.class)
//                .option(ChannelOption.SO_BACKLOG, 128)
//                .childOption(ChannelOption.SO_KEEPALIVE, true)
//                .localAddress(port)
//                .childHandler(new ChannelInitializer<SocketChannel>() {
//
//                    @Override
//                    protected void initChannel(SocketChannel ch) throws Exception {
//
//                        //获取到pipeline
//                        ChannelPipeline pipeline = ch.pipeline();
//
//                        pipeline.addLast(new TCP_NettyServerHandler());
//
//                    }
//                });
//        ChannelFuture sync = bootstrap.bind().sync();
//        ChannelFuture close = sync.channel().closeFuture().sync();
    }

    public static void main(String[] args) throws InterruptedException {
        NettyStickAndSplit server = new NettyStickAndSplit();
        server.startSocket();
    }
}
