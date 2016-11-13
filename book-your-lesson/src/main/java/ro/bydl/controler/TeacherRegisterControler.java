package ro.bydl.controler;

import java.text.ParseException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import ro.bydl.domain.Teacher;
import ro.bydl.domain.User;
import ro.bydl.service.RegisternService;
import ro.bydl.service.StudentService;
import ro.bydl.service.TeacherService;
import ro.bydl.service.errors.ValidationException;

@Controller
@RequestMapping("teacher")
public class TeacherRegisterControler {
	@Autowired
	TeacherService teacherService;
	@Autowired
	StudentService studentService;

	/**
	 * Returners a Model and view object for the "teacher" mapping.
	 * 
	 * @param session
	 * @return
	 * @throws Exception
	 */

	@RequestMapping("")
	public ModelAndView teacher(HttpSession session) throws Exception {
		ModelAndView result = new ModelAndView("teacherForm");
		return result;
	}

	/**
	 * Gets ,validates and sends to the DB the new teacher data.
	 * 
	 * @param user
	 * @param teacher
	 * @param pass2
	 * @param bindingResult
	 * @param session
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value = "/userSave", method = RequestMethod.POST)
	public ModelAndView saveTeacher(@Valid @ModelAttribute("user") Teacher teacher, BindingResult bindingResult,
			HttpSession session) throws ParseException {
		ModelAndView modelAndView = new ModelAndView("teahcerForm");

		boolean hasErros = false;

		if (!bindingResult.hasErrors()) {

			try {

				teacherService.addTeacher(teacher);

				modelAndView.setView(new RedirectView(""));

			} catch (ValidationException ex) {
				for (String err : ex.getCauses()) {
					bindingResult.addError(new ObjectError("teahcer", err));
				}
				hasErros = true;
			}

		} else {
			hasErros = true;
		}
		if (hasErros) {
			modelAndView = new ModelAndView("teahcerForm");

			modelAndView.addObject("teacher", teacher);
			// modelAndView.addObject("user", user);
			modelAndView.addObject("errors", bindingResult.getAllErrors());
		}

		return modelAndView;
	}

	@RequestMapping("/list")
	public ModelAndView instructors(HttpSession session) {
		ModelAndView result = new ModelAndView("teacherList");
		if (session.getAttribute("user") != null) {
			result.addObject("permision", ((User) session.getAttribute("user")).getPermision());

		}
		result.addObject("teachers", teacherService.getAll());
		return result;
	}

}
