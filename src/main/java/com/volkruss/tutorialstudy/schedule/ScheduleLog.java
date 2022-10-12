package com.volkruss.tutorialstudy.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class ScheduleLog {
    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleLog.class);
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    @Scheduled(fixedDelay = 5000)
    public void log(){
        LOGGER.info("CurrentTime : " + LocalDateTime.now().format(formatter));
    }
}
