package com.pinnoserv.portal;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableAsync
@EnableScheduling
@SpringBootApplication(scanBasePackages = {"com.pinnoserv.portal"})
@Slf4j
public class ApplicationLauncher extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationLauncher.class, args);
	}

}
