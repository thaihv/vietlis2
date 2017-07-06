package com.uitgis.vietlis.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;



@SpringBootApplication
@Slf4j
public class UiApplication {

	public static void main(String[] args) {
		SpringApplication.run(UiApplication.class, args);
		log.info("VietLIS-UI started!");
	}
}
