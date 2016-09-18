package ro.bydl.controler;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import ro.bydl.domain.Vehicle;
import ro.bydl.service.VehicleService;

@Controller
@RequestMapping("/vehicles")

public class VehicleControler {
	
	private VehicleService vehicleService;	
			
			
			@RequestMapping("")
	public ModelAndView add(HttpSession session) throws Exception {
		ModelAndView result = new ModelAndView("vehicle");


		return result;
	}
			@RequestMapping("list")
			public ModelAndView list(HttpSession session) throws Exception {
				ModelAndView result = new ModelAndView("vehicle");
				result.addObject("vehicles",vehicleService.getAll());

				return result;
			}

			@RequestMapping(value = "save")
			public ModelAndView save(@Valid @ModelAttribute("vehicle") Vehicle vehicle, BindingResult bindingResult,
					HttpSession session) {
				ModelAndView modelAndView = new ModelAndView("");
			

				vehicleService.save(vehicle);
				modelAndView.setView(new RedirectView("/list"));
				

				return modelAndView;
			}
	
	

}
