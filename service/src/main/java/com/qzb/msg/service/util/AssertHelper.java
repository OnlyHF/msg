package com.qzb.msg.service.util;

import com.qzb.msg.service.exception.ApiException;

import java.util.Objects;

/**
 * AssertHelper.
 *
 * @Author qzb0212@126.com
 * @Date 2024-10-01 15:40:06
 */
public class AssertHelper {

    /**
     * notNull.
     *
     * @param obj   obj
     * @param errorKey  errorKey
     */
    public static void notNull(final Object obj, final String errorKey) {
        if (Objects.isNull(obj)) {
            throw new ApiException(errorKey);
        }
    }

}
