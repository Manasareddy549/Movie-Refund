package com.cap.anurag.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.anurag.dao.AccountDao;
import com.cap.anurag.dao.CityDao;
import com.cap.anurag.dao.CustomerDao;
import com.cap.anurag.dao.LanguagesDao;
import com.cap.anurag.dao.MoviesDao;
import com.cap.anurag.dao.PaymentDao;
import com.cap.anurag.dao.RefundDao;
import com.cap.anurag.dao.SeatsDao;
import com.cap.anurag.dao.ShowsDao;
import com.cap.anurag.dao.TheatreDao;
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

@Service
@Transactional
public class MovieService implements MovieServiceInterface  {

	@Autowired
	private AccountDao validation;
	@Autowired
	private CityDao city;
	@Autowired
	private TheatreDao theatre;
	@Autowired
	private MoviesDao movie;
	@Autowired
	private ShowsDao shows;
	@Autowired
	private LanguagesDao language;
	@Autowired
	private SeatsDao seats;
	@Autowired
	private CustomerDao account;
	@Autowired 
	private PaymentDao payment;
	@Autowired
	private RefundDao refund;
	 

	// Validation of an account  
	@Override
	public Account validate(String uname, String pass) {
		return validation.validate(uname, pass);
	}

	//Displaying City Names
	public List<City> getCityNames() {
		return city.getCityNames();
	}
	
	//Displaying theatre names
	
	@Override
	public List<Theatre> theatreNames(String name) {
	List<Theatre> list = theatre.theatreNames(name);
	return list;
	}
	//Displaying movie names
	@Override
	public List<Movies> movieNames(String name) {
		List<Movies> list = movie.movieNames(name);
		return list;
	}
	//Displaying shows list
	public List<Shows> getShows() {
		return shows.getShows();
	
	}
	//Displaying languages
	@Override
	public List<Languages> getLanguage() {
		List<Languages> list = language.findAll();
		return list;
	}
	//Displaying seats
	@Override
	public List<Seats> getSeats() {
		List<Seats> list = seats.findAll();
		return list;
	}
	//Fetching Account number 
	@Override
	public Customer getAccountData(int acc_no) {
		return account.getAccountData(acc_no);
	}
	//Updating seats
	@Override
	public String updateSeats(Seats seat_obj) {
		boolean bool = seats.existsById(seat_obj.getSno());
		if(bool == true) {
			seats.save(seat_obj);
			return "seats were updated successfully!!";
		}
		else {
			return "sorry, seats were not updated";
		}
	}
	//Payment details
	  @Override public String payments(Payments pay) { 
		  payment.save(pay); 
		  int id = pay.getBooking_id();
		  return "your booking id is : "+id;
	  }
	  //Refund details
	@Override
	public Payments refund(int accountno, int bookingid) {
		return payment.refund(accountno, bookingid);
	}
	//Updating payment table
	@Override
	public String updatePayment(Payments pay) throws InvalidDetailsException {
		boolean bool = payment.existsById(pay.getBooking_id());
		if(bool == true) {
			payment.save(pay);
			return "payment details updated successfully!!";
		}
		else {
			//return "sorry,payment details not updated!!";
			throw new InvalidDetailsException("sorry,payment details not updated!!");
			
		}
	}
	//Refund details
	@Override
	public String refundDetails(Refund ref) {
		refund.save(ref);
		return "inserted the refund details successfully!!";
	}
	//Fetching remaining seats info
	@Override
	public Seats seatDetails(String s_type) {
		return seats.seatDetails(s_type);
	}
	//Updating seats after refund
	@Override
	public String setSeats(Seats seat) throws InvalidDetailsException {
		boolean bool = seats.existsById(seat.getSno());
		if(bool == true) {
			seats.save(seat);
			return "seats updated successfully!!";
		}
		else {
			throw new InvalidDetailsException("Sorry!! particular seats does not exist");
			
			//return "Sorry!!seats were not updated.";
		}
	}
//list refund details
	@Override
	public List<Refund> getRefundList() {
		List<Refund> list=refund.findAll();
		return list;
	}

	@Override
	public String updateCustomer(Customer cus) throws InvalidDetailsException {
		boolean bool = account.existsById(cus.getAccount_no());
		if(bool){
			account.save(cus);
			return "the customer table was updated successfully..!!";
		}
		else{
			throw new InvalidDetailsException("sorry, customer table was not updated..!!");
			
			//return "sorry, customer table was not updated..!!";
		}
	}
	
}