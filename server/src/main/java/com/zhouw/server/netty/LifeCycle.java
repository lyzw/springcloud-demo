package com.zhouw.server.netty;

/**
 * //TODO {Please input description here }
 *
 * @author zhouwei
 * @version v1.0
 * @cratedate 2017/10/13.
 * @since v1.0
 */
public interface LifeCycle {

    void shutdown();
    void start();
    void pause();
}
