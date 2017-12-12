package com.qdm.springboot.service.impl;
import com.qdm.springboot.dao.BbsTopicDao;
import com.qdm.springboot.entity.BbsTopic;
import com.qdm.springboot.result.GlobalErrorInfoEnum;
import com.qdm.springboot.result.GlobalErrorInfoException;
import com.qdm.springboot.service.BbsTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author QiuDongMing 2017年12月02日 18:09
 * @version 1.0
 */
@Service
public class BbsTopicServiceImpl implements BbsTopicService {

    @Autowired
    private BbsTopicDao bbsTopicDao;

    @Override
    public BbsTopic getBbsTopic(Integer topicId) throws GlobalErrorInfoException {
        BbsTopic bbsTopic = bbsTopicDao.getBbsTopicById(topicId);
        if(bbsTopic == null) {
            throw new GlobalErrorInfoException(GlobalErrorInfoEnum.NOT_FOUND);
        }
        return bbsTopicDao.getBbsTopicById(topicId);
    }


    @Override
    public void deleteTopic(Integer id) throws GlobalErrorInfoException {
        int row = bbsTopicDao.deleteBbsTopicById(id);
        if(row == 0) {
            throw new GlobalErrorInfoException(GlobalErrorInfoEnum.NOT_FOUND);
        }

    }

    @Override
    public void updateTopic(BbsTopic bbsTopic) throws GlobalErrorInfoException {
        bbsTopicDao.update(bbsTopic);
    }

    @Override
    public void addTopic(BbsTopic bbsTopic) throws GlobalErrorInfoException {
        bbsTopicDao.insertSelective(bbsTopic);
    }









}
