package com.zhouw.server.netty.server;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * //TODO {Please input description here }
 *
 * @author zhouwei
 * @version v1.0
 * @cratedate 2017/10/19.
 * @since v1.0
 */

public class BizServerHandler extends SimpleChannelInboundHandler<String> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {

    }
}
