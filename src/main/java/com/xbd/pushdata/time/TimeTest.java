package com.xbd.pushdata.time;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

/**
 * java演示倒计时
 */
public class TimeTest {
    public static int time = 60 * 60 * 60;
    public static Calendar c;
    public static long endTime;
    public static Date date;
    public static long startTime;
    public static long midTime;

    public static void main(String[] args) {
        c = Calendar.getInstance();
        c.set(2020, 9, 18, 0, 0, 0);// 注意月份的设置，0-11表示1-12月
        // c.set(Calendar.YEAR, 2017);
        // c.set(Calendar.MONTH, 4);
        // c.set(Calendar.DAY_OF_MONTH, 17);
        // c.set(Calendar.HOUR_OF_DAY, 0);
        // c.set(Calendar.MINUTE, 0);
        // c.set(Calendar.SECOND, 0);
        endTime = c.getTimeInMillis();
        date = new Date();
        startTime = date.getTime();
        midTime = (endTime - startTime) / 1000;

        // time1();//方式一
        //time2();// 方式二
        // time3();//方式三
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date2 = new Date(date.getTime() + 30000);
//        time0("2020-09-17 16:04:30");
        time01(sdf.format(date2));
    }

    /**
     * 方式三： 使用java.util.Timer类进行倒计时
     */
    private static void time3() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                midTime--;
                long hh = midTime / 60 / 60 % 60;
                long mm = midTime / 60 % 60;
                long ss = midTime % 60;
                System.out.println("还剩" + hh + "小时" + mm + "分钟" + ss + "秒");
            }
        }, 0, 1000);
    }

    /**
     * 方式二： 设定时间戳，倒计时
     */
    private static void time2() {

        while (midTime > 0) {
            midTime--;
            long hh = midTime / 60 / 60 % 60;
            long mm = midTime / 60 % 60;
            long ss = midTime % 60;
            System.out.println("还剩" + hh + "小时" + mm + "分钟" + ss + "秒");
            try {
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 方式一： 给定时长倒计时
     */
    private static void time1() {
        while (time > 0) {
            time--;
            try {
                Thread.sleep(1000);
                int hh = time / 60 / 60 % 60;
                int mm = time / 60 % 60;
                int ss = time % 60;
                System.out.println("还剩" + hh + "小时" + mm + "分钟" + ss + "秒");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    /**
     * 方式三： 使用java.util.Timer类进行倒计时
     */
    private static void time0(String dateStr) {
        long timechaju = 0;
        Date timeDate = new Date();
        long ld3 = timeDate.getTime();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date sDt7 = sf.parse(dateStr);
            long ld7 = sDt7.getTime();
            timechaju = ld7 - ld3;
            System.out.println(timechaju);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                midTime--;
                long hh = midTime / 60 / 60 % 60;
                long mm = midTime / 60 % 60;
                long ss = midTime % 60;
                System.out.println("还剩" + hh + "小时" + mm + "分钟" + ss + "秒");
            }
        }, 1000, timechaju);  //延迟1000毫秒执行,再接着就是以timechaju为周期进行循环
    }

    public void times(String dateStr) {
        long timechaju = 0;
        Date timeDate = new Date();
        long ld3 = timeDate.getTime();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date sDt7 = sf.parse(dateStr);
            long ld7 = sDt7.getTime();
            timechaju = ld7 - ld3;
            System.out.println(timechaju);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                midTime--;
                long hh = midTime / 60 / 60 % 60;
                long mm = midTime / 60 % 60;
                long ss = midTime % 60;
                System.out.println("还剩" + hh + "小时" + mm + "分钟" + ss + "秒");
            }
        }, 1000, timechaju);  //延迟1000毫秒执行,再接着就是以timechaju为周期进行循环
    }


    /**
     * 方式三： 使用java.util.Timer类进行倒计时
     */
    private static void time01(String dateStr) {
        ScheduledExecutorService timers = new ScheduledThreadPoolExecutor(2);


        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("测试");
            }
        };
        timers.schedule(timerTask, 5000, TimeUnit.MILLISECONDS);
        System.out.println("已经开始了");
        //timers.shutdown();
    }


}