package com.qdm.springboot.result;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 统一错误码异常处理
 * @author QiuDongMing 2017年12月04日 15:23
 * @version 1.0
 */
@Component
@RestControllerAdvice
public class GlobalErrorInfoHandler {

    private final Logger logger = LoggerFactory.getLogger(GlobalErrorInfoHandler.class);

    @ExceptionHandler(value = Exception.class)
    public ResultBody errorHandlerOverJson(HttpServletRequest request,
                                           Exception exception) {
        if(exception instanceof GlobalErrorInfoException) {
            GlobalErrorInfoException globalErrorInfoException = (GlobalErrorInfoException) exception;
            ErrorInfoInterface errorInfo = globalErrorInfoException.getErrorInfo();
            logger.error("globalErrorInfo:{}",errorInfo);
           return new ResultBody(errorInfo);
        } else {
            logger.error("system exception detail :" + exception,exception);
            return new ResultBody(GlobalErrorInfoEnum.ERROR.getCode(), GlobalErrorInfoEnum.ERROR.getMessage());
        }
    }

}
