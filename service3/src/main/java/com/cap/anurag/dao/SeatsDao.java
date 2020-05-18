package com.cap.anurag.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cap.anurag.entity.Seats;

public interface SeatsDao extends JpaRepository<Seats, Integer>{

	@Query("select s from Seats s where seat_type=?1")
	public Seats seatDetails(String s_type);
}