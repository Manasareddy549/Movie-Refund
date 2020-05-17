package com.cap.anurag.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cap.anurag.entity.City;

public interface CityDao extends JpaRepository<City, Integer>{
	@Query("select c from City c")
	List<City> getCityNames();

}
