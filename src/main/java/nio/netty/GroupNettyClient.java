package nio.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Scanner;

/*
 * @breif:
 * @Author: lyq
 * @Date: 2020/7/20 15:24
 * @Month:07
 */
public class GroupNettyClient {
    private String host;
    private Integer port;
    private NioEventLoopGroup work;

    public GroupNettyClient(String host, Integer port) {
        this.host = host;
        this.port = port;
        this.work = new NioEventLoopGroup();
    }

    public void startClient() throws InterruptedException {
        Bootstrap bootstrap = new Bootstrap().group(work)   .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {

                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {

                        //得到pipeline
                        ChannelPipeline pipeline = ch.pipeline();
                        //加入相关handler
                        pipeline.addLast("decoder", new StringDecoder());
                        pipeline.addLast("encoder", new StringEncoder());
                        //加入自定义的handler
                        pipeline.addLast(new NettyHandleClient());
                    }
                });
        ChannelFuture conn = bootstrap.connect(host, port).sync();
        Channel channel = conn.channel();
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String msg = scanner.next();
            channel.writeAndFlush(msg);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        GroupNettyClient client = new GroupNettyClient("127.0.0.1", 9000);
        client.startClient();
    }
}
