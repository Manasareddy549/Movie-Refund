package com.cap.anurag;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.cap.anurag.dao.CustomerDao;
import com.cap.anurag.entity.Customer;
import com.cap.anurag.service.MovieService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class Service4ApplicationTests {
	@InjectMocks
	MovieService movieservice;
	@Mock
	CustomerDao account;
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
///////*****updating customer account balance*****////
	@Test
	public void updateCustomer() {
		Customer cus = new Customer();
		cus.setAccount_no(1000);
		cus.setName("manasa reddy");
		cus.setUsername("manasa");
		cus.setPassword("manasa123");
		cus.setCurrent_balance(5500);
		account.save(cus);
		Mockito.verify(account, Mockito.times(1)).save(cus);
	}

}
