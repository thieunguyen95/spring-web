package com.thieu.async.controller;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.thieu.async.model.EmployeeAddresses;
import com.thieu.async.model.EmployeeNames;
import com.thieu.async.model.EmployeePhone;
import com.thieu.async.service.AsyncService;

@RestController
public class AsyncController {

	private static Logger log = LoggerFactory.getLogger(AsyncController.class);

	@Autowired
	private AsyncService service;

	@RequestMapping(value = "/test-async", method = RequestMethod.GET)
	public Object testAsync() {
		try {
			log.info("testAsynch Start");
			CompletableFuture<EmployeeAddresses> employeeAddress = service.getEmployeeAddress();
			CompletableFuture<EmployeeNames> employeeName = service.getEmployeeName();
			CompletableFuture<EmployeePhone> employeePhone = service.getEmployeePhone();

			// Wait until they are all done
//			CompletableFuture.allOf(employeeAddress, employeeName, employeePhone).join();
//
//			EmployeeAddresses empDressData = employeeAddress.get();
//			log.info("EmployeeAddress--> " + empDressData);
//			log.info("EmployeeName--> " + employeeName.get());
//			log.info("EmployeePhone--> " + employeePhone.get());

			// Wait 3 seconds
			EmployeeAddresses empDressData = employeeAddress.get(3000, TimeUnit.MILLISECONDS);
			log.info("EmployeeAddress--> " + empDressData);
			return empDressData;
		}catch (Exception ex){
			log.error(">> {}", ex.toString());
		}
		return null;
	}
}
