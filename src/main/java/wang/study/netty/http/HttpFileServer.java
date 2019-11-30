package wang.study.netty.http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;



/**
 * @author whl
 * @date 2019/10/12 7:40 下午
 *
 *  文件服务器开发
 */
public class HttpFileServer {

    private static final String DEFAULT_PATH = "/src/main/java/wang/study/netty";

    public void run(final int port, final String url) throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel socketChannel) throws Exception {
                    socketChannel.pipeline().addLast("http-decoder", new HttpRequestDecoder());
                    socketChannel.pipeline().addLast("http-aggregator", new HttpObjectAggregator(65535));
                    socketChannel.pipeline().addLast("http-encoder", new HttpResponseEncoder());
                    socketChannel.pipeline().addLast("http-chunked", new ChunkedWriteHandler());
                    socketChannel.pipeline().addLast("fileServerHandler", new HttpFileServerHandler(url));
                }
            });

            ChannelFuture future = b.bind("127.0.0.1", port).sync();
            System.out.println("Http 文件目录服务器启动，网址是：http://127.0.0.1:" + port + url);
            future.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        new HttpFileServer().run(8080, DEFAULT_PATH);
    }
}
