package com.msp.impulse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication(exclude={MongoAutoConfiguration.class})
public class ImpulseApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImpulseApplication.class, args);
    }
}
