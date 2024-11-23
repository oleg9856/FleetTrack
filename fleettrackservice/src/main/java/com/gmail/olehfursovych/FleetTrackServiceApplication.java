package com.gmail.olehfursovych;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FleetTrackServiceApplication {
    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext context = SpringApplication.run(FleetTrackServiceApplication.class, args);
        // Prevent the JVM from exiting
        Thread.currentThread().join();
    }
}
