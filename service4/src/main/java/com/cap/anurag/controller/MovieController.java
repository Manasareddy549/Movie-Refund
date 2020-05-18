package com.cap.anurag.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cap.anurag.entity.Customer;
import com.cap.anurag.exception.InvalidDetailsException;
import com.cap.anurag.service.MovieServiceInterface;

@RestController
@CrossOrigin("http://localhost:4200")
public class MovieController {

	@Autowired
	private MovieServiceInterface movieservice;

	@PutMapping("/update_customer")
	public ResponseEntity<String> updateCustomer(@RequestBody Customer cus) throws InvalidDetailsException {
		String string = movieservice.updateCustomer(cus);
		return new ResponseEntity<>(string, HttpStatus.OK);
	}

}