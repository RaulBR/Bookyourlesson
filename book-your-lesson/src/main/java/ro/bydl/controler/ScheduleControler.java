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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import ro.bydl.domain.Schedule;
import ro.bydl.domain.Student;
import ro.bydl.domain.Teacher;
import ro.bydl.domain.User;
import ro.bydl.service.ScheduleService;
import ro.bydl.service.StudentService;
import ro.bydl.service.TeacherService;

/**
 * this class handles the MVC for the schedule. It retrives schedules based on
 * permission and specific users.
 * 
 * @author Raul Ranete
 *
 */
@Controller
@RequestMapping("/schedule")

@SessionAttributes({ "week" })

public class ScheduleControler {

	@Autowired
	private ScheduleService scheduleService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private TeacherService teacherService;

	/**
	 * returns a MV based on permission.
	 * 
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("")
	public ModelAndView schedule(HttpSession session) {
		if (session.getAttribute("user") != null) {
			User user = (User) session.getAttribute("user");
			String permison = user.getPermision();

			int week = Integer.parseInt(session.getAttribute("weeks").toString());
			ModelAndView result = new ModelAndView();

			if (permison.equals("teacher")) {
				Teacher teacher = teacherService.findById(user.getTeacherId());

				result = new ModelAndView("scheduleTeacher");
				result.addObject("week", week);
				result.addObject("teacherOBJ", teacher);
				result.addObject("students", studentService.getByTeacherId(teacher.getId()));
				result.addObject("schedules", scheduleService.searchByTeacherId(teacher.getId()));
			}

			if (permison.equals("student")) {

				Student currentStudent = studentService.findById(user.getStudentId());

				result = new ModelAndView("scheduleStudent");
				result.addObject("studentOBJ", currentStudent);

				result.addObject("schedules",

						scheduleService.searchByStudentId(currentStudent.getId(), currentStudent.getTeacherId()));

				result.addObject("instructor", teacherService.findById(currentStudent.getTeacherId()));

				result.addObject("progress", scheduleService.pending(currentStudent.getId()));
				result.addObject("absent", scheduleService.absent(currentStudent.getId()));
				result.addObject("done", scheduleService.done(currentStudent.getId()));
			}
			if (permison.equals("admin")) {
				result = new ModelAndView("admin");

			}
			result.addObject("week", week);
			result.addObject("weekDays", scheduleService.getDays(week));
			return result;
		}

		return new ModelAndView("login");
	}

	/**
	 * Sets the next week number.
	 * 
	 * @param session
	 * @param week
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/nextWeek")
	public ModelAndView nextWeek(HttpSession session, int week) throws Exception {

		session.removeAttribute("weeks");
		session.setAttribute("weeks", week + 1);

		ModelAndView result = new ModelAndView();

		result.setView(new RedirectView(""));
		return result;
	}

	/**
	 * sets the wee to this week
	 * 
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/thisWeek")
	public ModelAndView thisWeek(HttpSession session) throws Exception {

		ModelAndView result = new ModelAndView("");
		session.removeAttribute("weeks");
		session.setAttribute("weeks", Calendar.getInstance().get(Calendar.WEEK_OF_YEAR));
		result.setView(new RedirectView(""));

		return result;
	}

	/**
	 * seets to previous week
	 * 
	 * @param session
	 * @param week
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/previousWeek")
	public ModelAndView previous(HttpSession session, int week) throws Exception {

		ModelAndView result = new ModelAndView();
		session.removeAttribute("weeks");
		session.setAttribute("weeks", week - 1);
		result.setView(new RedirectView(""));
		return result;
	}

	/**
	 * Retrieves a Schedule from the client and saves it to the DB
	 * 
	 * @param schedule
	 * @param bindingResult
	 * @param sessio
	 * @return
	 */
	@RequestMapping(value = "saveDate", method = RequestMethod.POST)
	public ModelAndView save(@Valid @ModelAttribute("schedules") Schedule schedule, BindingResult bindingResult,
			HttpSession sessio) {
		ModelAndView modelAndView = new ModelAndView("");

		scheduleService.save(schedule);

		modelAndView.setView(new RedirectView(""));

		return modelAndView;
	}

	/**
	 * Deletes schedule form DB.
	 * 
	 * @param schedule
	 * @param bindingResult
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "removeDate", method = RequestMethod.POST)
	public ModelAndView dellete(@Valid @ModelAttribute("cal") Schedule schedule, BindingResult bindingResult,
			HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		scheduleService.delete(schedule);
		modelAndView.setView(new RedirectView(""));

		return modelAndView;

	}

	/**
	 * Edits a retrieved Schedule
	 * 
	 * @param schedule
	 * @param bindingResult
	 * @param sessio
	 * @return
	 */
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public ModelAndView edit(@Valid @ModelAttribute("cal") Schedule schedule, BindingResult bindingResult,
			HttpSession sessio) {
		ModelAndView modelAndView = new ModelAndView();

		scheduleService.update(schedule);
		modelAndView.setView(new RedirectView(""));

		return modelAndView;

	}

	@RequestMapping(value = "saveDated", method = RequestMethod.GET)
	public @ResponseBody long search(HttpSession session, Schedule value) {

		User user = (User) session.getAttribute("user");
		String permison = user.getPermision();

		if (permison.equals("teacher")) {
			long d=scheduleService.save(value);
			System.out.println(d);
			return d;
			
		} else if (permison.equals("student")) {

			if (scheduleService.dateHasPased(value)) {
				return -1;
			} else {

				return scheduleService.save(value);
			}
		}
		return 0;

	}

	@RequestMapping(value = "remove", method = RequestMethod.GET)
	public @ResponseBody long remove(HttpSession sesion, Schedule value) {
		long v = scheduleService.delete(value);

		return v;

	}

	@RequestMapping(value = "edit-schedule", method = RequestMethod.GET)
	public @ResponseBody Schedule editOnTheFly(@Valid @ModelAttribute("cal") Schedule schedule,
			BindingResult bindingResult, HttpSession sessio) {

		Schedule s = scheduleService.update(schedule);
			
		return scheduleService.update(s);

	}

}
