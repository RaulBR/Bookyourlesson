package ro.bydl.controler;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ro.bydl.service.TeacherService;
@RequestMapping("")
@Controller
public class GeneralControler {
	@Autowired
	TeacherService teachersService;
	
	
	@RequestMapping("/instructors")
	public ModelAndView instructors(HttpSession session){
		ModelAndView modelAndView=new ModelAndView("instructors");
		
		modelAndView.addObject("teachers",teachersService.getAll());
		return modelAndView;
		
	}
	
	

}
