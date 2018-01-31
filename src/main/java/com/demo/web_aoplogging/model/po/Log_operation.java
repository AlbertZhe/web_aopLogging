/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.web_aoplogging.model.po;

import java.sql.Timestamp;

/**
 *
 * @author zhel
 */
public class Log_operation {
    // 主键
    private Long id;
    // 操作人的账号
    // 这里通过 session 保存用户信息，再取出来填写，会使用到 RequestContextHolder 对象，可以在 AOP 中查看详情
    private String login_username;
    // 如下的是在注释上写设置的
    private String log_optType;
    private String describe;
    private String log_importance;
    private String req_parameter;
    
    private Timestamp createtime;
    // 可以对用户设备的拓展对，比如IP、环境等等
//    request.getRemoteAddr();    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin_username() {
        return login_username;
    }

    public void setLogin_username(String login_username) {
        this.login_username = login_username;
    }

    public String getLog_optType() {
        return log_optType;
    }

    public void setLog_optType(String log_optType) {
        this.log_optType = log_optType;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getLog_importance() {
        return log_importance;
    }

    public void setLog_importance(String log_importance) {
        this.log_importance = log_importance;
    }

    public String getReq_parameter() {
        return req_parameter;
    }

    public void setReq_parameter(String req_parameter) {
        this.req_parameter = req_parameter;
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }
}
