package com.qdm.springboot.result;

/**
 * 统一错误码异常
 *
 * @author QiuDongMing 2017年12月04日 15:21
 * @version 1.0
 */
public class GlobalErrorInfoException extends Exception {

    private ErrorInfoInterface errorInfo;

    public GlobalErrorInfoException (ErrorInfoInterface errorInfo) {
        this.errorInfo = errorInfo;
    }

    public ErrorInfoInterface getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(ErrorInfoInterface errorInfo) {
        this.errorInfo = errorInfo;
    }

}
