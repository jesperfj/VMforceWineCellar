package com.vmforce.samples.winecellar.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vmforce.samples.winecellar.model.Producer;
import com.vmforce.samples.winecellar.model.Wine;
import com.vmforce.samples.winecellar.service.WineCellarService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ProducerDetailController {

	private static final Logger logger = LoggerFactory.getLogger(ProducerDetailController.class);

	@Autowired
	WineCellarService wineCellarService;
	
	@ModelAttribute("producer")
	public Producer initProducer(@PathVariable String id) {
		Producer p = null;
		if(id.equals("new")) {
			p = new Producer();
		} else {
			p = wineCellarService.findProducerById(id);
		}
		return p;
	}
	
	@RequestMapping(value="/producer/{id}", method=RequestMethod.GET)
	public ModelAndView view(ModelAndView mv, @ModelAttribute Producer producer) {
		mv.addObject("producer", producer);
		mv.setViewName("view_producer");
		return mv;
	}

	@RequestMapping(value="/producer/{id}", method=RequestMethod.POST)
	public String update(ModelAndView mv, @ModelAttribute Producer producer) {
		producer = wineCellarService.updateProducer(producer);
		return "redirect:/producer/"+producer.getId();
	}
	
}

