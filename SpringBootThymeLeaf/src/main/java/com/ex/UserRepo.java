package com.ex;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User, Integer> {

	@Query("from User where email=?1 and password=?2")
	public List getUser(String email, String password);
}
