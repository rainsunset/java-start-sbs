package com.rainsunset.aop;

import com.cmbi.base.Response;
import com.rainsunset.common.enums.ErrorCode;
import com.rainsunset.common.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.sql.SQLDataException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 接口全局异常处理
 *
 * @author ChenYanRui
 * @since 2020/5/9
 */
@Slf4j
@RestControllerAdvice
public class GlobalHandler {

    /**
     * 400 - 缺少请求参数
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Object handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        log.error("缺少请求参数", e);
        Response<String> response = new Response<>(ErrorCode.ERROR_400001.getCode(), ErrorCode.ERROR_400001.getDesc());
        response.setResult("缺少请求参数: "+ e.getParameterName());
        return response;
    }

    /**
     * 400 - 参数解析失败（如入参JsonString格式不对）
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Object handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        log.error("参数解析失败", e);
        Response<String> response = new Response<>(ErrorCode.ERROR_400001.getCode(), ErrorCode.ERROR_400001.getDesc());
        response.setResult("参数解析失败, 请检查入参格式是否正确");
        return response;
    }

    /**
     * 400 - 参数绑定失败（非Json Post请求参数校验异常）
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
            BindException.class,
            MethodArgumentTypeMismatchException.class
    })
    public Object handleBindException(Exception e) {
        log.error("参数绑定失败", e);
        Response<String> response = new Response<>(ErrorCode.ERROR_400001.getCode(), ErrorCode.ERROR_400001.getDesc());
        String message;
        if (e instanceof MethodArgumentTypeMismatchException){
            MethodArgumentTypeMismatchException ex = (MethodArgumentTypeMismatchException) e;
            message = String.format("param field: '%s', required type: '%s', %s", ex.getParameter().getParameterName(), ex.getRequiredType(), ex.getMessage());
        } else {
            BindingResult result = ((BindException)e).getBindingResult();
            Map<String, String> errMap = result.getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField,FieldError::getDefaultMessage));
            message = errMap.toString();
        }
        response.setResult(message);
        return response;
    }

    /**
     * 400 - 参数验证失败（Json Post请求参数校验异常）
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
            MethodArgumentNotValidException.class,
            ConstraintViolationException.class,
            ValidationException.class
    })
    public Object handleMethodArgumentNotValidException(Exception e) {
        log.error("参数校验失败", e);
        String message;
        if (e instanceof MethodArgumentNotValidException){
            MethodArgumentNotValidException me = (MethodArgumentNotValidException) e;
            BindingResult result = me.getBindingResult();
            Map<String, String> errMap = result.getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField,FieldError::getDefaultMessage));
            message = errMap.toString();
        } else if (e instanceof ConstraintViolationException) {
            ConstraintViolationException ce = (ConstraintViolationException) e;
            Set<ConstraintViolation<?>> violations = ce.getConstraintViolations();
            List<String> errors = violations.stream().map(ConstraintViolation::getMessage).collect(Collectors.toList());
            message = errors.toString();
        } else {
            ValidationException ve = (ValidationException) e;
            message = ve.getMessage();
        }
        Response<String> response = new Response<>(ErrorCode.ERROR_400001.getCode(), ErrorCode.ERROR_400001.getDesc());
        response.setResult(message);
        return response;
    }


    /**
     * 405 - Request Method Not Supported
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Object handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        String errMsg = String.format("当前接口不支持method: %s. 可支持的method: %s", e.getMethod(), e.getSupportedHttpMethods());
        log.error(errMsg, e);
        Response<String> response = new Response<>(ErrorCode.ERROR_405001.getCode(), ErrorCode.ERROR_405001.getDesc());
        response.setResult(errMsg);
        return response;
    }

    /**
     * 415 - Unsupported Media Type
     */
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public Object handleHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e) {
        String errMsg = String.format("不支持当前ContentType: %s. 可支持的ContentType: %s", e.getContentType(), e.getSupportedMediaTypes());
        log.error(errMsg, e);
        Response<String> response = new Response<>(ErrorCode.ERROR_405001.getCode(), ErrorCode.ERROR_405001.getDesc());
        response.setResult(errMsg);
        return response;
    }

    /**
     * 业务层需要自己声明异常的情况
     * http状态码可根据具体业务场景自行判断设置，此处默认返回500
     */
    @ExceptionHandler(ServiceException.class)
    public Object handleServiceException(ServiceException e, HttpServletResponse response) {
        log.error("业务异常", e);
        switch (ErrorCode.valueOf(e.getCode())) {
            case ERROR_400001:
                // 可根据场景业务异常自定义返回http状态码
                response.setStatus(HttpStatus.BAD_REQUEST.value());
                break;
            case ERROR_500001:
            case ERROR_500002:
            default:
                // 默认业务异常返回http状态码500
                response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        return new Response<>(e);
    }

    /**
     * 操作数据或库出现异常
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(SQLDataException.class)
    public Object handleException(SQLDataException e) {
        log.error("操作数据库出现异常:", e);
        Response<String> response = new Response<>(ErrorCode.ERROR_500001.getCode(), ErrorCode.ERROR_500001.getDesc());
        response.setResult(e.getMessage());
        return response;
    }

    /**
     * 其它异常
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Throwable.class)
    public Object defaultErrorHandler(Throwable e) {
        log.error("系统异常", e);
        Response<String> response = new Response<>(ErrorCode.ERROR_500002.getCode(), ErrorCode.ERROR_500002.getDesc());
        response.setResult(e.getMessage());
        return response;
    }

}
