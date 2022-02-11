package com.chubock.locationservice;

import com.chubock.locationservice.service.LocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Slf4j
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
@EnableJpaRepositories
public class LocationServiceApplication {

    @Autowired
    LocationService locationService;

    public static void main(String[] args) {
        SpringApplication.run(LocationServiceApplication.class, args);
    }
}
