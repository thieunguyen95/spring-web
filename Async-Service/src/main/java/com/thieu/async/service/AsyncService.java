package com.thieu.async.service;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.thieu.async.model.EmployeeAddresses;
import com.thieu.async.model.EmployeeNames;
import com.thieu.async.model.EmployeePhone;

@Service
public class AsyncService {

	private static Logger log = LoggerFactory.getLogger(AsyncService.class);

	@Autowired
	private RestTemplate restTemplate;



	@Async("asyncExecutor")
	public CompletableFuture<EmployeeNames> getEmployeeName() throws InterruptedException 
	{
		log.info("getEmployeeName Starts");
//		EmployeeNames employeeNameData = restTemplate.getForObject("http://localhost:8080/name", EmployeeNames.class);
		EmployeeNames employeeNameData = new EmployeeNames();

		log.info("employeeNameData, {}", employeeNameData);
		Thread.sleep(10000L);	//Intentional delay
		log.info("employeeNameData completed");
		return CompletableFuture.completedFuture(employeeNameData);
	}

	@Async("asyncExecutor")
	public CompletableFuture<EmployeeAddresses> getEmployeeAddress() throws InterruptedException 
	{
		log.info("getEmployeeAddress Starts");
//		EmployeeAddresses employeeAddressData = restTemplate.getForObject("http://localhost:8080/address", EmployeeAddresses.class);
		EmployeeAddresses employeeAddressData = new EmployeeAddresses();

		log.info("employeeAddressData, {}", employeeAddressData);
		Thread.sleep(10000L);	//Intentional delay
		log.info("employeeAddressData completed");
		return CompletableFuture.completedFuture(employeeAddressData);
	}

	@Async("asyncExecutor")
	public CompletableFuture<EmployeePhone> getEmployeePhone() throws InterruptedException 
	{
		log.info("getEmployeePhone Starts");
//		EmployeePhone employeePhoneData = restTemplate.getForObject("http://localhost:8080/phone", EmployeePhone.class);
		EmployeePhone employeePhoneData = new EmployeePhone();
		log.info("employeePhoneData, {}", employeePhoneData);
		Thread.sleep(10000L);	//Intentional delay
		log.info("employeePhoneData completed");
		return CompletableFuture.completedFuture(employeePhoneData);
	}

}
