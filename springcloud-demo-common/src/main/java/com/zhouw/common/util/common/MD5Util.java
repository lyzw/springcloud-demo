package com.zhouw.common.util.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5工具类
 *
 * @author zhouwei
 * @version v1.0
 * @cratedate 2017/5/18.
 * @since v1.0
 */
public class MD5Util {

    /**
     * 获取md5加密后的byte数组
     *
     * @param data 待加密数据
     * @return 加密后的byte数组
     * @throws NoSuchAlgorithmException     {@link NoSuchAlgorithmException}
     * @throws UnsupportedEncodingException {@link UnsupportedEncodingException}
     */
    public static byte[] digest(String data) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        return digest(data, "UTF-8");
    }

    /**
     * 获取md5加密后的byte数组
     *
     * @param data    待加密数据
     * @param charset 字符集
     * @return 加密后的byte数组
     * @throws NoSuchAlgorithmException     {@link NoSuchAlgorithmException}
     * @throws UnsupportedEncodingException {@link UnsupportedEncodingException}
     */
    public static byte[] digest(String data, String charset)
            throws NoSuchAlgorithmException, UnsupportedEncodingException {
        return digest(data.getBytes(charset));
    }

    public static byte[] digest(byte[] data) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] bytes = md.digest(data);
        return bytes;
    }


    /**
     * md5文件
     *
     * @param file    文件
     * @param charset 字符集
     * @return 返回
     */
    public static byte[] digestFile(File file, String charset) throws IOException, NoSuchAlgorithmException {
        if (file == null) {
            throw new IllegalArgumentException("file is null");
        }
        try {
            FileInputStream inputStream = new FileInputStream(file);
            MappedByteBuffer mappedByteBuffer = inputStream.getChannel().map(FileChannel.MapMode.READ_ONLY, 0,
                    file.length());
            return digest(mappedByteBuffer.array());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw e;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw e;
        }
    }

}
