package com.rainsunset.common.exception;


import com.rainsunset.common.enums.ErrorCode;
import lombok.Getter;

/**
 * 业务异常类
 *
 * @author 黄少彬
 * @since 2018/10/10
 */
public class ServiceException extends RuntimeException {
    private static final long serialVersionUID = -18552236512354826L;

    @Getter
    private final String code;

    public ServiceException(String code) {
        this.code = code;
    }

    public ServiceException(String code, Throwable throwable) {
        super(throwable);
        this.code = code;
    }

    public ServiceException(String code, String message) {
        super(message);
        this.code = code;
    }

    public ServiceException(String code, String message, Throwable throwable) {
        super(message, throwable);
        this.code = code;
    }

    public ServiceException(ErrorCode errorCode) {
        super(errorCode.getDesc());
        this.code = errorCode.getCode();
    }

    public ServiceException(String code, String message, String... arg) {

        super(replaceMsg(message, arg));
        this.code = code;
    }

    private static String replaceMsg(String message, String... arg) {
        String dec = message;
        for (String argItem : arg) {
            dec = dec.replaceFirst("#", argItem);
        }
        return dec;
    }
}
