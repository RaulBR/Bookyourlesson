package ro.bydl.controler;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import ro.bydl.domain.Schedule;
import ro.bydl.service.ScheduleService;
import ro.bydl.service.StudentService;
import ro.bydl.service.TeacherService;

@Controller
@RequestMapping("/schedule")

//@SessionAttributes("teacherId")
@Scope("session")
public class ScheduleControler {
	
	@Autowired
	private ScheduleService scheduleService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private TeacherService teacherService;

	


	@RequestMapping("")
	public ModelAndView schedule(HttpSession session) throws Exception {
		
		
		
		
//		session.setAttribute("instructiorName", teacherService.getByid(
//				Integer.parseInt(session.getAttribute("teacherId").toString())).getName());
		ModelAndView result = new ModelAndView("scheduleTeacher");
		result.addObject("teacher",teacherService.getByid(1));
		
		
			result.addObject("cal", scheduleService);
			result.addObject("students",studentService.getAll());
			result.addObject("weekDay", scheduleService.getAll());
			result.addObject("schedules", scheduleService.searchByTeacherId(2));
			result.addObject("progress", scheduleService.countSchedules());
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

	@RequestMapping(value = "saveDate", method = RequestMethod.POST)
	public ModelAndView save(@Valid @ModelAttribute("schedules") Schedule schedule, BindingResult bindingResult,
			HttpSession sessio) {
		ModelAndView modelAndView = new ModelAndView("");
		scheduleService.setWeek(schedule.getWeek() - 1);

		scheduleService.save(schedule);

		modelAndView.setView(new RedirectView(""));

		return modelAndView;
	}

	@RequestMapping(value = "removeDate", method = RequestMethod.POST)
	public ModelAndView dellete(@Valid @ModelAttribute("cal") Schedule schedule, BindingResult bindingResult,
			HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		scheduleService.setWeek(schedule.getWeek() - 1);
		
		scheduleService.delete(schedule);
		modelAndView.setView(new RedirectView(""));

		return modelAndView;

	}
	@RequestMapping(value = "edit")
	public ModelAndView edit(@Valid @ModelAttribute("cal") Schedule schedule, BindingResult bindingResult,
			HttpSession sessio) {
		ModelAndView modelAndView = new ModelAndView();
		scheduleService.setWeek(schedule.getWeek() - 1);

		scheduleService.edit(schedule);
		modelAndView.setView(new RedirectView(""));

		return modelAndView;

	}
}
