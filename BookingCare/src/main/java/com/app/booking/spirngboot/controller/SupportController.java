package com.app.booking.spirngboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()

public class SupportController {
	
	@GetMapping("/testController")
	public String test()
	{
		return "Test";
	}
}
