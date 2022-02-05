package com.timsanalytics.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class SchedulerService {
    // REF: https://reflectoring.io/spring-scheduler/
    private final Logger logger = LoggerFactory.getLogger(getClass().getName());
    private final HttpService httpService;

    @Autowired
    public SchedulerService(HttpService httpService) {
        this.httpService = httpService;
    }

    @Scheduled(cron = "*/10 * * * * *")
    public void startScheduler() throws IOException {
        logger.info("Executing CRON scheduled task: " + LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));
        this.httpService.executePostRequest();

    }
}
