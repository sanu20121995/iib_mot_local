package com.iib.gov;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
//@EnableCaching
public class VahanDetailsToInsurerApplication {

	public static void main(String[] args) {
		SpringApplication.run(VahanDetailsToInsurerApplication.class, args);
	}

}
