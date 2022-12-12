package com.example.exem.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspects {


    @Before("execution(* com.example.exem.controllers.*.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {

        String name = joinPoint.getSignature().getName();

        log.info("Début Exécution :" + name );
    }

//    @Before("execution( * tn.esprit.kaddemproject.generic.IGenericServiceImp.add*(..))")
//    public void logMethodEntry(JoinPoint joinPoint) {
//
//        String name = joinPoint.getSignature().getName();
//
//        log.info("In method :" + name );
//    }

}
