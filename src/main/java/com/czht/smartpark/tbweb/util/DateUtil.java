package com.czht.smartpark.tbweb.util;

import org.apache.commons.lang3.time.DateUtils;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import java.util.Date;

public class DateUtil extends DateUtils{

    public static Date getDate() {
        return new Date();
    }

    public static String getDate(String pattern) {
        return new DateTime().toString(pattern);
    }

    /**
     * 获得上周周一的时间
     * @return
     */
    public static String getLastMonday(){

        LocalDate d = LocalDate.now();
        return d.minusWeeks(1).dayOfWeek().withMinimumValue().toString("yyyy-MM-dd");
    }

    /**
     * 获得上周周日的时间
     * @return
     */
    public static String getLastSunday(){

        LocalDate d = LocalDate.now();
        return d.minusWeeks(1).dayOfWeek().withMaximumValue().toString("yyyy-MM-dd");
    }

    /**
     * 这周周一
     * @return
     */
    public static String getMonday(){

        return DateTime.now().dayOfWeek().withMinimumValue().toString("yyyy-MM-dd");
    }

    /**
     * 这周周日
     * @return
     */
    public static String getSunday(){

        return DateTime.now().dayOfWeek().withMaximumValue().toString("yyyy-MM-dd");
    }

    /**
     * 今天周几
     * @return
     */
    public static int getWeek(){
        return DateTime.now().dayOfWeek().get();
    }

    public static void main(String[] args) {
        System.out.println(getWeek());
    }

}
