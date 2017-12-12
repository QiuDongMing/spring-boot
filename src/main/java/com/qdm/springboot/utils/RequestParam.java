package com.qdm.springboot.utils;

/**
 * @author QiuDongMing 2017年12月06日 17:48
 * @version 1.0
 */
public class RequestParam {

    private String ip;

    private String url;

    private String method;

    private String classMethod;

    private Object args;













    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getClassMethod() {
        return classMethod;
    }

    public void setClassMethod(String classMethod) {
        this.classMethod = classMethod;
    }

    public Object getArgs() {
        return args;
    }

    public void setArgs(Object args) {
        this.args = args;
    }
}
