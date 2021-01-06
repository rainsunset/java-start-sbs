package com.rainsunset.demo.service.aop;

import com.google.common.base.Throwables;
import com.rainsunset.common.bean.BaseRequest;
import com.rainsunset.common.bean.GlobalException;
import com.rainsunset.common.bean.ResponseGenerator;
import com.rainsunset.common.bean.ResponseResult;
import com.rainsunset.demo.constant.Constants;
import com.rainsunset.demo.constant.GlobalErrorInfoEnum;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.hibernate.validator.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.util.StringUtils;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.ConstraintViolation;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 *
 * @version : 1.0
 * @description: 日志、异常统一处理
 * @author: ligangwei
 * @company rainsunset
 * @date: 2020 -02-15
 */
@Aspect
@Component
public class ServiceAspect {
    /**
     * Local validator factory bean
     */
    @Autowired
    private LocalValidatorFactoryBean localValidatorFactoryBean;
    /**
     * ERROR_MSG
     */
    private static final String ERROR_MSG = "call [{}] [{}] [{}ms] [{}] [{}] RESPONSE:Result{} Cause:{}";

    /**
     * Log
     */
    private final Logger log = LoggerFactory.getLogger(getClass());

    /**
     * Service access response result.
     *
     * @param joinPoint the join point
     * @return the response result
     * @author : ligangwei / 2020-02-15
     */
    @Around("execution(public com.rainsunset.common.bean.ResponseResult com.rainsunset.demo.service.impl.*.*(..))")
    public ResponseResult serviceAccess(ProceedingJoinPoint joinPoint) {
        // 计时开始
        StopWatch clock = new StopWatch();
        clock.start();

        ResponseResult response = null;
        String clazzName = joinPoint.getTarget().getClass().getSimpleName(); //获得类名
        //获得方法名
        String methodName = joinPoint.getSignature().getName();
        //获得参数列表
        Object[] args = joinPoint.getArgs();

        if (args != null) {
            //初始化日志ID
            initMDC(args);
            Object argObject = args[0];
            log.info("call [{}] [{}] PARAMETER:[{}]", clazzName, methodName, argObject);
            try {
                //参数校验
                validate(argObject);
                //业务执行
                response = (ResponseResult) joinPoint.proceed();
                // 计时结束
                clock.stop();
                log.info("call [{}] [{}] [{}ms] [{}] [{}] RESPONSE:Result{}", clazzName, methodName,
                        clock.getTotalTimeMillis(), "Success", response.getErrorCode(), response);
            } catch (GlobalException e) {
                response = ResponseGenerator.genResult(e);
                clock.stop();
                log.info(ERROR_MSG, clazzName, methodName, clock.getTotalTimeMillis(), "Success",
                        response.getErrorCode(), response, e.getMessage());
            } catch (Throwable throwable) {
                response = ResponseGenerator.genResult(GlobalErrorInfoEnum.DEMOEC_500000);
                clock.stop();
                log.error(ERROR_MSG, clazzName, methodName, clock.getTotalTimeMillis(), "Failure",
                        response.getErrorCode(), response, Throwables.getStackTraceAsString(throwable));
            }
        }
        return response;
    }

    /**
     * 参数校验
     *
     * @param <T>    the type parameter
     * @param object 校验对象
     * @param groups the groups
     * @author : ligangwei / 2020-02-15
     */
    private <T> void validate(T object, Class<?>... groups) {
        Set<ConstraintViolation<T>> constraintViolations = localValidatorFactoryBean.validate(
                object, groups);
        if (!constraintViolations.isEmpty()) {
            // 非空注解最优先抛出
            List<Class<? extends Annotation>> firstAnnotationTypes = Arrays.asList(NotBlank.class, NotNull.class, NotEmpty.class);
            Class<? extends Annotation> annotationType;
            // 默认抛出第一个校验注解的异常
            ConstraintViolation cv = constraintViolations.iterator().next();
            for (ConstraintViolation c : constraintViolations) {
                annotationType = c.getConstraintDescriptor().getAnnotation().annotationType();
                // 如果异常列表有非空注解异常则首先抛出
                if (firstAnnotationTypes.contains(annotationType)) {
                    cv = c;
                }
            }
            throw new GlobalException(GlobalErrorInfoEnum.DEMOEC_500000, cv.getMessage());
        }
    }

    /**
     * 初始化日志ID
     * @param args 入参
     */
    private String initMDC(Object[] args) {
        if (args.length > 0) {
            Object argObject = args[0];
            if (argObject instanceof BaseRequest) {
                String traceLogId = ((BaseRequest) argObject).getTraceLogId();
                if (StringUtils.isEmpty(traceLogId)) {
                    Integer random = (int)(100 * Math.random());
                    StringBuilder stringBuilder = new StringBuilder("spec_");
                    stringBuilder.append(System.currentTimeMillis()).append("_").append(random);
                    traceLogId = stringBuilder.toString();
                    ((BaseRequest) argObject).setTraceLogId(traceLogId);
                }
                MDC.put(Constants.TRACE_LOG_ID, traceLogId);
                return traceLogId;
            }
        }
        return null;
    }

}