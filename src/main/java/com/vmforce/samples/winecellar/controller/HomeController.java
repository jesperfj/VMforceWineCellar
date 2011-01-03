package com.vmforce.samples.winecellar.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vmforce.samples.winecellar.service.WineCellarService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	WineCellarService wineCellarService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home() {
		return "home";
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value="/wine/", method=RequestMethod.GET)
	public ModelAndView wineList(ModelAndView mv) {
		mv.addObject("wines", wineCellarService.getWineList());
		mv.setViewName("wine_list");
		return mv;
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value="/producer/", method=RequestMethod.GET)
	public ModelAndView producerList(ModelAndView mv) {
		mv.addObject("producers", wineCellarService.getProducerList());
		mv.setViewName("producer_list");
		return mv;
	}
	
}

