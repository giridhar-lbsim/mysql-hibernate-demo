package com.giridhar.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.giridhar.mysql.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByLastName(String lastName);

}
