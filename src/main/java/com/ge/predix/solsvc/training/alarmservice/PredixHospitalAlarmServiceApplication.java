package com.ge.predix.solsvc.training.alarmservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;

@SpringBootApplication
public class PredixHospitalAlarmServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PredixHospitalAlarmServiceApplication.class, args);
    }
}
