package ro.bydl.controler;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ro.bydl.domain.Student;
import ro.bydl.domain.Teacher;
import ro.bydl.domain.User;
import ro.bydl.service.RegisterService;
import ro.bydl.service.StudentService;
import ro.bydl.service.TeacherService;

@Controller
@RequestMapping("/register")
public class RegisterControler {
	@Autowired
	StudentService studentService;
	@Autowired
	TeacherService teacherService;
	@Autowired
	RegisterService registerService;

	// StudentService studentService;

	@RequestMapping("")
	public ModelAndView register(HttpSession session) throws Exception {
		ModelAndView result = new ModelAndView("");

		return result;
	}

	@RequestMapping("student")
	public ModelAndView student(HttpSession session) throws Exception {
		ModelAndView result = new ModelAndView("studentForm");
		return result;
	}

	@RequestMapping("teacher")
	public ModelAndView teacher(HttpSession session) throws Exception {
		ModelAndView result = new ModelAndView("teacherForm");
		return result;
	}

	@RequestMapping(value = "/student/userSave", method = RequestMethod.POST)
	public ModelAndView save(@Valid @ModelAttribute("user") User user, Student student, String pass2,
			BindingResult bindingResult, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("studentForm");
		
		
		registerService.addUser(user);
		user.setStudentId(studentService.addStudent(student).getId());
		student.setBirthDay(studentService.byrthDay(student.getCnp()));
	;
		if (registerService.checkUserUnique(user) == true) {

			if (registerService.checkPass(user.getPass(), pass2) == true) {
				if (user.getTeacherId() == 0) {
					// user.setTeacherId(teacherId);
				}

			}
			
		}

		return modelAndView;
	}
	@RequestMapping(value = "/teacher/userSave", method = RequestMethod.POST)
	public ModelAndView saveTeacher(@Valid @ModelAttribute("user") User user, Teacher teacher, String pass2,
			BindingResult bindingResult, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("studentForm");
		
		
		registerService.addUser(user);
		user.setStudentId(teacherService.addTeacher(teacher).getId());
		teacher.setBirthDay(teacherService.byrthDay(teacher.getCnp()));
	;
		if (registerService.checkUserUnique(user) == true) {

			if (registerService.checkPass(user.getPass(), pass2) == true) {
				if (user.getTeacherId() == 0) {
					// user.setTeacherId(teacherId);
				}

			}
			
		}

		return modelAndView;
	}
}
