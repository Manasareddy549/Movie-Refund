package com.cap.anurag.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cap.anurag.entity.Account;

public interface AccountDao extends JpaRepository<Account, Integer>{

	@Query("select a from Account a where username=?1 and password=?2 ")
	public Account validate(String uname, String pass);
		
}
