package com.example.HystrixPresentation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@PropertySource("classpath:/application.yaml")
@EnableHystrixDashboard
public class HystrixPresentationApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystrixPresentationApplication.class, args);
	}
}
