package com.eCommerce.RESTcontrollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MyRestController {
	
	@GetMapping("/test")
	public String Hello() {
		return "Hello World";
	}
}
