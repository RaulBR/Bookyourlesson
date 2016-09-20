package ro.bydl.controler;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import ro.bydl.service.LoginService;

@Controller
@RequestMapping("")
public class LoginController {

	@Autowired
	LoginService loginService;

	@RequestMapping("")
	public ModelAndView seyHello(HttpServletResponse request) throws Exception {
		ModelAndView modelAndView = new ModelAndView("/login");
		return modelAndView;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView seyHello(@RequestParam String name, @RequestParam String password, HttpServletResponse request) throws Exception {
		ModelAndView modelAndView = new ModelAndView("/login");
		if (loginService.validateAdmin(name, password) == true) {
			modelAndView = new ModelAndView("admin");
		}
		else if (loginService.validateUser(name, password) == true) {
			modelAndView = new ModelAndView("person");
		}
		return modelAndView;
	}
}
