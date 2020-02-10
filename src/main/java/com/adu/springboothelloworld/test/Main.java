package com.adu.springboothelloworld.test;

import java.util.Calendar;
import java.util.Date;

/**
 * @author jintang
 * @date 2019-12-23
 */
public class Main {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        Date envCreateDate = new Date(1577082623000L);
        cal.setTime(envCreateDate);
        Long minutesCount = nMinutesBetweenTwoDate(envCreateDate, new Date());
        Integer timeoutValue = Integer.parseInt("30");
        //return minutesCount > timeoutValue;
        System.out.println(minutesCount);
        System.out.println(timeoutValue);
    }

    private static Long nMinutesBetweenTwoDate(Date beginDate, Date endDate) {
        long minute = 0L;
        minute = (endDate.getTime() - beginDate.getTime()) / 60000L;
        return minute;
    }

}
