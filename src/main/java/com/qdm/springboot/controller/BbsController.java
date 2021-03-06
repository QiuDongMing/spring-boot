package com.qdm.springboot.controller;

import com.qdm.springboot.entity.BbsTopic;
import com.qdm.springboot.group.AddGroup;
import com.qdm.springboot.group.UpdateGroup;
import com.qdm.springboot.result.GlobalErrorInfoEnum;
import com.qdm.springboot.result.GlobalErrorInfoException;
import com.qdm.springboot.result.ResultBody;
import com.qdm.springboot.result.ResultBodyUtils;
import com.qdm.springboot.service.BbsTopicService;
import com.qdm.springboot.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.BindingResultUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author QiuDongMing 2017年12月02日 18:12
 * @version 1.0
 */
@RestController
public class BbsController {

    @Autowired
    private BbsTopicService bbsTopicService;

    @GetMapping("/api/topic/{id}")
    public ResultBody get(@PathVariable("id") Integer id) throws Exception {
        if(StringUtils.isEmpty(id)) {
            throw new GlobalErrorInfoException(GlobalErrorInfoEnum.PARAMS_NO_COMPLETE);
        }
        BbsTopic bbsTopic = bbsTopicService.getBbsTopic(id);
        return new ResultBody(bbsTopic);
    }

    @DeleteMapping("/api/topic/{id}")
    public ResultBody del(@PathVariable("id") Integer id) throws Exception {
        bbsTopicService.deleteTopic(id);
        return ResultBodyUtils.success();
    }

    @PutMapping("/api/topic/")
    public ResultBody update(@Valid @RequestBody BbsTopic bbsTopic) throws Exception {
        bbsTopicService.updateTopic(bbsTopic);
        return ResultBodyUtils.success();
    }


    @PostMapping("/api/topic/")
    public ResultBody add(@Validated({AddGroup.class}) @RequestBody BbsTopic bbsTopic, BindingResult bindingResult) throws Exception {
        if(bindingResult.hasErrors()) {
            return ResultBodyUtils.error(bindingResult.getFieldError().getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        bbsTopicService.addTopic(bbsTopic);
        return ResultBodyUtils.success();
    }



}
