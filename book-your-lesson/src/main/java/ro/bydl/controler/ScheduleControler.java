package ro.bydl.controler;

import java.util.Calendar;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.fasterxml.jackson.databind.ser.std.CalendarSerializer;

import ro.bydl.domain.Schedule;
import ro.bydl.domain.Student;
import ro.bydl.service.CalendarService;
import ro.bydl.service.ScheduleService;
import ro.bydl.service.StudentService;
import ro.bydl.service.TeacherService;

@Controller
@RequestMapping("/schedule")
@SessionAttributes({ "studentLogedId", "permision", "theacherLogId","weeks"})
// @SessionAttributes("teacherId")

public class ScheduleControler {

	@Autowired
	private ScheduleService scheduleService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private CalendarService calendarService;

	@RequestMapping("")
	public ModelAndView schedule(HttpSession session) throws Exception {
		String permison = session.getAttribute("permision").toString();
		System.err.println(permison);
		
		
		int week = Integer.parseInt(session.getAttribute("weeks").toString());
		ModelAndView result = new ModelAndView();
		
if(permison.equals("teacher")){
	
	int teacherId=Integer.parseInt(session.getAttribute("theacherLogId").toString());
	System.err.println("teacher id "+ teacherId);
		result = new ModelAndView("scheduleTeacher");
		
		result.addObject("week", week);
		result.addObject("teacherOBJ",session.getAttribute("teacherOBJ"));
		result.addObject("teacherId", session.getAttribute("theacherLogId"));
		result.addObject("students",studentService.getByTeacherId(teacherId));
		result.addObject("schedules",
				scheduleService.searchByTeacherId(teacherId));
		}

if(permison.equals("student")){
	
	int iD=Integer.parseInt(session.getAttribute("studentLogedId").toString());
			Student currentStudent = (Student) session.getAttribute("studentOBJ");
			result = new ModelAndView("scheduleStudent");
			result.addObject("studentOBJ",session.getAttribute("studentOBJ"));
			result.addObject("studentId", session.getAttribute("studentLogedId"));
			result.addObject("schedules",scheduleService.searchByStudentId(iD, currentStudent.getTeacherId()));
			result.addObject("instructor",teacherService.findById(currentStudent.getTeacherId()));
			result.addObject("progress",scheduleService.pending(iD));
			
			result.addObject("absent",scheduleService.absent(iD));
			result.addObject("done",scheduleService.done(iD));
			}


				result.addObject("week", week);
				result.addObject("weekDays", calendarService.getDays(week));
		return result;
	}

	
	
	
	@RequestMapping("/nextWeek")
	public ModelAndView nextWeek(HttpSession session,int week) throws Exception {
	
		session.removeAttribute("weeks");
		session.setAttribute("weeks", week+1);
		
		ModelAndView result = new ModelAndView();

		result.setView(new RedirectView(""));
		return result;
	}

	@RequestMapping("/thisWeek")
	public ModelAndView thisWeek(HttpSession session) throws Exception {

		ModelAndView result = new ModelAndView("");
		session.removeAttribute("weeks");
		session.setAttribute("weeks",Calendar.getInstance().get(Calendar.WEEK_OF_YEAR));
		result.setView(new RedirectView(""));

		return result;
	}

	@RequestMapping("/previousWeek")
	public ModelAndView previous(HttpSession session,int week) throws Exception {

		ModelAndView result = new ModelAndView();
		session.removeAttribute("weeks");
		session.setAttribute("weeks", week-1);
		result.setView(new RedirectView(""));
		return result;
	}

	@RequestMapping(value = "saveDate", method = RequestMethod.POST)
	public ModelAndView save(@Valid @ModelAttribute("schedules") Schedule schedule, BindingResult bindingResult,
			HttpSession sessio) {
		ModelAndView modelAndView = new ModelAndView("");
		System.out.println(schedule.getStudentId());
	System.out.println(schedule.getDate());
		scheduleService.save(schedule);

		modelAndView.setView(new RedirectView(""));

		return modelAndView;
	}

	@RequestMapping(value = "removeDate", method = RequestMethod.POST)
	public ModelAndView dellete(@Valid @ModelAttribute("cal") Schedule schedule, BindingResult bindingResult,
			HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();

		scheduleService.delete(schedule);
		modelAndView.setView(new RedirectView(""));

		return modelAndView;

	}

	@RequestMapping(value = "edit")
	public ModelAndView edit(@Valid @ModelAttribute("cal") Schedule schedule, BindingResult bindingResult,
			HttpSession sessio) {
		ModelAndView modelAndView = new ModelAndView();

		scheduleService.edit(schedule);
		modelAndView.setView(new RedirectView(""));

		return modelAndView;

	}
}
