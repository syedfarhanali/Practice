package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class SpringBootLearnApplication {

	public static void main(String[] args) {

        SpringApplication.run(SpringBootLearnApplication.class, args);
/*
        ConfigurableApplicationContext context = null;

        try{
            context =  SpringApplication.run(SpringBootLearnApplication.class, args);
        } finally
        {
            if (context != null) {
                context.close();
            }
        }*/

	}
}
