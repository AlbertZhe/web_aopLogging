/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.web_aoplogging.dao.log;

import com.demo.web_aoplogging.model.po.Log_operation;

/**
 *
 * @author zhel
 */
public interface LogOperationMapper {
    
    int insert(Log_operation log_operation);
    
}
