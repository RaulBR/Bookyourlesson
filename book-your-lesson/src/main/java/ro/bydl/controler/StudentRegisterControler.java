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
	 * @param teacherId
	 * @param vhicleId
	 * 
	 * @return
	 */

	@RequestMapping("")
	public ModelAndView student(HttpSession session,Long vehicleId, Long id) {
		ModelAndView result = new ModelAndView("studentForm");
		
		
		if(vehicleId!=null){
			
			result.addObject("teacherFromList",teacherService.findById(vehicleService.findById(vehicleId).getTeacherId()));
		} else if(id!=null){
			result.addObject("teacherFromList",teacherService.findById(id));
			} else{
				result.addObject("teachers", teacherService.getAll());
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
	public ModelAndView studentList(HttpSession session, Student s) {
		String permison = ((User) session.getAttribute("user")).getPermision();
		ModelAndView result = new ModelAndView("studentList");
		if (s.getTeacherId() > 0) {
			result.addObject("students", studentService.getByTeacherId(s.getTeacherId()));

		} else {

			result.addObject("students", studentService.getAll());

		}
		result.addObject("permision", permison);
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
