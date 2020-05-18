package com.cap.anurag.service;

import java.util.List;

import com.cap.anurag.entity.Refund;

public interface MovieServiceInterface {

	String refundDetails(Refund ref);
	List<Refund> getRefundList();	
}
