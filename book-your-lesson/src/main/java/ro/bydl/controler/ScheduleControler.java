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
import org.springframework.web.servlet.view.RedirectView;

import ro.bydl.domain.Schedule;
import ro.bydl.service.ScheduleService;

@Controller
@RequestMapping("/schedule")
@SessionAttributes("week")
// @SessionAttributes("week")
public class ScheduleControler {
	@Autowired
	private ScheduleService scheduleService;
private int cout=0;
	@RequestMapping("")
	public ModelAndView schedule(HttpSession session) throws Exception {
		ModelAndView result = new ModelAndView("sc");
		
//		if(cout==0){
//		Schedule schedule=new Schedule();
//		
//		schedule.setDate("05.09.2016");
//		schedule.setStartHour("8");
//		schedule.setFree(false);
//		Schedule schedule1=new Schedule();
//		schedule1.setDate("05.09.2016");
//		schedule1.setStartHour("10");
//		schedule1.setFree(false);
//		Schedule schedule2=new Schedule();
//		schedule2.setDate("06.09.2016");
//		schedule2.setStartHour("12");
//		schedule2.setFree(false);
//		
//		scheduleService.save(schedule);
//		scheduleService.save(schedule1);
//		scheduleService.save(schedule2);
//		cout++;
//		}
		result.addObject("cal", scheduleService);

		result.addObject("schedules", scheduleService.getAll());
		result.addObject("name", session.getAttribute("name"));

		return result;
	}

	@RequestMapping("/nextWeek")
	public ModelAndView nextWeek(int week) throws Exception {

		scheduleService.setWeek(week);
		ModelAndView result = new ModelAndView();
		result.addObject("cal", scheduleService);
		result.setView(new RedirectView(""));
		return result;
	}

	@RequestMapping("/thisWeek")
	public ModelAndView thisWeek() throws Exception {

		scheduleService.setThisWeek();
		ModelAndView result = new ModelAndView("");
		result.addObject("cal", scheduleService);
		result.setView(new RedirectView(""));

		return result;
	}

	@RequestMapping("/previousWeek")
	public ModelAndView previous(int week) throws Exception {
		scheduleService.setPreviousWeek(week);
		ModelAndView result = new ModelAndView();
		result.addObject("cal", scheduleService);
		result.setView(new RedirectView(""));
		return result;
	}
	// @RequestMapping("/setDate")
	// public ModelAndView setdate(int starHour,int endHour,String date, int
	// week) throws Exception {
	// ScheduleService s=new ScheduleService();
	//
	// s.setWeek(week-1);
	// ModelAndView result = new ModelAndView("sc");
	//
	// result.addObject("cal",s);
	//
	//
	//
	// return result;
	// }

	@RequestMapping("saveDate")
	public ModelAndView save(@Valid @ModelAttribute("cal") Schedule schedule, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		scheduleService.setWeek(schedule.getWeek() - 1);
		scheduleService.checkIfFree(schedule);
		scheduleService.save(schedule);
		modelAndView.setView(new RedirectView(""));
		// modelAndView.addObject("cal",scheduleService);;
		return modelAndView;
	}
}
