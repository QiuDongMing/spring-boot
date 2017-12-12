package com.qdm.springboot.result;

/**
 * @author QiuDongMing 2017年12月06日 18:08
 * @version 1.0
 */
public class ResultBodyUtils {

    /**
     * 返回成功
     * @param object
     * @return
     */
    public static ResultBody success(Object object) {
        ResultBody resultBody = new ResultBody(object);
        return resultBody;
    }

    /**
     * 返回成功
     * @return
     */
    public static ResultBody success() {
        ResultBody resultBody = new ResultBody();
        return resultBody;
    }


}
