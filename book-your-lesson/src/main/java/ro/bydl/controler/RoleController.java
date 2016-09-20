package ro.bydl.controler;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RoleController {

	@RequestMapping("/role")
	public ModelAndView selectRole(HttpServletResponse request) throws Exception {
		ModelAndView modelAndView = new ModelAndView("/beforeLogin");
		return modelAndView;
	}
	
}
