package com.netty.http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestServer {

    private static final Logger LOG = LoggerFactory.getLogger(TestServer.class);

    public static void main(String[] args) throws Exception {

        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new TestServerInitializer());

            bind(serverBootstrap, 1000);

//            ChannelFuture channelFuture = serverBootstrap.bind(6668)
//                    .addListener(future -> {
//                        if (future.isSuccess()) {
//                            System.out.println("端口绑定成功!");
//                        } else {
//                            System.err.println("端口绑定失败!");
//                        }
//                    })
//                    .sync();
//
//            channelFuture.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    private static void bind(ServerBootstrap bootstrap, int port) {
        bootstrap.bind(port)
                .addListener((ChannelFutureListener) future -> {
                    if (future.isSuccess()) {
                        LOG.info("端口 {} 绑定成功!", port);
                    } else {
                        LOG.warn("端口 {} 绑定失败!", port);
                        bind(bootstrap, port + 1);
                    }
                });
    }
}
