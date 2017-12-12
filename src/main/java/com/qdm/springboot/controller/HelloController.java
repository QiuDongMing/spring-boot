package com.qdm.springboot.controller;

import com.qdm.springboot.entity.User;
import com.qdm.springboot.property.HomeProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author QiuDongMing 2017年11月30日 16:01
 * @version CCVZB4.0
 */
@RestController
public class HelloController {

    @Autowired
    private HomeProperties homeProperties;

    @RequestMapping("/")
    public String home() {
        return "hello springBoot";
    }

    @RequestMapping("/getUser")
    public User getUser() {
        User user = new User();
        user.setName("qdm");
        user.setAge(25);
        user.setId(124812);
        return user;
    }


    @RequestMapping("/getHomePro")
    public HomeProperties getHomePro() {
        return homeProperties;
    }



}
