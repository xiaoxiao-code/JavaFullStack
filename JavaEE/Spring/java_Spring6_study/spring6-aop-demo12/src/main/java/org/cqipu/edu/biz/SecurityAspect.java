package org.cqipu.edu.biz;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SecurityAspect {

    @Pointcut("execution(* org.cqipu.edu.biz..save*(..))")
    public void savePointcut(){}

    @Pointcut("execution(* org.cqipu.edu.biz..delete*(..))")
    public void deletePointcut(){}

    @Pointcut("execution(* org.cqipu.edu.biz..modify*(..))")
    public void modifyPointcut(){}

    @Before("savePointcut() || deletePointcut() || modifyPointcut()")
    public void beforeAdivce(JoinPoint joinpoint){
        System.out.println("XXX操作员正在操作"+joinpoint.getSignature().getName()+"方法");
    }
}