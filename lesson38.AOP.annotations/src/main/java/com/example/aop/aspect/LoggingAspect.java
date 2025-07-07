package com.example.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.example.aop.service.TaskService.performTask(..))")
    public void beforeExecution() {
        System.out.println("Before method execution (execution pointcut)");
    }

    @Around("@annotation(com.example.aop.annotation.TrackTime)")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around start (annotation)");
        Object result = joinPoint.proceed();
        System.out.println("Around end (annotation)");
        return result;
    }

    @After("execution(* com.example.aop.service.TaskService.performTask(..))")
    public void afterExecution() {
        System.out.println("After method execution (execution pointcut)");
    }
}