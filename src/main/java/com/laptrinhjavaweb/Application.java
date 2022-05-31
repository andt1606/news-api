package com.laptrinhjavaweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

//exclude = {SecurityAutoConfiguration.class }
@SpringBootApplication
public class Application  {

	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
