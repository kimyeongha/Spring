package org.zerock.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zerock.domain.SampleDTO;

@Controller

public class TestController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/a", method = { RequestMethod.GET, RequestMethod.POST })

	public String a() {
		return "TestA";
	}
	@GetMapping("Testb")
	public String b(SampleDTO dto,@ModelAttribute("name") String name,@ModelAttribute("age") int age) {
		  
		return "TestB";
	}

}
