package com.zhouw.common.util.http;

import com.zhouw.common.util.io.StreamUtil;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * //TODO {Please input description here }
 *
 * @author zhouwei
 * @version v1.0
 * @cratedate 2017/10/16.
 * @since v1.0
 */
public class ReReadContentHttpServletRequest extends HttpServletRequestWrapper {

    private static Logger logger = LoggerFactory.getLogger(ReReadContentHttpServletRequest.class);


    private byte[] bodyConent;

    /**
     * Constructs a request object wrapping the given request.
     *
     * @param request
     * @throws IllegalArgumentException if the request is null
     */
    public ReReadContentHttpServletRequest(HttpServletRequest request) {
        super(request);
        try {
            bodyConent = StreamUtil.readBytes(request.getInputStream());
        } catch (IOException e) {
            bodyConent = null;
        }
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        final ByteArrayInputStream bais = new ByteArrayInputStream(bodyConent);
        return new ServletInputStream() {
            @Override
            public int read() throws IOException {
                return bais.read();
            }
        };
    }

    /**
     * 获取请求体的内容
     * @return
     * @throws UnsupportedEncodingException
     */
    public String getBodyContent() throws UnsupportedEncodingException {
        return new String(bodyConent,this.getCharacterEncoding());
    }

}
