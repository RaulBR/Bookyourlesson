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
import ro.bydl.domain.Teacher;
import ro.bydl.domain.User;
import ro.bydl.exceptions.ValidationException;
import ro.bydl.service.StudentService;
import ro.bydl.service.TeacherService;
import ro.bydl.service.VehicleService;

@Controller
@RequestMapping("student")
public class StudentRegisterControler {
	@Autowired
	TeacherService teacherService;
	@Autowired
	StudentService studentService;
	@Autowired
	VehicleService vehicleService;

	/**
	 * Returners a Model and view object for the "student" mapping.
	 * 
	 * @param session
	 * @return
	 * @throws Exception
	 */

	@RequestMapping("")
	public ModelAndView student(HttpSession session,String vehicle, Long id) {
		ModelAndView result = new ModelAndView("studentForm");
		result.addObject("teachers", teacherService.getAll());
		
		if(vehicle.equals("vehicle")){
			
			result.addObject("teacherFromList",teacherService.findById(vehicleService.findById(id).getTeacherId()));
		} else if(id!=null){
			result.addObject("teacherFromList",teacherService.findById(id));
			}
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
	public ModelAndView save(@Valid @ModelAttribute("user") Student student, BindingResult bindingResult,
			HttpSession session) {
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
			modelAndView.addObject("student", student);
			modelAndView.addObject("errors", bindingResult.getAllErrors());
		}

		return modelAndView;
	}

	@RequestMapping("/list")
	public ModelAndView studentList(HttpSession session, Long teacherId) {
		String permison = ((User) session.getAttribute("user")).getPermision();
		ModelAndView result = new ModelAndView("studentList");
		result.addObject("permision", permison);
		if (teacherId !=null) {
			result.addObject("students", studentService.getByTeacherId(teacherId));

		} else {

			result.addObject("students", studentService.getAll());

		}
		return result;
	}

	@RequestMapping("/delete")
	public ModelAndView delete(@Valid @ModelAttribute("save") Student student, BindingResult bindingResult,
			HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("/studentList");

		modelAndView.addObject("students", studentService.getAll());
		studentService.delete(student);
		modelAndView.setView(new RedirectView("list"));

		return modelAndView;
	}

	@RequestMapping("/edit")
	public ModelAndView edit(@Valid @ModelAttribute("edit") Student student, BindingResult bindingResult,
			HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("/student");

		modelAndView.addObject("student", studentService.findById(student.getId()));
		String permision = ((User) session.getAttribute("user")).getPermision();
		switch (permision) {
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
}
