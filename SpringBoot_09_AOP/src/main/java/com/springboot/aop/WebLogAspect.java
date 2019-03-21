package com.springboot.aop;


import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;


/**
 * 我们可能会对Web层做多个切面，校验用户，校验头信息等等，这个时候经常会碰到切面的处理顺序问题。
 * 我们需要@Order(i)注解来标识切面的优先级
 * 在切入点前的操作，按order的值由小到大执行
 * 在切入点后的操作，按order的值由大到小执行
 */
@Aspect
@Component
public class WebLogAspect {

    private Logger logger = Logger.getLogger(getClass());

//    @Pointcut("execution(public * com.springboot.controller..*.*(..))")
//    public void webLog() {
//    }


    @Before("execution(public * com.springboot.controller..*.*(..))")
    public void doBefore(JoinPoint joinPoint) {
        // 接到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        logger.info("URL：" + request.getRequestURL().toString());
        logger.info("HTTP_METHOD：" + request.getMethod());
        logger.info("IP：" + request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "ret", pointcut = "execution(public * com.springboot.controller..*.*(..))")
    public void doAfterReturing(Object ret) {
        logger.info("RESPONSE：" + ret);
    }


}
