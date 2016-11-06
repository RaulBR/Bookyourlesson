package ro.bydl.controler;

import java.text.ParseException;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ro.bydl.domain.Teacher;
import ro.bydl.domain.User;
import ro.bydl.service.RegisterService;
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
	@Autowired
	RegisterService registerService;
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
	public ModelAndView saveTeacher(@Valid @ModelAttribute("user") User user, Teacher teacher,
			BindingResult bindingResult, HttpSession session) throws ParseException {
		ModelAndView modelAndView = new ModelAndView("studentForm");

		
		
				teacher.setBirthDay(teacherService.birthDay(teacher.getCnp()));
				user.setTeacherId((teacherService.addTeacher(teacher)));
				user.setPermision("teacher");
			
				try {
					registerService.addUser(user);
				} catch (ValidationException e) {
					modelAndView=new ModelAndView("studentForm");
					modelAndView.addObject("errors", e.getCauses());
					e.printStackTrace();
				}

	

		return modelAndView;
	}
	
	@RequestMapping("/list")
	public ModelAndView instructors(HttpSession session){
		ModelAndView modelAndView=new ModelAndView("teacherList");
		
		modelAndView.addObject("teachers",teacherService.getAll());
		
		return modelAndView;
		
	}
}
