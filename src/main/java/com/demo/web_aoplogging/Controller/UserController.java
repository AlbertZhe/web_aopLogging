/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.web_aoplogging.Controller;

import com.alibaba.fastjson.JSON;
import com.demo.web_aoplogging.model.po.User;
import com.demo.web_aoplogging.service.module.userInfo.UserInfoService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author zhel
 */
@Controller
public class UserController {
    
    @Autowired
    private UserInfoService userInfoService;
    
    
    @RequestMapping("getUserByID.app")
    @ResponseBody
    public String getUserByID(Long userID) {
        User user = userInfoService.getUserByID(userID);
        return JSON.toJSONString(user);
    }
    
}
