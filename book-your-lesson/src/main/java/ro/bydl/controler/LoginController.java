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
@SessionAttributes({ "weeks"})
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
	public ModelAndView mainPage(HttpSession session) {
		
		ModelAndView mav = new ModelAndView("login");
		System.out.println(mav.toString());
		
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
		session.setAttribute("weeks", Calendar.getInstance().get(Calendar.WEEK_OF_YEAR));
	
try{
		if (loginService.Permision(user) != null) {
			
				session.setAttribute("user", loginService.Permision(user));

				modelandView.setView(new RedirectView("/schedule"));
						

		}
}catch(Exception e){
	
	
	modelandView = new ModelAndView("login");
	modelandView.addObject("error",new String("User or pasword is incorect"));
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
	 

}
