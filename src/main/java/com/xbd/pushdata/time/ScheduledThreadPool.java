package com.xbd.pushdata.time;

import java.util.Date;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class ScheduledThreadPool {

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(1);

        System.out.println("Current Time = " + new Date());
        //for(int i=0; i<10; i++){
        //Thread.sleep(1000);
        //WorkerThread worker = new WorkerThread("do heavy processing");
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("测试");
            }
        };

        scheduledThreadPool.schedule(timerTask, 30, TimeUnit.SECONDS);
        //scheduledThreadPool.scheduleAtFixedRate(worker, 5, 5, TimeUnit.SECONDS);
        //scheduledThreadPool.scheduleWithFixedDelay(worker, 5, 3, TimeUnit.SECONDS);
        //}
//        Thread.sleep(300000);

        scheduledThreadPool.shutdown();
        while (!scheduledThreadPool.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }

    private static void test() {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("测试");
            }
        };
    }

}