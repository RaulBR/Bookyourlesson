package ro.bydl.controler;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import ro.bydl.domain.Teacher;
import ro.bydl.domain.User;
import ro.bydl.domain.Vehicle;
import ro.bydl.service.RegisterService;
import ro.bydl.service.TeacherService;
import ro.bydl.service.VehicleService;
import ro.bydl.service.errors.ValidationException;

/**
 * This class is the model and view controller for the registration forms of the
 * application
 * 
 * @author Raul
 *
 */
@Controller
@RequestMapping("/vehicle")
public class VehicleRegisterControler {

	@Autowired
	TeacherService teacherService;
	@Autowired
	RegisterService registerService;
	@Autowired
	VehicleService vehicleService;

	@RequestMapping("")
	public ModelAndView add(HttpSession session) {
		ModelAndView result = new ModelAndView("vehicle");
		User user = (User) session.getAttribute("user");

		String permision = user.getPermision();
		switch (permision) {
		case "teacher":
			Teacher teacher = teacherService.findById(user.getTeacherId());

			result.addObject("teacherOBJ", teacher);
			break;
		case "admin":
			result.addObject("teachers", teacherService.getAll());
			break;
		}
		return result;
	}

	@RequestMapping("/list")
	public ModelAndView list(HttpSession session, User u) {
		ModelAndView result = new ModelAndView("vehicleList");

		if (u.getTeacherId() > 0) {
			result.addObject("vehicles", vehicleService.findByTeacherId(u.getTeacherId()));

		} else if (((User) session.getAttribute("user")).getPermision() == "teacher") {
			result.addObject("vehicles",
					vehicleService.findByTeacherId(((User) session.getAttribute("user")).getTeacherId()));
			result.addObject("permision", ((User) session.getAttribute("user")).getPermision());
		} else {
			result.addObject("vehicles", vehicleService.getAll());
			result.addObject("permision", ((User) session.getAttribute("user")).getPermision());
		}
		return result;
	}

	@RequestMapping("/save")
	public ModelAndView save(@Valid @ModelAttribute("vehicle") Vehicle vehicle, BindingResult bindingResult,
			HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("/vehicle");

		try {
			vehicleService.save(vehicle);
		} catch (ValidationException e) {

			modelAndView = new ModelAndView("/vehicle");
			modelAndView.addObject("errors", e.getCauses());
			e.printStackTrace();
		}
		// modelAndView.setView(new RedirectView("list"));

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
	public ModelAndView edit(@Valid @ModelAttribute("edit") Vehicle vehicle, BindingResult bindingResult,
			HttpSession session) {
		ModelAndView modelAndView = new ModelAndView("/vehicle");

		modelAndView.addObject("vehicle", vehicleService.findById(vehicle.getId()));
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
