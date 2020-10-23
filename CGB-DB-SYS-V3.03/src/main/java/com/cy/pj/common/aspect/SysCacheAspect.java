package com.cy.pj.common.aspect;

/**
 * @author 作者：hyh
 * @version v.1.0 创建时间：2020/9/16 16:49
 * @email 邮箱：15205698133@163.com
 * @description 描述：
 */

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Aspect
@Component
public class SysCacheAspect {
    private Map<String,Object> cache = new ConcurrentHashMap<>();
    @Pointcut("@annotation(com.cy.pj.common.annotation.RequiredCache)")
    public void doCache() {}
    @Pointcut("@annotation(com.cy.pj.common.annotation.ClearCache)")
    public void doClearCache() {}

    @Around("doCache()")
    public Object around(ProceedingJoinPoint jp)
            throws Throwable{
        System.out.println("Get data from cache");
        Object result = cache.get("deptKey");
        if(result!=null) return result;
        result = jp.proceed();
        System.out.println("Put data to cache");
        cache.put("deptKey",result);
        return result;
    }

    @AfterReturning("doClearCache()")
    public void clear(){
        cache.clear();
    }

}
