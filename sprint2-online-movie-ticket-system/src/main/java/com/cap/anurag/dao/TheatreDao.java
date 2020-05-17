package com.cap.anurag.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cap.anurag.entity.Theatre;

public interface TheatreDao extends JpaRepository<Theatre, Integer>{

	@Query("select t from Theatre t where city_name=?1")
	public List<Theatre> theatreNames(String name);
}
