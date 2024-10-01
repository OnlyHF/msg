package com.qzb.msg.service.exception;

/**
 * ApiException.
 *
 * @Author qzb0212@126.com
 * @Date 2024-10-01 15:41:33
 */
public class ApiException extends RuntimeException {

    public ApiException(final String errorKey) {
        super(errorKey);
    }

}
