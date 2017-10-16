package com.zhouw.common.util.common;

import sun.misc.BASE64Encoder;

import static org.junit.Assert.*;

/**
 * //TODO {Please input description here }
 *
 * @author zhouwei
 * @version v1.0
 * @cratedate 2017/9/21.
 * @since v1.0
 */
public class MD5UtilTest {
    @org.junit.Test
    public void digest() throws Exception {
        System.out.println(MD5Util.digest("第三方士大夫".getBytes("utf-8")));
    }

    @org.junit.Test
    public void digest1() throws Exception {
    }

    @org.junit.Test
    public void digest2() throws Exception {
    }

    @org.junit.Test
    public void digestFile() throws Exception {
    }

}