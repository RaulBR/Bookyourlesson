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
	public ModelAndView TeacherStatistics(HttpSession sesion) {

		ModelAndView result = new ModelAndView("teacherBarStatistic");

		result.addObject("teacherSchedules", teacherStatisticService.howBusy());

		return result;

	}

	@RequestMapping("/teacher")
	public ModelAndView teacherStatistics(HttpSession sesion, long teacherId) {
		// int week= (int) sesion.getAttribute("week");
		ModelAndView result = new ModelAndView("teacherStatistic");

		result.addObject("teacherSchedule", teacherStatisticService.howBusy(teacherId));

		return result;

	}

	@RequestMapping("/student")
	public ModelAndView studentStatistics(HttpSession sesion, long studentId) {

		ModelAndView result = new ModelAndView("teacherStatistic");

		result.addObject("teacherSchedule", studentStatisticService.howBusys(studentId));

		return result;

	}
	

}
