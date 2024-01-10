package com.nagarro.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nagarro.model.TShirt;
import com.nagarro.services.TShirtService;
import com.nagarro.services.UserServices;




@Controller
public class TShirtController {


	
	@RequestMapping("/search")
	public ModelAndView add(@RequestParam("colour") String colour, @RequestParam("size") String size,
			@RequestParam("gender") String gender, @RequestParam("output-preference") String outputPreference) {
		
		TShirtService tShirtService = new TShirtService();
		
		List<TShirt> tShirts = tShirtService.search(colour, size, gender, outputPreference);
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("Product/display.jsp");
		modelAndView.addObject("tshirths",tShirts);
		
		System.out.println(tShirts.size());
		

		return modelAndView;
	}
}
