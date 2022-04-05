package com.airblox.learningspringboot.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Scheduler {
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    @Scheduled(cron = "0 * 9 * * ?")
    public void cronJob(){
        Date now = new Date();
        String strDate = simpleDateFormat.format(now);
        log.info("Java cron expression::" + strDate);
    }

    @Scheduled(fixedRate = 1000)
    public void fixedRateCronJob(){
        Date now = new Date();
        String strDate = simpleDateFormat.format(now);
        log.info("Fixed rate cron job::" + strDate);
    }
}
