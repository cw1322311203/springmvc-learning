package com.cw.exception;

/**
 * @author 陈小哥cw
 * @date 2021/1/15 15:26
 * 自定义异常继承RuntimeException，覆盖父类所有的构造方法
 */
public class SystemException extends RuntimeException {
    public SystemException() {
        super();
    }

    public SystemException(String message) {
        super(message);
    }

    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }

    public SystemException(Throwable cause) {
        super(cause);
    }

    protected SystemException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
