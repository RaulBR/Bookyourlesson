package ro.bydl.controler;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AdminController {
	
	
	@RequestMapping(value = "/addVehicle")
	public ModelAndView addVehicle(HttpServletResponse request) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setView(new RedirectView("/vehicle"));
		return modelAndView;
	}
	
	@RequestMapping(value = "/addPerson")
	public ModelAndView seyHello(HttpServletResponse request) throws Exception {
		ModelAndView modelAndView = new ModelAndView("/person");
		return modelAndView;
	}
}
