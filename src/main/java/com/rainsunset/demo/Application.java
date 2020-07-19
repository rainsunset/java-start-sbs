package com.rainsunset.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.bind.annotation.RestController;

@RestController
@MapperScan("com.rainsunset.demo.dal.mapper")
@SpringBootApplication(scanBasePackages = "com.rainsunset")
@ImportResource("classpath:spring/spring-context.xml")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}