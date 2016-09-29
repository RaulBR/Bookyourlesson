package ro.bydl.controler;

import java.util.Calendar;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import ro.bydl.domain.User;
import ro.bydl.service.LoginService;
import ro.bydl.service.StudentService;
import ro.bydl.service.TeacherService;

/**
 * This class is the ModelVew controller for the log in of the application. It
 * retrieves and checks privacy and sets the session objects
 * 
 * @author Raul Ranete
 *
 */
@Controller
@Scope("session")
@RequestMapping("")
@SessionAttributes({ "week"})
public class LoginController {

	@Autowired
	private LoginService loginService;
	@Autowired
	TeacherService teacherService;
	@Autowired
	StudentService studentService;

	/**
	 * Tihis method with the returns the main log page of the aplication
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("")
	public ModelAndView mainPage(HttpSession session,  SessionStatus status) {
		 session.invalidate();
		ModelAndView mav = new ModelAndView("login");

		mav.addObject("week", Calendar.getInstance().get(Calendar.WEEK_OF_YEAR));
		
		return mav;
	}

	/**
	 * This method checks
	 * 
	 * @param user
	 * @param bindingResult
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ModelAndView add(@Valid @ModelAttribute("user") User user, BindingResult bindingResult,
			HttpSession session) {
		ModelAndView modelandView = new ModelAndView("login");

		if (loginService.Permision(user) != null) {

			User logedUser = loginService.Permision(user);

			if (logedUser.getPermision().equals("student")) {
				;
				session.setAttribute("studentLogedId", logedUser.getStudentId());
				session.setAttribute("studentOBJ", studentService.findById(user.getStudentId()));
				session.setAttribute("permision", logedUser.getPermision());
				modelandView.setView(new RedirectView("/schedule"));
				session.setAttribute("user", user);
			
			}

			else {

				if (logedUser.getPermision().equals("teacher")) {
					
					session.setAttribute("theacherLogId", logedUser.getTeacherId());
					
					session.setAttribute("permision", logedUser.getPermision());
					session.setAttribute("teacherOBJ", teacherService.findById(user.getTeacherId()));
					session.setAttribute("user", user);

					modelandView.setView(new RedirectView("/schedule"));
				}
			}

				if (logedUser.getPermision().equals("admin")) {
					
					session.setAttribute("permision", logedUser.getPermision());
					session.setAttribute("user", user);

					modelandView=new ModelAndView("admin");
				
			}

		}

		return modelandView;

	}
	

	  @RequestMapping("/logout")
	  public ModelAndView logout(HttpSession session) {
		  ModelAndView modelANdVeiw=new ModelAndView();
		  modelANdVeiw.setView(new RedirectView(""));
	    session.invalidate();
	    return  modelANdVeiw;
	  
	}
	  @RequestMapping("/erro")
	  public ModelAndView error(HttpSession session) {
		  ModelAndView modelANdVeiw=new ModelAndView();
		  modelANdVeiw.setView(new RedirectView(""));
	    session.invalidate();
	    return  modelANdVeiw;
	  
	}

}
