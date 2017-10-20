package com.zhouw.server.netty.server;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * //TODO {Please input description here }
 *
 * @author zhouwei
 * @version v1.0
 * @cratedate 2017/10/19.
 * @since v1.0
 */
public class BizServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        // 以("\n")为结尾分割的 解码器
        pipeline.addLast("framer", new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));

        // 字符串解码 和 编码
        pipeline.addLast("decoder", new StringDecoder());
        pipeline.addLast("encoder", new StringEncoder());

        // 加入自定义的Handler
        pipeline.addLast("handler", new BizServerHandler());
        //初始化类一般都是先加入编码解码器来解读传输来的消息，然后加入自定义类来处理业务逻
    }
}
