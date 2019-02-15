package com.cnc.springbootstep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class SpringbootstepApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootstepApplication.class, args);
	}
}
