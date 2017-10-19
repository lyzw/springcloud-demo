package com.zhouw.common.util.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * //TODO {Please input description here }
 *
 * @author zhouwei
 * @version v1.0
 * @cratedate 2017/10/18.
 * @since v1.0
 */
public class StreamUtil {

    public static byte[] readBytes(InputStream inputStream) throws IOException {
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        return bytes;
    }
}
