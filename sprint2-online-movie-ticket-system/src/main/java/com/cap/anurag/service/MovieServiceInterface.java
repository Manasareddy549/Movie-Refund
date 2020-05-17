package com.cap.anurag.service;

import java.util.List;

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

public interface MovieServiceInterface {

	Account validate(String uname, String pass);
	List<City> getCityNames();
	List<Theatre> theatreNames(String name);
	List<Movies> movieNames(String name);
	List<Shows> getShows();
	List<Languages> getLanguage();
	List<Seats> getSeats();
	Customer getAccountData(int acc_no);
	String updateSeats(Seats seat_obj);
	String payments(Payments pay);
	Payments refund(int acc_no, int book_id);
	String updatePayment(Payments pay) throws InvalidDetailsException;
	String refundDetails(Refund ref);
	Seats seatDetails(String s_type);
	String setSeats(Seats seat) throws InvalidDetailsException;
	List<Refund> getRefundList();
	String updateCustomer(Customer cus) throws InvalidDetailsException;
	
	
}
