package com.adu.springboothelloworld.aspect;

import com.adu.springboothelloworld.annotation.ControllerWebLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jintang
 * @date 2019-11-14
 */
@Aspect
@Component
@Slf4j
public class WebLogAspect {
    @Pointcut("execution(* com.adu.springboothelloworld.controller..*.*(..))")
    public void webLog() {}

    @Before(value = "@annotation(controllerWebLog)")
    public void doBefore(JoinPoint joinPoint, ControllerWebLog controllerWebLog) {
        log.info("WebLogAspect doBefore");
        // 开始时间。
        long startTime = System.currentTimeMillis();
        Map<String, Object> threadInfo = new HashMap<>();
        threadInfo.put("START_TIME", startTime);
        // 请求参数。
        StringBuilder requestStr = new StringBuilder();
        Object[] args = joinPoint.getArgs();
        if (args != null && args.length > 0) {
            for (Object arg : args) {
                requestStr.append(arg.toString());
            }
        }
        threadInfo.put("REQUEST_PARAMS", requestStr.toString());

        //logger.info("{}接口开始调用:requestData={}", controllerWebLog.name(), threadInfo.get("REQUEST_PARAMS"));
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    }

    @AfterReturning(value = "webLog()&& @annotation(controllerWebLog)", returning = "res")
    public void doAfterReturning(ControllerWebLog controllerWebLog, Object res) {
        System.out.println("after");
    }

    @AfterThrowing(value = "webLog() &&  @annotation(controllerWebLog)", throwing = "throwable")
    public void doAfterThrowing(ControllerWebLog controllerWebLog, Throwable throwable) {
        System.out.println(throwable.getMessage());
    }
}
