package ro.bydl.controler;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ro.bydl.service.TeacherService;
import ro.bydl.service.VehicleService;
@RequestMapping("")
@Controller
public class GeneralControler {
	@Autowired
	TeacherService teachersService;
	@Autowired
	VehicleService vehicleService;
	
	@RequestMapping("/instructors")
	public ModelAndView instructors(HttpSession session){
		ModelAndView modelAndView=new ModelAndView("instructors");
		
		modelAndView.addObject("teachers",teachersService.getAll());
		
		return modelAndView;
		
	}
	
	@RequestMapping("/cars")
	public ModelAndView vehicle(long teacherId,HttpSession session){
		ModelAndView modelAndView=new ModelAndView("vehicleList");
		
		modelAndView.addObject("vehicles",vehicleService.findByTeacherId(teacherId));
		modelAndView.addObject("teacher",teachersService.findById(teacherId));
		
		return modelAndView;
		
	}
	

}
