package com.zhouw.springclouddemo.config;

import com.alibaba.fastjson.JSON;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.TreeMap;

import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.BASE64Encoder;

/**
 * //TODO {Please input description here }
 *
 * @author zhouwei
 * @version v1.0
 * @cratedate 2017/8/14.
 * @since v1.0
 */
@SpringBootApplication
@EnableConfigServer
@EnableAutoConfiguration
@RestController
@EnableDiscoveryClient
public class ConfigApplication {
    public static String OA_MERCODE = "100001";
    public static String OA_SECRECT_KEY = "TQoXpYDyQW6YDAqqgsV9jQ==";
    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String requestValue = "{\"mercode\":\"100001\",\"requestTime\":\"20170822172134\",\"page\":\"1\",\"pageSize\":\"100\"}";
        //加密后的字符串
        TreeMap map = JSON.parseObject(requestValue,TreeMap.class);
        map.put("mercode",OA_MERCODE);
        map.put("secret",OA_SECRECT_KEY);
        String newstr=byte2hex(getMD5Digest(JSON.toJSONString(map)));
        System.out.println(newstr);
//        SpringApplication.run(ConfigApplication.class,args);
    }


    private static byte[] getMD5Digest(String data) {

        byte[] bytes = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            bytes = md.digest(data.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return bytes;
    }

    private static String byte2hex(byte[] bytes) {

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() == 1) {
                stringBuilder.append("0");
            }
            stringBuilder.append(hex.toUpperCase());
        }
        return stringBuilder.toString();
    }
}
