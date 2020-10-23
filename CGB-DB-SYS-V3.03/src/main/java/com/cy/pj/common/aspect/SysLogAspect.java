package com.cy.pj.common.aspect;

import com.cy.pj.common.annotation.RequiredLog;
import com.cy.pj.common.utils.IPUtils;
import com.cy.pj.sys.pojo.SysLog;
import com.cy.pj.sys.service.SysLogService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

/**
 * @author 作者：hyh
 * @version v.1.0 创建时间：2020/9/16 9:48
 * @email 邮箱：15205698133@163.com
 * @description 描述：
 */
@Aspect
@Slf4j
@Component
public class SysLogAspect {

    @Autowired
    private SysLogService sysLogService;

    @Pointcut("@annotation(com.cy.pj.common.annotation.RequiredLog)")
    public void logPointCut(){};

    @Around("logPointCut()")
    public Object round(ProceedingJoinPoint joinPoint){
        long startTime = System.currentTimeMillis();
        Object result = null;
        try {
            result = joinPoint.proceed();
            long endTime = System.currentTimeMillis();
            long useTime = endTime - startTime;
            log.info("方法执行的总时长为：{}",useTime);
            saveSysLog(joinPoint,useTime);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            log.error(throwable.getMessage());
        }
        return result;
    }


    private void saveSysLog(ProceedingJoinPoint joinPoint, long useTime)
            throws NoSuchMethodException, JsonProcessingException, InterruptedException {
        MethodSignature signature =(MethodSignature)joinPoint.getSignature();
        Class<?> aClass = joinPoint.getTarget().getClass();
        //类名
        String ClassName = aClass.getName();
        //方法名
        String MethodName = signature.getMethod().getName();

        //方法参数类型
        Class<?>[] parameterTypes = signature.getMethod().getParameterTypes();
        //获得方法对象
        Method targetMethod = aClass.getDeclaredMethod(MethodName, parameterTypes);
        //获得方法上注解
        RequiredLog requiredLog = targetMethod.getDeclaredAnnotation(RequiredLog.class);

        //获得方法参数
        Object[] paramsObj = joinPoint.getArgs();
        System.out.println(Arrays.toString(paramsObj));

        String username = "admin";
        String params = new ObjectMapper().writeValueAsString(paramsObj);
        String method = ClassName+"."+MethodName;
        String ip = IPUtils.getIpAddr();
        Date createdTime = new Date();
        SysLog log = new SysLog(username,null,method,params,useTime,ip,createdTime);
        if(requiredLog!=null)
            log.setOperation( requiredLog.value());
        //for (int i = 0; i < 1000000; i++) {

            sysLogService.insertObject(log);
//            new Thread(() -> {
//                try {
//                    sysLogService.insertObject(log);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }).start();
//        }

    }
}
