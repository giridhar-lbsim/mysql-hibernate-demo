package com.giridhar.mysql.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.giridhar.mysql.domain.User;
import com.giridhar.mysql.repository.UserRepository;
import com.giridhar.mysql.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	Logger LOGGER = Logger.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Override
	public User save(User user) {
		// validate user
		LOGGER.info("user to save is:" + user);
		user = userRepository.save(user);
		LOGGER.info("user after saving:" + user);
		return user;
	}

	@Override
	public User findByLastName(String lastName) {
		if (!StringUtils.isEmpty(lastName)) {
			User savedUser = userRepository.findByLastName(lastName);
			LOGGER.info("found user by last name:" + savedUser);
			return savedUser;
		}
		return null;
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	@Override
	public Object deleteById(Long id) {
		userRepository.delete(id);	
		return null;
	}
	
	@Override
	public Page<User> findAll(Integer pageNumber, Integer pageSize) {
		Pageable pageable = new PageRequest(pageNumber, pageSize,Direction.ASC, "lastName");
		Page<User> findAll = userRepository.findAll(pageable);
		LOGGER.info("size of found page:"+findAll.getSize());
		return findAll;
	}

}
