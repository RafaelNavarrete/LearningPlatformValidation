package com.duoc.LearningPlatformValidation.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.duoc.LearningPlatformValidation.services.*.*(..))")
    public void logBeforeMethod(JoinPoint joinPoint) {

        System.out.println(
            "Ejecutando método: "
            + joinPoint.getSignature().getName()
        );
    }

    @AfterThrowing(
        pointcut = "execution(* com.duoc.LearningPlatformValidation.services.*.*(..))",
        throwing = "exception"
    )
    public void logException(
            JoinPoint joinPoint,
            Throwable exception
    ) {

        System.out.println(
            "Error en método: "
            + joinPoint.getSignature().getName()
            + " -> "
            + exception.getMessage()
        );
    }
}