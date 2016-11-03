package ro.bydl.controler;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ro.bydl.service.statistics.StudentSchedulesStatisticService;
import ro.bydl.service.statistics.TeacherScheduleStatisticsService;
@Controller
@RequestMapping("statistics")
public class StatisticControler {
	@Autowired
	TeacherScheduleStatisticsService teacherStatisticService;
	@Autowired
	StudentSchedulesStatisticService studentStatisticService;
	
	
	@RequestMapping("")
	public ModelAndView TeacherStatistics(HttpSession sesion){
	//	int week= (int) sesion.getAttribute("week");
		ModelAndView result=new ModelAndView("teacherStatistics");
		
			
		
		result.addObject("teacherSchedules", teacherStatisticService.howBusy());
		
		return result;
		
		
	}
	@RequestMapping("/students")
	public ModelAndView StudentStatistics(HttpSession sesion){
	//	int week= (int) sesion.getAttribute("week");
		ModelAndView result=new ModelAndView("teacherStatistics");
		
			
		
		result.addObject("teacherSchedules", studentStatisticService.howBusy());
		
		return result;
		
		
	}

}