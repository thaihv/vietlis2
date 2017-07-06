package com.uitgis.vietlis.valuation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@Slf4j
public class LandValuationApplication {

	public static void main(String[] args) {
		SpringApplication.run(LandValuationApplication.class, args);
		log.info("VietLIS-Valuation started!");
	}
}
