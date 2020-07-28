package nio.tcp;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/*
 * @author: lyq
 * @date: 2020/7/22 14:53
 */
public class ClientTCP {
    private String host;
    private Integer port;
    NioEventLoopGroup work;

    ClientTCP(){
        this.host="127.0.0.1";
        this.port=9000;
        work=new NioEventLoopGroup();
    }

    public void startClient() throws InterruptedException {
        Bootstrap boot = new Bootstrap();
        boot.group(work).channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();
                        pipeline.addLast(new TCP_NettyClientHandler());
                    }
                });
        ChannelFuture conn = boot.connect(host,port).sync();
        ChannelFuture close = conn.channel().close().sync();
    }

    public static void main(String[] args) throws InterruptedException {
        ClientTCP client = new ClientTCP();
        client.startClient();
    }
}
