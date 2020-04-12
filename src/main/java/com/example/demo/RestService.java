package com.example.demo;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestService {

	Logger logger = Logger.getLogger(RestService.class.getCanonicalName());

	@RequestMapping("/hello")
	public String hello() {
		logger.log(Level.INFO, "hello world");
		return "hello world";
	}
}
