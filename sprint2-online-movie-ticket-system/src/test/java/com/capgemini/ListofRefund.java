package com.capgemini;

import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

import com.cap.anurag.entity.Refund;
import com.cap.anurag.service.MovieServiceInterface;

public class ListofRefund {

	//@Test
	//public void test() {
	//fail("Not yet implemented");
	//}

	@Autowired
	private MovieServiceInterface movieservice;
	@Test
	public void getRefundList(){
		List<Refund> list=movieservice.getRefundList();
		Assertions.assertEquals(22, list.size());
	}
	
	
	

}
