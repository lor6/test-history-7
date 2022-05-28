package com.baeldung.boot.composite.key;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@PropertySource("classpath:boot.composite.key/app.properties")
@EnableMongoRepositories(basePackages = { "com.baeldung.boot.composite.key" })
public class SpringBootCompositeKeyApplication {
    public static void main(String... args) {
        SpringApplication.run(SpringBootCompositeKeyApplication.class, args);
    }
}
