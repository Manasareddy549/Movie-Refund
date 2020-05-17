package com.cap.anurag.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cap.anurag.entity.Shows;

public interface ShowsDao extends JpaRepository<Shows, Integer>{
	@Query("select a from Shows a ")

	List<Shows> getShows();

}
