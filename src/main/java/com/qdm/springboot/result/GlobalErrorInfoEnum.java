package com.qdm.springboot.result;


/**
 * 应用级别的错误码
 *
 * @author QiuDongMing 2017年12月04日 15:17
 * @version 1.0
 */
public enum GlobalErrorInfoEnum implements ErrorInfoInterface {

    SUCCESS("0", "success"),
    NOT_FOUND("-1", "service not found"),
    PARAMS_NO_COMPLETE("000001","params no complete"),
    ERROR("-2", "系统错误");


    private String code;

    private String message;

    GlobalErrorInfoEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
