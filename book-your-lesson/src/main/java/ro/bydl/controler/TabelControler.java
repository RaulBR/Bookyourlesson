package ro.bydl.controler;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ro.bydl.domain.Teacher;
import ro.bydl.service.StudentService;

public class TabelControler {
	
	@Autowired
	private StudentService studentService;
	
	
	@RequestMapping("student/list")
	public ModelAndView studentList(HttpSession session) throws Exception {
		String permison = session.getAttribute("permision").toString();
		ModelAndView result = new ModelAndView("studentList");
		Teacher teacher=(Teacher) session.getAttribute("teacherOBJ");
		result.addObject("permision", permison);
	result.addObject("students", studentService.getByTeacherId( teacher.getId()));

		return result;
	}
}
