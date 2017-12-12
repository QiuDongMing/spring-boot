package com.qdm.springboot.result;

/**
 * 错误码接口
 * @author QiuDongMing 2017年12月04日 15:15
 * @version 1.0
 */
public interface ErrorInfoInterface {
    /**
     * 获取错误码
     * @author QiuDongMing 2017年12月04日 15:16:50
     * @return
     */
    String getCode();

    /**
     * 获取错误消息
     * @author QiuDongMing 2017年12月04日 15:16:40
     * @return
     */
    String getMessage();
}
