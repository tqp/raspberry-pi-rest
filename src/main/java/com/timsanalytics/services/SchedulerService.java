package com.timsanalytics.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class SchedulerService {
    private final Logger logger = LoggerFactory.getLogger(getClass().getName());
    // REF: https://reflectoring.io/spring-scheduler/
    @Scheduled(cron = "*/10 * * * * *")
    public void startScheduler() {
        logger.info("Executing CRON scheduled task: " + LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));


    }
}
