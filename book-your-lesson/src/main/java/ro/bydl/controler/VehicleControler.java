package ro.bydl.controler;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import ro.bydl.domain.Schedule;
import ro.bydl.domain.Vehicle;
import ro.bydl.service.VehicleService;

@Controller
@RequestMapping("/vehicle")
public class VehicleControler {
	
	@Autowired
	private VehicleService vehicleService;	
			
			
			@RequestMapping("")
	public ModelAndView add(HttpSession session) throws Exception {
		ModelAndView result = new ModelAndView("vehicle");


		return result;
	}
			@RequestMapping("/list")
			public ModelAndView list(HttpSession session) throws Exception {
				ModelAndView result = new ModelAndView("vehicleList");
				result.addObject("vehicles",vehicleService.getAll());

				return result;
			}

			@RequestMapping(value="save")
			public ModelAndView save(@Valid @ModelAttribute("save") Vehicle vehicle, BindingResult bindingResult,
					HttpSession session) {
				ModelAndView modelAndView = new ModelAndView("/vehicleList");
				
				modelAndView.addObject("vehicles",vehicleService.getAll());
				vehicleService.save(vehicle);
				modelAndView.setView(new RedirectView("list"));
				

				return modelAndView;
			}
			@RequestMapping("/delete")
			public ModelAndView delete(@Valid @ModelAttribute("save") Vehicle vehicle, BindingResult bindingResult,
					HttpSession session) {
				ModelAndView modelAndView = new ModelAndView("/vehicleList");
				
				modelAndView.addObject("vehicles",vehicleService.getAll());
				vehicleService.delete(vehicle);
				modelAndView.setView(new RedirectView("list"));
				

				return modelAndView;
			}
			@RequestMapping("/edit")
			public ModelAndView edit(@Valid @ModelAttribute("save") Vehicle vehicle, BindingResult bindingResult,
					HttpSession session) {
				ModelAndView modelAndView = new ModelAndView("/vehicleList");
				
				modelAndView.addObject("vehicle",vehicle);
				vehicleService.edit(vehicle);
				modelAndView.setView(new RedirectView(""));
				

				return modelAndView;
			}
	
	
	

}
