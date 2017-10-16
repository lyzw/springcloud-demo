package com.zhouw.springclouddemo.bizname;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * //TODO {Please input description here }
 *
 * @author zhouwei
 * @version v1.0
 * @cratedate 2017/9/11.
 * @since v1.0
 */
@SpringBootApplication
public class BizApplication {

    private static Log logger = LogFactory.getLog(BizApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BizApplication.class, args);
    }
}
