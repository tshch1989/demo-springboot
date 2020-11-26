package com.example.demospringboot;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("com.example.demospringboot.**.infrastructure.repositories.jpa")
@EnableMongoRepositories("com.example.demospringboot.**.infrastructure.repositories.mongo")
@EnableTransactionManagement
public class AppConfig {
}
