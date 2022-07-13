package com.lh.money.util;

import java.time.LocalDateTime;

/**
 * @author lihao
 */
public class LocalDataSimplify {

    public void localDataTime() {
        LocalDateTime now =LocalDateTime.now();

        //2022-07-13T03:00 年月日加上固定的时分
        LocalDateTime waterStart =LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(),3,0);
        //2022-07-13T03:00 年月日时分秒
        LocalDateTime waterEndTime =LocalDateTime.of(now.getYear(), now.getMonth(), now.getDayOfMonth(),
                now.getHour(),now.getMinute(),now.getSecond());
        System.out.println(waterStart);
        System.out.println(waterEndTime);
    }

    public static void main(String[] args) {
        new LocalDataSimplify().localDataTime();
    }

}
