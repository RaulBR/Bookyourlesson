package ro.bydl.controler;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import ro.bydl.domain.Car;
import ro.bydl.domain.Person;
import ro.bydl.domain.Schedule;
import ro.bydl.domain.Vehicle;

@Controller
@RequestMapping("")
@SessionAttributes("name")
public class LoginController {
	

	@RequestMapping("/add")
	public ModelAndView add(@Valid @ModelAttribute("person")Person p, 
			BindingResult bindingResult,HttpSession session){
		
		session.setAttribute("name", p.getName());
		ModelAndView modelandView =new ModelAndView("c");
		modelandView.addObject("person",p);
		
		return modelandView;
		
	}

}