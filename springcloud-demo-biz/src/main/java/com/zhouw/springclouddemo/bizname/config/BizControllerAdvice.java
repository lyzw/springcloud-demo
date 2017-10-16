package com.zhouw.springclouddemo.bizname.config;

import com.zhouw.springclouddemo.bizname.web.response.BaseResponse;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * //TODO {Please input description here }
 *
 * @author zhouwei
 * @version v1.0
 * @cratedate 2017/9/11.
 * @since v1.0
 */
@ControllerAdvice
public class BizControllerAdvice {

    //@ModelAttribute   应用到所有@RequestMapping注解方法，在其执行之前把返回值放入Model
    //@InitBinder   应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
    //@ExceptionHandler 应用到所有@RequestMapping注解的方法，在其抛出指定的异常时执行


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public BaseResponse processException(HttpServletRequest request, Exception ex) {
        return BaseResponse.error(ex.getMessage());
    }

}
