package com.qdm.springboot.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import com.qdm.springboot.entity.BbsTopic;
import org.springframework.stereotype.Repository;

@Mapper
@Repository("bbsTopicDao")
public interface BbsTopicDao {

    /**
     * 添加主题
     * @author QiuDongMing 2017年12月02日 17:32:45
     * @version 1.0
     * @param topic
     * @return
     */
    int insert(@Param("topic") BbsTopic topic);

    /**
     * 选择性添加主题
     * @author QiuDongMing 2017年12月02日 17:37:10
     * @version 1.0
     * @param topic
     * @return
     */
    int insertSelective(@Param("topic") BbsTopic topic);

    /**
     * 更新主题
     * @author QiuDongMing 2017年12月02日 17:37:32
     * @version 1.0
     * @param topic
     * @return
     */
    int update(@Param("topic") BbsTopic topic);

    /**
     * 获取主题
     * @author QiuDongMing 2017年12月02日 17:39:29
     * @version 1.0
     * @param topicId
     * @return
     */
    BbsTopic getBbsTopicById(@Param("topicId") Integer topicId);

    /**
     * 删除主题
     * @author QiuDongMing 2017年12月04日 12:20:50
     * @version 1.0
     * @param topicId
     * @return
     */
    int deleteBbsTopicById(@Param("topicId") Integer topicId);


}
