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
				modelAndView.setView(new RedirectView(""));
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
		Teacher teacher=(Teacher) session.getAttribute("teacherOBJ");
		result.addObject("teahcerOBJ",teacher);
		
		String permision = session.getAttribute("permision").toString();
		switch(permision) {
			case "teacher":
				Teacher teacherOBJ = (Teacher) session.getAttribute("teacheOBJ");
				result.addObject("teacherOBJ", teacherOBJ);
				break;
			case "admin":
				result.addObject("teachers", teacherService.getAll());
				break;
		}
		return result;
	}

	@RequestMapping("vehicle/list")
	public ModelAndView list(HttpSession session) throws Exception {
		ModelAndView result = new ModelAndView("vehicleList");
		if(session.getAttribute("permision")!=null){
		String permison = session.getAttribute("permision").toString();
		result.addObject("permision", permison);
		}
		
		
		result.addObject("vehicles", vehicleService.getAll());

		return result;
	}

	@RequestMapping("vehicle/save")
	public ModelAndView save(@Valid @ModelAttribute("save") Vehicle vehicle, BindingResult bindingResult,
			HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("/vehicle");

		if (vehicle.getId() == 0) {
			if(vehicleService.isVehicleOk(vehicle)==true){
				vehicleService.save(vehicle);
				modelAndView.setView(new RedirectView("list"));
			}else{
				modelAndView.addObject("message",new String("Chassies or licencePlate are already in the system"));
			}
		} else {
			// edit
			vehicleService.edit(vehicle);
		}
		
		modelAndView.setView(new RedirectView("list"));
		return modelAndView;
	}

	@RequestMapping("vehicle/delete")
	public ModelAndView delete(@Valid @ModelAttribute("save") Vehicle vehicle, BindingResult bindingResult,
			HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("/vehicleList");

		modelAndView.addObject("vehicles", vehicleService.getAll());
		vehicleService.delete(vehicle);
		modelAndView.setView(new RedirectView("list"));

		return modelAndView;
	}

	@RequestMapping("vehicle/edit")
	public ModelAndView edit(@Valid @ModelAttribute("edit") Vehicle vehicle, BindingResult bindingResult,
			HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("/vehicle");
		
		
		modelAndView.addObject("vehicle", vehicleService.findById(vehicle.getId()));
		String permision = session.getAttribute("permision").toString();
		switch(permision) {
			case "teacher":
				Teacher teacherOBJ = (Teacher) session.getAttribute("teacheOBJ");
				modelAndView.addObject("teacherOBJ", teacherOBJ);
				break;
			case "admin":
				modelAndView.addObject("teachers", teacherService.getAll());
				break;
		}
		

		return modelAndView;
	}
	@RequestMapping("student/list")
	public ModelAndView studentList(HttpSession session) throws Exception {
		String permison = session.getAttribute("permision").toString();
		ModelAndView result = new ModelAndView("studentList");
		Teacher teacher=(Teacher) session.getAttribute("teacherOBJ");
		System.out.println(teacher.getName());
		result.addObject("permision", permison);
	result.addObject("students", studentService.getByTeacherId( teacher.getId()));

		return result;
	}
}
