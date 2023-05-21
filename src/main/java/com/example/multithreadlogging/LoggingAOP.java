package com.example.multithreadlogging;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Component
@Slf4j
public class LoggingAOP {

    @Before("execution(* com.example.multithreadlogging.*Controller.*(..))")
    public void appLogging(JoinPoint joinPoint) {
        log.info("[{}] timestamp: {}", getCurrentThreadName(), getCurrentTimestamp());
    }

    @AfterReturning(pointcut = "execution(* com.example.multithreadlogging.*Controller.*(..))", returning = "result")
    public void afterLogging(JoinPoint joinPoint, Object result) {
        log.info("[{}] result: {}", getCurrentThreadName(), result.toString());
    }

    @AfterThrowing(pointcut = "execution(* com.example.multithreadlogging.*Controller.*(..))", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Throwable exception) {
        log.error("[{}] result: {}", getCurrentThreadName(), exception.getMessage());
    }

    private String getCurrentTimestamp() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        return format.format(new Date());
    }

    private String getCurrentThreadName() {
        return Thread.currentThread().getName();
    }
}
