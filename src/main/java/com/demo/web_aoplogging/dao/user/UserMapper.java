/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.web_aoplogging.dao.user;

import com.demo.web_aoplogging.model.po.User;
import java.util.List;

/**
 * 用户的操作
 * @author zhel
 */
public interface UserMapper {
    User selectByPrimaryKey(Long id);

    int deleteByPrimaryKey(Long id);

//    
//    int insert(User user);
//    
//    int updateByPrimaryKeySelective(User user);
//
//    List<User> selectAllUsers();
}
