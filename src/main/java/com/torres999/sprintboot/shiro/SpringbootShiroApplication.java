package com.torres999.sprintboot.shiro;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@Slf4j
@SpringBootApplication
public class SpringbootShiroApplication {

	public static void main(String[] args) {
		log.info("SpringbootShiro starting!!!!");
		ApplicationContext app = SpringApplication.run(SpringbootShiroApplication.class, args);
		String[] activeProfiles = app.getEnvironment().getActiveProfiles();
		for(String activeProfile : activeProfiles){
			log.info("=============================================");
			log.info("SpringbootShiro profile : [{}]", activeProfile);
			log.info("=============================================");
		}
		log.info("SpringbootShiro started!!!!");
	}
}
