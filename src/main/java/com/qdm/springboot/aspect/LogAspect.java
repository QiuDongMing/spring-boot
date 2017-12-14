package com.qdm.springboot.aspect;

import com.qdm.springboot.utils.JsonUtils;
import com.qdm.springboot.utils.RequestParam;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

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
    public void requestLog(JoinPoint joinPoint) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        RequestParam requestParam = new RequestParam();
        //requestParam.setArgs(joinPoint.getArgs());
        requestParam.setArgs(getArgsInfo(joinPoint));
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
    public void responseLog(Object object) {
        logger.info("response:{}", JsonUtils.objectToJson(object));
    }


    /**
     * 获取请求的参数
     * @param point
     * @return
     */
    private String getArgsInfo(JoinPoint point) {
        String className = point.getSignature().getDeclaringType().getSimpleName();
        String methodName = point.getSignature().getName();
        String[] parameterNames = ((MethodSignature) point.getSignature()).getParameterNames();
        StringBuilder sb = null;
        if (!Objects.deepEquals(null,parameterNames)) {//Objects.nutNull(parameterNames)
            sb = new StringBuilder();
            String args;
            for (int i = 0; i < parameterNames.length; i++) {
                try {
                    args = JsonUtils.objectToJson(point.getArgs()[i]);
                } catch (Exception e) {
                    args = point.getArgs()[i].toString();
                }

                String value = point.getArgs()[i] != null ? args : "null";
                if(i == parameterNames.length-1) {
                    sb.append(parameterNames[i] + ":" + value);
                } else {
                    sb.append(parameterNames[i] + ":" + value + ",");
                }
            }
        }
        sb = sb == null ? new StringBuilder() : sb;
        String info = String.format(sb.toString());
        return info;
    }




}
