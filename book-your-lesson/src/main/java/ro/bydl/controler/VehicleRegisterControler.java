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
 * This class is the model and view controller for the registration forms of the
 * application
 * 
 * @author Raul
 *
 */
@Controller
@RequestMapping("/register")
public class VehicleRegisterControler {

	@Autowired
	TeacherService teacherService;
	@Autowired
	RegisterService registerService;
	@Autowired
	VehicleService vehicleService;




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
	
}
