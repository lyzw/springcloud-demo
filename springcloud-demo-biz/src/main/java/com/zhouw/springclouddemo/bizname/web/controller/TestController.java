package com.zhouw.springclouddemo.bizname.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * //TODO {Please input description here }
 *
 * @author zhouwei
 * @version v1.0
 * @cratedate 2017/9/12.
 * @since v1.0
 */
@Controller
public class TestController {

    @RequestMapping(value = "test")
    @ResponseBody
    public String hello(String name){
        System.out.println(name);
        return "hello " + name;
    }
}
