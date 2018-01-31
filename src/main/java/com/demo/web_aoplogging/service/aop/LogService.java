/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.web_aoplogging.service.aop;

import com.demo.web_aoplogging.dao.log.LogOperationMapper;
import com.demo.web_aoplogging.model.po.Log_operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Tom
 */
@Service
public class LogService {
    
    @Autowired
    private LogOperationMapper logOperationMapper;
    
    
    public void addLog(Log_operation log_operation) {
        logOperationMapper.insert(log_operation);
    }
    
}
