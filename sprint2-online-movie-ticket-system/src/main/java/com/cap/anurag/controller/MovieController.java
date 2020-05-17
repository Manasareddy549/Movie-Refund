package com.cap.anurag.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cap.anurag.entity.Account;
import com.cap.anurag.entity.City;
import com.cap.anurag.entity.Customer;
import com.cap.anurag.entity.Languages;
import com.cap.anurag.entity.Movies;
import com.cap.anurag.entity.Payments;
import com.cap.anurag.entity.Refund;
import com.cap.anurag.entity.Seats;
import com.cap.anurag.entity.Shows;
import com.cap.anurag.entity.Theatre;
import com.cap.anurag.exception.InvalidDetailsException;
import com.cap.anurag.service.MovieServiceInterface;

@RestController
@CrossOrigin("http://localhost:4200")
public class MovieController {
	//controller level exception handling
		@ResponseStatus(value=HttpStatus.NOT_FOUND,reason="controller account is not present")
		@ExceptionHandler({Exception.class})
		public void handleException()
		{
			
		}
		
	@Autowired
	private MovieServiceInterface movieservice;
	
	//Login Details
	@GetMapping("/validation/{username}/{password}")
	public ResponseEntity<Account> validate(@PathVariable("username") String uname, @PathVariable("password") String pwd){
		Account auth = movieservice.validate(uname, pwd);
		ResponseEntity<Account> response = new ResponseEntity<Account>(auth,HttpStatus.OK);
		return response;
	}
	//displaying cities
	@GetMapping("/cities")
	public List<City> cityNames(){
		List<City> list = movieservice.getCityNames();
		return list;
	}
	//displaying theatres
	@GetMapping("/theatres/{city-name}")
	public List<Theatre> theatreNames(@PathVariable("city-name") String name){
		List<Theatre> list = movieservice.theatreNames(name);
		return list;
	}
	//displaying movies
	@GetMapping("/movies/{theatre-name}")
	public List<Movies> movieNames(@PathVariable("theatre-name") String name){
		List<Movies> list = movieservice.movieNames(name);
		return list;
	}
	//displaying shows
	@GetMapping("/shows")
	public List<Shows> getShows(){
		List<Shows> list = movieservice.getShows();
		return list;
	}
	//displaying languages
	@GetMapping("/languages")
	public List<Languages> getLanguage(){
		List<Languages> list = movieservice.getLanguage();
		return list;
	}
	//displaying seats
	@GetMapping("/seats")
	public List<Seats> getSeats(){
		List<Seats> list = movieservice.getSeats();
		return list;
	}
	//fetching account number
	@GetMapping("/account_data/{account_no}")
	public ResponseEntity<Customer> getAccountData(@PathVariable("account_no") int accno) {
		Customer customer = movieservice.getAccountData(accno);
		ResponseEntity<Customer> response = new ResponseEntity<Customer>(customer,HttpStatus.OK);
		return response;
	}
	//updating seats
	@PutMapping("/update_seats")
	public String updateSeats(@RequestBody Seats seat) {
		String string = movieservice.updateSeats(seat);
		return string;
	}
	//payment details
	@PostMapping("/payments") 
	public String payments(@RequestBody Payments pay) {
		String string = movieservice.payments(pay); 
		return string; 
	}
	//refund details
	@GetMapping("/refund/{acc_no}/{book_id}")
	public Payments refund(@PathVariable("acc_no") int accno, @PathVariable("book_id") int bookingid){
		return movieservice.refund(accno, bookingid);
	}
	//updating payment
	@PutMapping("/update_payment")
	public String updatePayment(@RequestBody Payments payment) throws InvalidDetailsException {
		String string = movieservice.updatePayment(payment);
		return string;
	}
	//refund details
	@PostMapping("/refund_details")
	public String refundDetails(@RequestBody Refund refund)  throws InvalidDetailsException {
		String string = movieservice.refundDetails(refund);
		return string;
	}
	
	//list refund details
	@GetMapping("/listrefund")
	public	List<Refund> getRefundList(){
	List<Refund> list= movieservice.getRefundList();
	return list;
	}
	
	
	
	//seats information
	@GetMapping("/seat_details/{seat_type}")
	public Seats seatDetails(@PathVariable("seat_type") String seattype ) {
		return movieservice.seatDetails(seattype);
	}
	//updating seats
	@PutMapping("/set_seats")
	public String setSeats(@RequestBody Seats seat ) throws InvalidDetailsException  {
		String string = movieservice.setSeats(seat);
		if(string!=null)
		{
			return "updated successfully!!"+"Sno:"+" "+seat.getSno()+" "+"seat_type:"+" "+seat.getSeat_type()+" "+"seats available:"+" "+seat.getAvailable_seats()+" "+"price:"+" "+seat.getPrice();
		}
		else
		{
			return "seats not updated";
		}
	}
	
	@PutMapping("/update_customer")
	public ResponseEntity<String> updateCustomer(@RequestBody Customer cus) throws InvalidDetailsException {
		String string = movieservice.updateCustomer(cus);
		return new ResponseEntity<>(string,HttpStatus.OK);
	}
}