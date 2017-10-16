package com.zhouw.common.util.http;


import com.zhouw.common.util.common.StringUtil;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;


public class HttpsUtil {
    private static final String METHOD_POST = "POST";
    private static final String DEFAULT_CHARSET = "utf-8";
    private static final int connectTimeout = 6000;
    private static final int readTimeout = 6000;

    public static String doPost(String url, String str) {
        String charset = DEFAULT_CHARSET;
        String ctype = "application/json;charset=" + charset;
        HttpsURLConnection conn = null;
        OutputStream out = null;
        String rsp = null;
        byte[] content = null;
        try {
            content = str.getBytes(charset);
            SSLContext ctx = SSLContext.getInstance("TLS");
            ctx.init(new KeyManager[0], new TrustManager[] { new DefaultTrustManager() }, new SecureRandom());
            SSLContext.setDefault(ctx);


            conn = getConnection(new URL(url), METHOD_POST, ctype);
            conn.setHostnameVerifier(new HostnameVerifier() {


                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
            conn.setConnectTimeout(connectTimeout);
            conn.setReadTimeout(readTimeout);


            out = conn.getOutputStream();
            out.write(content);
            rsp = getResponseAsString(conn);
        } catch (Exception e) {
//            log.error("REQUEST_RESPONSE_ERROR, URL = " + url, e);
        } finally {
            try {
                if (out != null)out.close();
                if (conn != null)conn.disconnect();
            } catch (Exception e) {
//                log.error("REQUEST_RESPONSE_ERROR, URL = " + url, e);
            }
        }


        return rsp;
    }

    public static String get(String path) throws Exception{
        HttpsURLConnection httpConn=null;
        BufferedReader in=null;
        try {
            URL url=new URL(path);
            httpConn=(HttpsURLConnection)url.openConnection();


            //读取响应
            if(httpConn.getResponseCode()==200){
                StringBuffer content=new StringBuffer();
                String tempStr="";
                in=new BufferedReader(new InputStreamReader(httpConn.getInputStream()));
                while((tempStr=in.readLine())!=null){
                    content.append(tempStr);
                }
                return content.toString();
            }else{
//                log.error("请求出现问题");
            }
        } catch (IOException e) {
//            log.error("IOException:", e.getMessage(),e);
        }finally{
            in.close();
            httpConn.disconnect();
        }
        return null;
    }
    public static String doDelete(String url, String str) {


        String charset = DEFAULT_CHARSET;
        String ctype = "application/json;charset=" + charset;
        HttpsURLConnection conn = null;
        OutputStream out = null;
        String rsp = null;
        byte[] content = null;
        try {
            content = str.getBytes(charset);
            SSLContext ctx = SSLContext.getInstance("TLS");
            ctx.init(new KeyManager[0], new TrustManager[] { new DefaultTrustManager() }, new SecureRandom());
            SSLContext.setDefault(ctx);


            conn = getConnection(new URL(url),"DELETE", ctype);
            conn.setHostnameVerifier(new HostnameVerifier() {


                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
            conn.setConnectTimeout(connectTimeout);
            conn.setReadTimeout(readTimeout);


            out = conn.getOutputStream();
            out.write(content);
            rsp = getResponseAsString(conn);
        } catch (Exception e) {
//            log.error("REQUEST_RESPONSE_ERROR, URL = " + url, e);
        } finally {


            try {
                if (out != null)out.close();
                if (conn != null)conn.disconnect();
            } catch (Exception e) {
//                log.error("REQUEST_RESPONSE_ERROR, URL = " + url, e);
            }
        }


        return rsp;

    }


    private static class DefaultTrustManager implements X509TrustManager {


        public void checkClientTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
        }
        public void checkServerTrusted(X509Certificate[] chain, String authType)
                throws CertificateException {
        }
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

    }

    private static HttpsURLConnection getConnection(URL url, String method, String ctype)
            throws IOException {
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        conn.setRequestMethod(method);
        conn.setDoInput(true);
        conn.setDoOutput(true);
//        conn.setRequestProperty("Accept", "text/xml,text/javascript,text/html");
//        conn.setRequestProperty("User-Agent", "stargate");
        conn.setRequestProperty("Content-Type", ctype);
        return conn;
    }

    protected static String getResponseAsString(HttpURLConnection conn) throws IOException {
        String charset = getResponseCharset(conn.getContentType());
        InputStream es = conn.getErrorStream();
        if (es == null) {
            return getStreamAsString(conn.getInputStream(), charset);
        } else {
            String msg = getStreamAsString(es, charset);
            if (StringUtil.isEmpty(msg)) {
                throw new IOException(conn.getResponseCode() + ":" + conn.getResponseMessage());
            } else {
                throw new IOException(msg);
            }
        }
    }

    private static String getStreamAsString(InputStream stream, String charset) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream, charset));
            StringWriter writer = new StringWriter();

            char[] chars = new char[256];
            int count = 0;
            while ((count = reader.read(chars)) > 0) {
                writer.write(chars, 0, count);
            }

            return writer.toString();
        } finally {
            if (stream != null) {
                stream.close();
            }
        }
    }

    private static String getResponseCharset(String ctype) {
        String charset = DEFAULT_CHARSET;

        if (!StringUtil.isEmpty(ctype)) {
            String[] params = ctype.split(";");
            for (String param : params) {
                param = param.trim();
                if (param.startsWith("charset")) {
                    String[] pair = param.split("=", 2);
                    if (pair.length == 2) {
                        if (!StringUtil.isEmpty(pair[1])) {
                            charset = pair[1].trim();
                        }
                    }
                    break;
                }
            }
        }

        return charset;
    }

    public static void main(String[] args) {
        System.out.println(doPost("https://118.178.152.110:443/hz/personalIdentityAuthentication",
                "{\"busicode\":\"60019\",\"mercode\":\"201703280000002\",\"orgcode\":\"600000020170418\",\"proname\":\"幸福钱庄借贷平台\",\"reqtime\":\"20170705114723\",\"userId\":\"460004198610250830\",\"userName\":\"王天平\",\"sign\":\"9BDA438D5FE37142B249DBBC5DC2F15B\"}"));
    }
}