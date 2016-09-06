package ro.bydl.controler;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import ro.bydl.domain.Schedule;
import ro.bydl.service.ScheduleService;


@Controller
@RequestMapping("/schedule")
public class ScheduleControler {
	@Autowired
	private ScheduleService scheduleService;

	@RequestMapping("")
	public ModelAndView schedule() throws Exception {
		ModelAndView result = new ModelAndView("sc2");
		ScheduleService c=new ScheduleService();
		c.setWeek();
		result.addObject("cal", c);
	

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
	@RequestMapping("/setDate")
	public ModelAndView setdate(int starHour,int endHour,String date, int week) throws Exception {
		ScheduleService s=new ScheduleService();
		
		s.setWeek(week-1);
		ModelAndView result = new ModelAndView("sc2");
		
		result.addObject("cal",s);

		

		return result;
	}


	@RequestMapping("saveDate")
	public ModelAndView save(
			@Valid @ModelAttribute("cal") Schedule schedule, 
			BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("sc2");
		
		boolean hasErros = false;
		
		if (!bindingResult.hasErrors()) {
			scheduleService.setWeek(schedule.getWeek());
			scheduleService.checkIfFree(schedule);
			scheduleService.save(schedule);
			modelAndView.addObject("cal",scheduleService);;
			modelAndView = new ModelAndView();
			modelAndView.setView(new RedirectView(""));
		} else {
			hasErros = true;
		}

		if (hasErros) {
			modelAndView = new ModelAndView("employee/add");
			modelAndView.addObject("employee", schedule);
			modelAndView.addObject("errors", bindingResult.getAllErrors());
		}

		return modelAndView;
	}
}
