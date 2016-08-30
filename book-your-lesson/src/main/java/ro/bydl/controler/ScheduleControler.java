package ro.bydl.controler;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ro.bydl.domain.Schedule;

@Controller
@RequestMapping("/schedule")
public class ScheduleControler {

	@RequestMapping("sc")
	public ModelAndView schedule(Schedule s, HttpServletResponse res) throws Exception {
		ModelAndView result= new ModelAndView("sc");
		
	//	res.getWriter().write("Hello my ftiend :" + " " + p.getFirstName() + " " + p.getLastName());
		//result.addObject("person",s);
		return result;
	}

}
