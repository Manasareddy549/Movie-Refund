package com.cap.anurag.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cap.anurag.dao.RefundDao;
import com.cap.anurag.entity.Refund;

@Service
@Transactional
public class MovieService implements MovieServiceInterface  {

	@Autowired
	private RefundDao refund;
	//Refund details
	@Override
	public String refundDetails(Refund ref) {
		refund.save(ref);
		return "inserted the refund details successfully!!";
	}
	//list refund details
			@Override
			public List<Refund> getRefundList() {
				List<Refund> list=refund.findAll();
				return list;
			}
		
	}