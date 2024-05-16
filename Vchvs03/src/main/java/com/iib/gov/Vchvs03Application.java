package com.iib.gov;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;


@SpringBootApplication
@EnableEncryptableProperties

@EnableCaching
public class Vchvs03Application {
	


	public static void main(String[] args) {
		SpringApplication.run(Vchvs03Application.class, args);
		

	}

}
