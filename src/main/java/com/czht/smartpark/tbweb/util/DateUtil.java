package com.czht.smartpark.tbweb.util;

import org.apache.commons.lang3.time.DateUtils;
import org.joda.time.DateTime;

import java.util.Date;

public class DateUtil extends DateUtils{

    public static Date getDate() {
        return new Date();
    }

    public static String getDate(String pattern) {
        return new DateTime().toString(pattern);
    }

    public static void main(String[] args) {
        System.out.println(getDate("yyyy-MM-dd HH:mm:ss E"));
    }

}
