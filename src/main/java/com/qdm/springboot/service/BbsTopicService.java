package com.qdm.springboot.service;

import com.qdm.springboot.entity.BbsTopic;
import java.lang.Exception;

/**
 * @author QiuDongMing 2017年12月02日 18:07
 * @version 1.0
 */
public interface BbsTopicService {

    /**
     * 获取主题
     * @author QiuDongMing 2017年12月02日 18:08:28
     * @version 1.0
     * @param topicId
     * @return
     * @throws Exception
     */
    BbsTopic getBbsTopic(Integer topicId) throws Exception;

    /**
     * 删除主题
     * @author QiuDongMing 2017年12月04日 12:19:46
     * @version 1.0
     * @param id
     * @throws Exception
     */
    void deleteTopic(Integer id) throws Exception;

    /**
     * 更新主题
     * @author QiuDongMing 2017年12月04日 13:02:51
     * @version CCVZB4.0
     * @param bbsTopic
     * @throws Exception
     */
    void updateTopic(BbsTopic bbsTopic) throws Exception;

    /**
     * 添加主题
     * @author QiuDongMing 2017年12月04日 14:31:52
     * @version CCVZB4.0
     * @param bbsTopic
     * @throws Exception
     */
    void addTopic(BbsTopic bbsTopic) throws Exception;
}
