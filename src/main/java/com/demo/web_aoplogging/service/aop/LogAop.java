/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.web_aoplogging.service.aop;

import com.demo.web_aoplogging.common.SessionStatus;
import com.demo.web_aoplogging.common.annotation.log.LogAnnotation;
import com.demo.web_aoplogging.model.po.Log_operation;
import com.demo.web_aoplogging.model.po.Login;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 *
 * @author zhel
 */
@Aspect
@Component
public class LogAop{
    
    @Autowired
    private LogService logService;
    
    /**
     * 对方法只是实现动态代理，没有实现业务的添加
     */
//    @Before("execution(* com.demo.web_aoplogging.service.userInfoModule.LoginService.*(..))")
//    public void testSysout() {
//        System.out.println("这是做一个测试，测试能不能在方法调用之前打印出这句----------");
//    }
//    
    
    // @Pointcut 指定哪些方法需要被执行"AOP"
    /*  
        比如我们需要指定的是所有的方法，同时被 @LogAnnotation 注解的方法；
        @Pointcut("execution(* *(..)) && @annotation(com.demo.web_aoplogging.common.annotation.log.LogAnnotation)")  
    */
    // 指定某个包下的所有类的所有方法并且被注解标示的方法
    @Pointcut("within(com.demo.web_aoplogging.service.module..*) && @annotation(com.demo.web_aoplogging.common.annotation.log.LogAnnotation)")
    public void log() { }
    
    @AfterReturning(pointcut = "log()", returning = "result")
    public void serviceOut(JoinPoint point, Object result) {
        Object[] params = point.getArgs();  // 获取参数  
        String methodName = point.getSignature().getName();// 获取方法名  
        Class<?> targetClass = point.getTarget().getClass();// 获取目标对象的类名  
        Method method = null;  
        for (Method mt : targetClass.getMethods()) {  
            if (methodName.equals(mt.getName())) {  
                method = mt;  
                break;  
            }
        }  
        LogAnnotation loggable = method.getAnnotation(LogAnnotation.class);// 自定义注解  
        if (loggable == null) {  
            return;  
        }  
        String describe = loggable.describe();
        String importance = loggable.importance().toString();
        String optType = loggable.optType().toString();
        
        
        
        
        
        Log_operation log_operation = new Log_operation();
        log_operation.setCreatetime(new Timestamp(new Date().getTime()));
        log_operation.setDescribe(describe);
        log_operation.setLog_importance(importance);
        log_operation.setLog_optType(optType);
 
//        如果只是获取attribute中的值
//        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
//        Login admin = (Login) requestAttributes.getAttribute(SessionStatus.LOGIN_USER, RequestAttributes.SCOPE_SESSION);
//        获取 request 对象
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();    
        HttpSession session = request.getSession();
        
        log_operation.setLogin_username(((Login)session.getAttribute(SessionStatus.LOGIN_USER)).getName());
        log_operation.setReq_parameter(Arrays.toString(params));
        
        logService.addLog(log_operation);
    }

    
}
