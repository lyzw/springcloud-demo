package com.zhouw.springclouddemo.bizname.aop;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * //TODO {Please input description here }
 *
 * @author zhouwei
 * @version v1.0
 * @cratedate 2017/9/12.
 * @since v1.0
 */
@Aspect
@Component
public class RequestLogAspect {
    private static Logger logger = LoggerFactory.getLogger(RequestLogAspect.class);

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    /**
     * 针对@RequestMapping注解的日志记录
     */
    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void requestMappingPointCut() {
    }

    @Around("requestMappingPointCut()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        startTime.set(System.nanoTime());
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("request from ip[{}],args[{}],",request.getRemoteHost(), JSON.toJSONString(request.getParameterMap()));
    }

    @AfterReturning(returning = "ret", pointcut = "requestMappingPointCut()")
    public void doAfterReturning(Object ret) throws Throwable {
        Long time = System.nanoTime() - startTime.get();
        logger.info("RESPONSE : " + ret);
        logger.info("time : " + time);

    }
}
