package com.itheima.d_aspect.b_anno;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 切面类，含有多个通知
 */
@Component
@Aspect
public class MyAspect {

    //切入点当前有效
//	@Before("execution(* com.itheima.d_aspect.b_anno.UserServiceImpl.*(..))")
    public void myBefore(JoinPoint joinPoint) {
        System.out.println("前置通知 ： " + joinPoint.getSignature().getName());
    }

    //声明公共切入点
    @Pointcut("execution(* com.itheima.d_aspect.b_anno.UserServiceImpl.*(..))")
    private void myPointCut() {

    }

    // 引用公共切入点
    //	@AfterReturning(value="myPointCut()" ,returning="ret")
    public void myAfterReturning(JoinPoint joinPoint, Object ret) {
        System.out.println("后置通知 ： " + joinPoint.getSignature().getName() + " , -->" + ret);
    }

    // 引用公共切入点
    //	@Around(value = "myPointCut()")
    public Object myAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("前");
        //手动执行目标方法
        Object obj = joinPoint.proceed();

        System.out.println("后");
        return obj;
    }

    //	@AfterThrowing(value="execution(* com.itheima.d_aspect.b_anno.UserServiceImpl.*(..))" ,throwing="e")
    public void myAfterThrowing(JoinPoint joinPoint, Throwable e) {
        System.out.println("抛出异常通知 ： " + e.getMessage());
    }

    @After("myPointCut()")
    public void myAfter(JoinPoint joinPoint) {
        System.out.println("最终通知");
    }

}
