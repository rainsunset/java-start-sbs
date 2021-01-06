/**
 * Company
 * Copyright (C) 2004-2018 All Rights Reserved.
 */
package com.ligw.demo.exception;

/**
 * @author ligw
 * @version $Id GlobalErrorInfoException.java, v 0.1 2018-08-22 0:58 ligw Exp $$
 */
public class GlobalErrorInfoException extends RuntimeException{

    private ErrorInfoInterface errorInfo;

    public GlobalErrorInfoException (ErrorInfoInterface errorInfo) {
        this.errorInfo = errorInfo;
    }

    public ErrorInfoInterface getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(ErrorInfoInterface errorInfo) {
        this.errorInfo = errorInfo;
    }

}
