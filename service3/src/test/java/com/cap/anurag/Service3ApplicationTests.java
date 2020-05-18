package com.cap.anurag;

import static org.junit.Assert.assertEquals;

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

import com.cap.anurag.dao.SeatsDao;
import com.cap.anurag.entity.Seats;
import com.cap.anurag.service.MovieService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class Service3ApplicationTests {
	@InjectMocks
	MovieService movieservice;
	@Mock
	SeatsDao seats;
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
///////*******seats lists*****//////
	@Test
	public void seatDetails() {
		List<Seats> seatlist = new ArrayList<>();
		seatlist.add(new Seats(1, "GOLD", 45, 300));
		seatlist.add(new Seats(2, "SILVER", 52, 200));
		Mockito.when(seats.findAll()).thenReturn(seatlist);
		List<Seats> sl = seats.findAll();
		assertEquals(sl.get(1).getSno(), seatlist.get(1).getSno());
		assertEquals(2, sl.size());// expected 3 but was 2
	}
///////******updating seats*******//////
	@Test
	public void setSeats() {
		Seats s = new Seats();
		s.setSno(1);
		s.setSeat_type("GOLD");
		s.setAvailable_seats(50);
		s.setPrice(300);
		seats.save(s);
		Mockito.verify(seats, Mockito.times(1)).save(s);
	}

}
