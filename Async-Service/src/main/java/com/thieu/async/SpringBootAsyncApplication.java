package com.thieu.async;

import com.thieu.async.config.CustomPropertiesConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
public class SpringBootAsyncApplication implements CommandLineRunner {

	@Autowired
	CustomPropertiesConfig customPropertiesConfig;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAsyncApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		System.out.println(customPropertiesConfig.getIso8583ToAtomicCode("00"));
		System.out.println(customPropertiesConfig.getIso8583ToAtomicCode("000"));
		System.out.println(customPropertiesConfig.getOSBToAtomicCode("03"));
		System.out.println(customPropertiesConfig.getDBToAtomicCode("151"));
		System.out.println(1);
	}
}
