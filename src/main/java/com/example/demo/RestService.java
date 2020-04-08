package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestService {

	@RequestMapping("/hello")
	public String hello() {
		return "hello world8";
	}
}
