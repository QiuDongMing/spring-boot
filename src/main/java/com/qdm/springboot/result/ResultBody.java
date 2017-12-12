package com.qdm.springboot.result;

/**
 * @author QiuDongMing 2017年12月04日 15:13
 * @version 1.0
 */
public class ResultBody {

    /**
     * 响应码
     */
    private String code;
    /**
     * 响应消息
     */
    private String message;
    /**
     * 响应结果
     */
    private Object result;


    public ResultBody() {
        this.code = GlobalErrorInfoEnum.SUCCESS.getCode();
        this.message = GlobalErrorInfoEnum.SUCCESS.getMessage();
    }

    public ResultBody(ErrorInfoInterface errorInfo) {
        this.code = errorInfo.getCode();
        this.message = errorInfo.getMessage();
    }

    public ResultBody(Object result) {
        this.code = GlobalErrorInfoEnum.SUCCESS.getCode();
        this.message = GlobalErrorInfoEnum.SUCCESS.getMessage();
        this.result = result;
    }

    public ResultBody(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
