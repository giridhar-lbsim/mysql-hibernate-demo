package com.giridhar.mysql.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
	  @RequestMapping(value = "/", method = RequestMethod.GET)
	  public String index() {
		  System.out.println("==============IndexController===========");
	    return "index";
	  }

}
