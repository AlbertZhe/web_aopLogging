/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.web_aoplogging.service.module.userInfo;

import com.demo.web_aoplogging.dao.user.UserMapper;
import com.demo.web_aoplogging.model.po.User;
import com.demo.web_aoplogging.common.ServiceStatus;
import com.demo.web_aoplogging.common.annotation.log.LogAnnotation;
import com.demo.web_aoplogging.common.annotation.log.LogImportance;
import com.demo.web_aoplogging.common.annotation.log.LogOptType;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户信息维护模块
 * @author zhel
 */
@Service
public class UserInfoService {
    @Autowired
    private UserMapper userMapper;
    
    /**
     * 查询单一的用户信息
     * @param userID
     * @return
     */
    @LogAnnotation( optType = LogOptType.SELECT, describe = "查询是否存在这个用户", importance = LogImportance.LEVEL_B)
    public User getUserByID(Long userID) {
        return userMapper.selectByPrimaryKey(userID);
    }
    
//    /**
//     * 添加用户
//     * @param name
//     * @param age
//     * @param dirthday
//     * @return
//     */
//    public String addUser(String name, Integer age, String dirthday){
//        if(age < 0 || age > 150) {
//            return "年龄不符合要求";
//        }
//        Date dirthdayDate = null;
//        try {
//            dirthdayDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2013-06-01 13:24:16");
//        } catch (ParseException ex) {
//            return "出生日期不符合要求";
//        }
//        User user = new User();
//        user.setAge(age);
//        user.setName(name);
//        user.setBirthday(dirthdayDate);
//        user.setCreateTime(new Timestamp(new Date().getTime()));
//        int sqlresutl = userMapper.insert(user);
//        if (sqlresutl != 1) {
//            return "添加失败（查询数据库）";
//        } else {
//            return ServiceStatus.SUCCESS;
//        }
//    }
//    
//    /**
//     * 删除用户信息
//     * @param userID
//     * @return
//     */
//    public String deleteUserByID(Long userID) {
//        userMapper.deleteByPrimaryKey(userID);
//        return ServiceStatus.SUCCESS;
//    }
//    
//    /**
//     * 修改用户信息
//     * @param userID
//     * @param name
//     * @param age
//     * @param dirthday
//     * @return
//     * @throws ParseException
//     */
//    public String updateUser(Long userID, String name, Integer age, String dirthday) throws ParseException {
//        // 省略对字段的判断
//        User user = new User();
//        user.setId(userID);
//        user.setName(name);
//        user.setBirthday(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dirthday));
//        
//        int sqlresutl = userMapper.updateByPrimaryKeySelective(user);
//        if (sqlresutl != 1) {
//            return "修改失败（查询数据库）";
//        } else {
//            return ServiceStatus.SUCCESS;
//        }
//    }
// 
//    /**
//     * 查询所有的用户信息
//     * 
//     * @return
//     */
//    public List<User> getAllUser() {
//        return userMapper.selectAllUsers();
//    }

}
