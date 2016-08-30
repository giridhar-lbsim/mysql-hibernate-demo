package com.giridhar.mysql.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.giridhar.mysql.domain.User;
import com.giridhar.mysql.service.UserService;
import com.giridhar.mysql.util.RestResponse;
import com.giridhar.mysql.util.RestUtils;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	private static final Logger LOGGER = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<RestResponse<User>> save(@RequestBody User user) {
		LOGGER.info("user to save is : " + user);
		return RestUtils.successResponse(userService.save(user));
	}

	@RequestMapping(value = "/find-by-last-name/{lastName}", method = RequestMethod.GET)
	public ResponseEntity<RestResponse<User>> findByLastName(@PathVariable String lastName) {
		LOGGER.info("last name to find is : " + lastName);
		return RestUtils.successResponse(userService.findByLastName(lastName));
	}

	@RequestMapping(value = "/find-all", method = RequestMethod.GET)
	public ResponseEntity<RestResponse<List<User>>> findAllUser() {
		return RestUtils.successResponse(userService.findAll());
	}

	@RequestMapping(value = "/find-all-paginated/{pageNumber}/{pageSize}", method = RequestMethod.GET)
	public ResponseEntity<RestResponse<Page<User>>> findAllByPaginated(@PathVariable Integer pageNumber,
			@PathVariable Integer pageSize) {
		return RestUtils.successResponse(userService.findAll(pageNumber, pageSize));
	}

	@RequestMapping(value = "/delete-by-id/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<RestResponse<Object>> deleteUserById(@PathVariable Long id) {
		return RestUtils.successResponse(userService.deleteById(id));

	}

}
