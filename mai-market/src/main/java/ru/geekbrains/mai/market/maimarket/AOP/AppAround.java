package ru.geekbrains.mai.market.maimarket.AOP;


import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Aspect
@Component
public class AppAround {
    private  long userServiceTotalDuration = 0;
    private  long orderServiceTotalDuration = 0;
    private  long productServiceTotalDuration = 0;

    @Around("execution(public * ru.geekbrains.mai.market.maimarket.services.UserService.*(..))")
    public Object timeUserService(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("start AOP USER");
        long begin = System.currentTimeMillis();
        Object out = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        long duration = end - begin;
        userServiceTotalDuration += duration;
        System.out.println("CS "+ userServiceTotalDuration);
        return out;
    }

    public long getUserServiceTotalDuration() {
        return userServiceTotalDuration;
    }

    public long getOrderServiceTotalDuration() {
        return orderServiceTotalDuration;
    }


    public long getProductServiceTotalDuration() {
        return productServiceTotalDuration;
    }



    @Around("execution(public * ru.geekbrains.mai.market.maimarket.services.OrderService.*(..))")
    public Object timeOrderService(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("start AOP ORDER");
        long begin = System.currentTimeMillis();
        Object out = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        long duration = end - begin;
        orderServiceTotalDuration += duration;
        System.out.println("CS "+ orderServiceTotalDuration);
        return out;
    }


    @Around("execution(public * ru.geekbrains.mai.market.maimarket.services.ProductService.*(..))")
    public Object timeProductService(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("start AOP PRODUCT");
        long begin = System.currentTimeMillis();
        Object out = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        long duration = end - begin;
        productServiceTotalDuration += duration;
        System.out.println("CS "+ productServiceTotalDuration);
//        System.out.println((MethodSignature) proceedingJoinPoint.getSignature() + " duration: " + duration);
        return out;
    }

}
