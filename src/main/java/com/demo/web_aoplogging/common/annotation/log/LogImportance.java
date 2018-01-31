/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.web_aoplogging.common.annotation.log;
/**
 * 日志的重要程度
 * @author zhel
 */
public enum LogImportance {

    /**
     * 程度最轻，多用于查询显示
     */
    LEVEL_A,

    /**
     * 程度较为重要，多用于一些较重要的业务
     */
    LEVEL_B,

    /**
     * 业务必要重要的程度
     */
    LEVEL_C,

    /**
     * 特别重要，日志一定描述清楚
     */
    LEVEL_D;
}

