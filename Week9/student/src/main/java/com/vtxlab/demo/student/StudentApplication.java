package com.vtxlab.demo.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import com.vtxlab.demo.student.entity.Student;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication // = 
// SpringBootConfiguration (@Configuration) + // it try to find has to be configured in spring container
// @ComponentScan
// EnableAutoConfiguration (TBC)
public class StudentApplication {



	private static ConfigurableApplicationContext applicationContext;

	public static void main(String[] args) {
		applicationContext = SpringApplication.run(StudentApplication.class, args);
		displayAllBean();
	}

	public static void displayAllBean(){
		String [] allBStrings = applicationContext.getBeanDefinitionNames();
		for(String s : allBStrings){
    log.info("bean: {}", s);
		}
	}

}
