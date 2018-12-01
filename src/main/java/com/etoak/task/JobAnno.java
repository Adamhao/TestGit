package com.etoak.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Adam on 2018/11/19 9:16.
 */
@Component
public class JobAnno {


    @Scheduled(cron="0/5 * * * * ?")
    public void jobAnno() {

        System.out.println("jobAnno : " + new Date().toLocaleString());

    }

}
