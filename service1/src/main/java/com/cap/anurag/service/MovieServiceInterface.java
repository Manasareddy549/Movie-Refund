package com.cap.anurag.service;


import com.cap.anurag.entity.Payments;
import com.cap.anurag.exception.InvalidDetailsException;
public interface MovieServiceInterface {

	Payments refund(int acc_no, int book_id);

	String updatePayment(Payments pay)throws InvalidDetailsException;

}
