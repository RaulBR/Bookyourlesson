package ro.bydl.controler;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import ro.bydl.domain.Schedule;
import ro.bydl.service.ScheduleService;


@Controller
@RequestMapping("/schedule")
//@SessionAttributes("week")
public class ScheduleControler {
	@Autowired
	private ScheduleService scheduleService;

	@RequestMapping("")
	public ModelAndView schedule(HttpSession session) throws Exception {
		ModelAndView result = new ModelAndView("sc");
		ScheduleService c=new ScheduleService();
		c.setWeek();
		result.addObject("cal", c);
		if(c.getAll().size()==0){
			for(int i=0;i<7;i++){
			c.getAll().add(new Schedule());
			}
		}
		result.addObject("scheduels",c.getAll());
		result.addObject("name",session.getAttribute("name"));
	
		
		return result;
	}

	@RequestMapping("/nextWeek")
	public ModelAndView nextWeek(int week) throws Exception {
		ScheduleService s=new ScheduleService();
		s.setWeek(week);
		ModelAndView result = new ModelAndView("sc2");
		result.addObject("cal",s);

		

		return result;
	}
	@RequestMapping("/previousWeek")
	public ModelAndView previous(int week) throws Exception {
		ScheduleService s=new ScheduleService();
		s.setPreviousWeek(week);
		ModelAndView result = new ModelAndView("sc2");
		result.addObject("cal",s);

		

		return result;
	}
//	@RequestMapping("/setDate")
//	public ModelAndView setdate(int starHour,int endHour,String date, int week) throws Exception {
//		ScheduleService s=new ScheduleService();
//		
//		s.setWeek(week-1);
//		ModelAndView result = new ModelAndView("sc2");
//		
//		result.addObject("cal",s);
//
//		
//
//		return result;
//	}


	@RequestMapping("saveDate")
	public ModelAndView save(
			@Valid @ModelAttribute("cal") Schedule schedule, 
			BindingResult bindingResult) {
		ModelAndView modelAndView=new ModelAndView("sc2"); ;
		
		
		
		

			scheduleService.setWeek(schedule.getWeek()-1);
			scheduleService.checkIfFree(schedule);
			scheduleService.save(schedule);
			modelAndView.addObject("cal",scheduleService);;
			
	


		return modelAndView;
	}
}
