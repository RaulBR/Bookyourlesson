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


	@RequestMapping("")
	public ModelAndView register(HttpSession session) throws Exception {
		ModelAndView result = new ModelAndView("");

		return result;
	}

	@RequestMapping("student")
	public ModelAndView student(HttpSession session) throws Exception {
		ModelAndView result = new ModelAndView("studentForm");
		result.addObject("teachers",teacherService.getAll());
		return result;
	}

	@RequestMapping("teacher")
	public ModelAndView teacher(HttpSession session) throws Exception {
		ModelAndView result = new ModelAndView("teacherForm");
		return result;
	}

	@RequestMapping(value = "/student/userSave" , method = RequestMethod.POST)
	public ModelAndView save(@Valid @ModelAttribute("user2") User user, Student student, String pass2,
			BindingResult bindingResult, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("studentForm");
		System.out.println("before");
		System.out.println(registerService.checkUserUnique(user));
		System.out.println(registerService.checkPass(user.getPass(), pass2));
		
		if (registerService.checkUserUnique(user) == true) {
			
			if (registerService.checkPass(user.getPass(), pass2) == true) {
				
					student.setBirthDay(studentService.byrthDay(student.getCnp()));
					user.setStudentId(studentService.addStudent(student).getId());
					user.setPermision("student");
					user.setTeacherId(0);
					registerService.addUser(user);
				

			}else {
				modelAndView.addObject("error2",new String("passwoard dont mach"));
			}
			
		} else{
			modelAndView.addObject("error",new String("id exists"));
		
		}
		
		
		
		return modelAndView;
	}
	@RequestMapping(value = "/teacher/userSave", method = RequestMethod.POST)
	public ModelAndView saveTeacher(@Valid @ModelAttribute("user") User user, Teacher teacher, String pass2,
			BindingResult bindingResult, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("studentForm");
		
		
	
		
	;
		if (registerService.checkUserUnique(user) == true) {

			if (registerService.checkPass(user.getPass(), pass2) == true) {
				teacher.setBirthDay(teacherService.byrthDay(teacher.getCnp()));
				user.setTeacherId((teacherService.addTeacher(teacher).getId()));
				user.setPermision("teacher");
				System.out.println(user.getPermision());
				System.out.println(user.getTeacherId());
				registerService.addUser(user);

			}else {
				modelAndView.addObject("error2",new String("passwoard dont mach"));
			}
			
		}else{
			modelAndView.addObject("error",new String("id exists"));
		
		}

		return modelAndView;
	}
}
