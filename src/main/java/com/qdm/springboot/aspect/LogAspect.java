package com.qdm.springboot.aspect;

import com.qdm.springboot.utils.JsonUtils;
import com.qdm.springboot.utils.RequestParam;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author QiuDongMing 2017年12月06日 17:09
 * @version 1.0
 */
@Aspect
@Component
public class LogAspect {

    private final static Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut(value = "execution(* com.qdm.springboot.controller..*(..))")
    public void logCut(){}

    @Before(value = "logCut()")
    public void before(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        RequestParam requestParam = new RequestParam();
        requestParam.setArgs(joinPoint.getArgs());
        requestParam.setClassMethod(joinPoint.getSignature().getDeclaringTypeName() + ":"
                + joinPoint.getSignature().getName()+"()");
        requestParam.setUrl(request.getRequestURL().toString());
        requestParam.setIp(request.getRemoteAddr());
        requestParam.setMethod(request.getMethod());
        logger.info("request:{}",JsonUtils.objectToJson(requestParam));
    }

    @After(value = "logCut()")
    public void after() {
       //   logger.info("after");
//        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
//        logger.info("response result:{}",response.toString());
    }

    @AfterReturning(value = "logCut()", returning = "object")
    public void afterReturn(Object object) {
        logger.info("response:{}", JsonUtils.objectToJson(object));
    }





}
