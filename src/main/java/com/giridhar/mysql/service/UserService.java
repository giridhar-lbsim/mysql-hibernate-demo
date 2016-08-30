package com.giridhar.mysql.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.giridhar.mysql.domain.User;

public interface UserService {
	
	User save(User user);
	
	User findByLastName(String lastName);
	
	List<User> findAll();
	
	Object deleteById(Long id);
	
	Page<User> findAll(Integer pageNumber, Integer pageSize);

}
