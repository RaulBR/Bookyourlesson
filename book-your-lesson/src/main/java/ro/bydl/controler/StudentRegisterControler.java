package ro.bydl.controler;

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

import ro.bydl.domain.Student;
import ro.bydl.domain.User;
import ro.bydl.service.RegisternService;
import ro.bydl.service.StudentService;
import ro.bydl.service.TeacherService;
import ro.bydl.service.errors.ValidationException;

@Controller
@RequestMapping("student")
public class StudentRegisterControler {
	@Autowired
	TeacherService teacherService;
	@Autowired
	StudentService studentService;

	/**
	 * Returners a Model and view object for the "student" mapping.
	 * 
	 * @param session
	 * @return
	 * @throws Exception
	 */

	@RequestMapping("")
	public ModelAndView student(HttpSession session) throws Exception {
		ModelAndView result = new ModelAndView("studentForm");
		result.addObject("teachers", teacherService.getAll());
		return result;
	}

	/**
	 * Gets ,validates and sends to de DB the new students data.
	 * 
	 * @param user
	 * @param student
	 * @param pass2
	 * @param bindingResult
	 * @param session
	 */

	@RequestMapping(value = "/userSave", method = RequestMethod.POST)
	public ModelAndView save(@Valid @ModelAttribute("user")  Student student, BindingResult bindingResult,
			HttpSession session)  {
		ModelAndView modelAndView = new ModelAndView("");

		boolean hasErros = false;
		if (!bindingResult.hasErrors()) {
			try {
				
				studentService.addStudent(student);
				
				
				modelAndView.setView(new RedirectView(""));
				
			} catch (ValidationException ex) {
				
				for (String err : ex.getCauses()) {
					bindingResult.addError(new ObjectError("student", err));
				}
				hasErros = true;
			}
		} else {
			hasErros = true;
		}
		if (hasErros) {
			modelAndView = new ModelAndView("studentForm");
			modelAndView.addObject("teachers", teacherService.getAll());
			modelAndView.addObject("errors", bindingResult.getAllErrors());
		}

		return modelAndView;
	}

	
	@RequestMapping("/list")
	public ModelAndView studentList(HttpSession session) throws Exception {

		String permison = ((User) session.getAttribute("user")).getPermision();
		ModelAndView result = new ModelAndView("studentList");

		result.addObject("permision", permison);

		return result;
	}
}
