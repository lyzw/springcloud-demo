package com.zhouw.springclouddemo.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author zhouwei
 * @version v1.0
 * @cratedate 2017/8/15.
 * @since v1.0
 */
@Configuration
@EnableAutoConfiguration
@RestController
@EnableDiscoveryClient
public class ClientApplication {

//    @Value("${applicationName}")
    String applicationName;

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @RequestMapping("get")
    public String getApplicationName(){
        return applicationName;
    }

}
