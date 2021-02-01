package com.xbd.pushdata.time;

import javafx.concurrent.Task;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@RestController
public class TestScheduledExecutorService {

    private ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1,
            new BasicThreadFactory.Builder().namingPattern("example-schedule-pool-%d").build());
    //public long start;

   /* TestScheduledExecutorService(){
        this.scheduExec =  Executors.newScheduledThreadPool(2);
       // this.start = System.currentTimeMillis();
    }*/


    public static void main(String[] args) {
        TestScheduledExecutorService testScheduledExecutorService = new TestScheduledExecutorService();
        testScheduledExecutorService.time01("weweqwewqe");
        testScheduledExecutorService.time01("212212");
        testScheduledExecutorService.time01("34343434");
        testScheduledExecutorService.time01("98989898");
    }

    @RequestMapping("/subscribetest")
    public void time01(String str) {
        executorService.schedule(new Runnable() {
            public void run() {
                System.out.println("timerTwo,the time:" + (System.currentTimeMillis() + str));
            }
        }, 5000, TimeUnit.MILLISECONDS);
        System.out.println("start");
//        scheduExec.shutdown();
    }
}
