/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.web_aoplogging.service.module.userInfo;

import com.demo.web_aoplogging.common.annotation.log.LogAnnotation;
import com.demo.web_aoplogging.common.annotation.log.LogImportance;
import com.demo.web_aoplogging.common.annotation.log.LogOptType;
import com.demo.web_aoplogging.dao.user.LoginMapper;
import com.demo.web_aoplogging.model.po.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author zhel
 */
@Service
public class LoginService {
    
    @Autowired
    private LoginMapper loginMapper;
    
//    @LogAnnotation( optType = LogOptType.SELECT, describe = "用户登录查询", importance = LogImportance.LEVEL_A)
    public Login getLoginByUsername(String username) {
        return loginMapper.selectByPrimaryKey(username);
    }
}
