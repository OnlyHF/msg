package com.qzb.msg.common.date;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.qzb.msg.common.constant.DateConstant.YYYY_MM_DD;
import static com.qzb.msg.common.constant.DateConstant.Y_M_D_H_M_S;

/**
 * DateHelper.
 *
 * @Author qzb0212@126.com
 * @Date 2024-09-21 21:26:49
 */
public class DateHelper {

    /**
     * date2StrYMDHMS.
     *
     * @param date  date
     * @return  yyyy-MM-dd HH:mm:ss
     */
    public static String date2StrYMDHMS(final Date date) {
        return date2Str(date, Y_M_D_H_M_S);
    }

    /**
     * date2StrYMD.
     *
     * @param date  date
     * @return  yyyy-MM-dd
     */
    public static String date2StrYMD(final Date date) {
        return date2Str(date, YYYY_MM_DD);
    }

    /**
     * 日期类型转换.
     *
     * @param date  date
     * @param pattern   pattern
     * @return  pattern
     */
    public static String date2Str(final Date date, final String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String result = simpleDateFormat.format(date);
        return result;
    }

}
