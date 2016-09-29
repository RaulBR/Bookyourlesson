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
import org.springframework.web.servlet.view.RedirectView;

import ro.bydl.domain.Student;
import ro.bydl.domain.Teacher;
import ro.bydl.domain.User;
import ro.bydl.domain.Vehicle;
import ro.bydl.service.RegisterService;
import ro.bydl.service.StudentService;
import ro.bydl.service.TeacherService;
import ro.bydl.service.VehicleService;

/**
 * This class is the model and view controler for the registretion forms of the
 * aplication
 * 
 * @author Raul
 *
 */
@Controller
@RequestMapping("/register")
public class RegisterControler {
	@Autowired
	StudentService studentService;
	@Autowired
	TeacherService teacherService;
	@Autowired
	RegisterService registerService;
	@Autowired
	VehicleService vehicleService;

	/**
	 * Returners a Model and view object for the "student" mapping.
	 * 
	 * @param session
	 * @return
	 * @throws Exception
	 */

	@RequestMapping("student")
	public ModelAndView student(HttpSession session) throws Exception {
		ModelAndView result = new ModelAndView("studentForm");
		result.addObject("teachers", teacherService.getAll());
		return result;
	}

	/**
	 * Returners a Model and view object for the "teacher" mapping.
	 * 
	 * @param session
	 * @return
	 * @throws Exception
	 */

	@RequestMapping("teacher")
	public ModelAndView teacher(HttpSession session) throws Exception {
		ModelAndView result = new ModelAndView("teacherForm");
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
	 * @return
	 */
	@RequestMapping(value = "/student/userSave", method = RequestMethod.POST)
	public ModelAndView save(@Valid @ModelAttribute("user2") User user, Student student, String pass2,
			BindingResult bindingResult, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("studentForm");
		
		if (registerService.checkUserUnique(user) == true) {

			if (registerService.checkPass(user.getPass(), pass2) == true) {

				student.setBirthDay(studentService.byrthDay(student.getCnp()));
				user.setStudentId(studentService.addStudent(student).getId());
				user.setPermision("student");
				user.setTeacherId(0);
				registerService.addUser(user);

			} else {
				modelAndView.addObject("error2", new String("passwoard dont mach"));
			}

		} else {
			modelAndView.addObject("error", new String("id exists"));

		}

		return modelAndView;
	}

	/**
	 * Gets ,validates and sends to de DB the new teacher data.
	 * 
	 * @param user
	 * @param teacher
	 * @param pass2
	 * @param bindingResult
	 * @param session
	 * @return
	 */
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
			
				registerService.addUser(user);

			} else {
				modelAndView.addObject("error2", new String("passwoard dont mach"));
			}

		} else {
			modelAndView.addObject("error", new String("id exists"));

		}

		return modelAndView;
	}

	@RequestMapping("vehicle")
	public ModelAndView add(HttpSession session) throws Exception {
		ModelAndView result = new ModelAndView("vehicle");

		return result;
	}

	@RequestMapping("vehicle/list")
	public ModelAndView list(HttpSession session) throws Exception {
		ModelAndView result = new ModelAndView("vehicleList");
		result.addObject("vehicles", vehicleService.getAll());

		return result;
	}

	@RequestMapping("vehicle/save")
	public ModelAndView save(@Valid @ModelAttribute("save") Vehicle vehicle, BindingResult bindingResult,
			HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("/vehicleList");

		modelAndView.addObject("vehicles", vehicleService.getAll());
		vehicleService.save(vehicle);
		modelAndView.setView(new RedirectView("list"));

		return modelAndView;
	}

	@RequestMapping("/delete")
	public ModelAndView delete(@Valid @ModelAttribute("save") Vehicle vehicle, BindingResult bindingResult,
			HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("/vehicleList");

		modelAndView.addObject("vehicles", vehicleService.getAll());
		vehicleService.delete(vehicle);
		modelAndView.setView(new RedirectView("list"));

		return modelAndView;
	}

	@RequestMapping("/edit")
	public ModelAndView edit(@Valid @ModelAttribute("save") Vehicle vehicle, BindingResult bindingResult,
			HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("/vehicleList");
		
		modelAndView.addObject("vehicle", vehicle);
		vehicleService.edit(vehicle);
		modelAndView.setView(new RedirectView(""));

		return modelAndView;
	}
}
