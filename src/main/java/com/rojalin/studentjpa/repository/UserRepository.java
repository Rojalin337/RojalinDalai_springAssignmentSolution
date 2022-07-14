package com.rojalin.studentjpa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.rojalin.studentjpa.model.User;

public interface UserRepository  extends  CrudRepository<User, Long>
{

	@Query("SELECT u from User u where u.username= :username")
	public User getUserByUsername(@Param("username") String username);
}
