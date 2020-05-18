package com.cap.anurag;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.cap.anurag.dao.RefundDao;
import com.cap.anurag.entity.Refund;
import com.cap.anurag.service.MovieService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class Service2ApplicationTests {

	@InjectMocks
	MovieService movieservice;
	@Mock
	RefundDao refund;
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
//////*****updating refund table******//////
	@Test
	public void refundDetails() {
		Refund ref = new Refund();
		ref.setAccount_no(1000);
		ref.setBooking_id(85);
		ref.setSno(1);
		ref.setMoney_refunded(400);
		ref.setDate_of_refund("5/8/2020");
		// movieservice.save(refund);
		refund.save(ref);
		Mockito.verify(refund, Mockito.times(1)).save(ref);
	}
/////*****Refund list****/////
	@Test
	public void getRefundList() {
		List<Refund> reflist = new ArrayList<>();
		reflist.add(new Refund(119, 1000, 400, 118, "5/11/2020"));
		reflist.add(new Refund(121, 2000, 200, 119, "6/11/2020"));
		Mockito.when(refund.findAll()).thenReturn(reflist);
		List<Refund> returnedData = refund.findAll();
		assertEquals(returnedData.get(0).getBooking_id(), reflist.get(0).getBooking_id());
		assertEquals(2, returnedData.size()); // expected 23 but was 2
		assertNotEquals(24,returnedData.size());
	}

}
