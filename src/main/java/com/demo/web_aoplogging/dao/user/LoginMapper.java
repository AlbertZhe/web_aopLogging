/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.web_aoplogging.dao.user;

import com.demo.web_aoplogging.model.po.Login;

/**
 *
 * @author zhel
 */
public interface LoginMapper {

    Login selectByPrimaryKey(String username);
}
