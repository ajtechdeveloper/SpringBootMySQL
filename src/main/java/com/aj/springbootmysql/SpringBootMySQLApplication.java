package com.aj.springbootmysql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootMySQLApplication {

    private static final Logger logger = LoggerFactory.getLogger(SpringBootMySQLApplication.class);

    public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootMySQLApplication.class,args);
	}
}
