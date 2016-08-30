package ro.bydl.controler;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ro.bydl.domain.Person;

@Controller
@RequestMapping("/friend")
public class FriendshipControler {

	@RequestMapping("hello")
	public ModelAndView seyHello(Person p, HttpServletResponse res) throws Exception {
		ModelAndView result= new ModelAndView("hello");
		
	//	res.getWriter().write("Hello my ftiend :" + " " + p.getFirstName() + " " + p.getLastName());
		//result.addObject("person",p);
		return result;
	}

}
