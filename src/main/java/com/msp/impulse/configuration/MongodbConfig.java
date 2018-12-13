package com.msp.impulse.configuration;

import com.bugull.mongo.BuguConnection;
import com.bugull.mongo.BuguFramework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class MongodbConfig {
    @Autowired
    MongodbProperties mongodbProperties;
    @Bean
    @PostConstruct
    public BuguConnection getBuguConnection(){
        BuguConnection connection = BuguFramework.getInstance().createConnection("");
        connection.connect(mongodbProperties.getHost(), mongodbProperties.getPort(), mongodbProperties.getDatabase(), mongodbProperties.getUsername(), mongodbProperties.getPassword());
        return connection;
    }
}
