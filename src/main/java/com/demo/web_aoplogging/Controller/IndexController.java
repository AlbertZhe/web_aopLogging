/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.web_aoplogging.Controller;

import com.alibaba.fastjson.JSON;
import com.demo.web_aoplogging.common.SessionStatus;
import com.demo.web_aoplogging.model.po.Login;
import com.demo.web_aoplogging.service.module.userInfo.LoginService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author zhel
 */
@Controller
public class IndexController {
    
    @Autowired
    private LoginService loginService;

    
    @RequestMapping("login.app")
    @ResponseBody
    public String login(HttpServletRequest request, String username, String password) {
        Login loginUser = loginService.getLoginByUsername(username);
        
        if (loginUser.getPassword().equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute(SessionStatus.LOGIN_USER, loginUser);
        }
        
        return JSON.toJSONString(loginUser);
    }
}
