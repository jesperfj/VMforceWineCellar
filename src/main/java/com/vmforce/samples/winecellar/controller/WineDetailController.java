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
public class WineDetailController {

	private static final Logger logger = LoggerFactory.getLogger(WineDetailController.class);

	@Autowired
	WineCellarService wineCellarService;
	
	@ModelAttribute("wine")
	public Wine initWine(@PathVariable String id) {
		Wine w = null;
		if(id.equals("new")) {
			logger.info("Initializing Wine model object for a new wine record");
			w = new Wine();
			w.setProducer(new Producer());
		} else {
			w = wineCellarService.findById(id);
			logger.debug("wineCellarService.findById returned instance with id "+w.getId()+" for id "+id);
		}
		return w;
	}
	
	@RequestMapping(value="/wine/{id}", method=RequestMethod.GET)
	public ModelAndView view(ModelAndView mv, @ModelAttribute Wine wine) {
		mv.addObject("wine", wine);
		mv.addObject("varietyOptions", Wine.Variety.values());
		mv.setViewName("view_wine");
		return mv;
	}

	@RequestMapping(value="/wine/{id}", method=RequestMethod.POST)
	public String update(ModelAndView mv, @ModelAttribute Wine wine) {

		// Because cascade create is not supported, we need a special service call for create vs. update.
		if(wine.getProducer().getId()==null) {
			wineCellarService.createNewWineAndProducer(wine);
		} else {
			wineCellarService.updateWine(wine);
		}
		return "redirect:/wine/"+wine.getId();
	}
	
}

