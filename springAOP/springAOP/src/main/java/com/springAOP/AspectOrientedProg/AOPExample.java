package com.springAOP.AspectOrientedProg;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AOPExample {

    @Pointcut("execution(* com.springAOP.service.StudentService.*(..)) ")
    private void anyStudentService() {} // the pointcut signature

    @Before("anyStudentService() && args(fname, lname)")
    public void beforeAdvice(JoinPoint joinPoint,
                             String fname, String lname)
    {
        System.out.println(
                "Before method:" + joinPoint.getSignature()+ "\n Adding Student with first name- "
                        + fname + ", second name- " + lname);
    }


    @After("anyStudentService() && args(fname, lname)")
    public void afterAdvice(JoinPoint joinPoint,
                             String fname, String lname)
    {
        System.out.println(
                "After method:" + joinPoint.getSignature()+ "\n Adding Student with first name- "
                        + fname + ", second name- " + lname);

        System.out.println("This is the example of After AOP");
    }
}
