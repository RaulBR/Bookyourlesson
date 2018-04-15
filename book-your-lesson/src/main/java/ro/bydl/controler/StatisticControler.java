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
	public ModelAndView TeacherStatistics(HttpSession session) {
		if (session.getAttribute("user") != null) {
			// User user= (User) session.getAttribute("user");
			ModelAndView result = new ModelAndView("teacherBarStatistic");
			result.addObject("teacherSchedules", teacherStatisticService.howBusy());
			return result;
		} else {
			return new ModelAndView("login");
		}
	}

	@RequestMapping("/teacher")
	public ModelAndView teacherStatistics(HttpSession session, Long teacherId) {
		ModelAndView result;
		if (teacherId != null) {
			result = new ModelAndView("teacherStatistic");
			result.addObject("teacherSchedule", teacherStatisticService.howBusy(teacherId));
		} else {
			return new ModelAndView("login");
		}
		return result;
	}

	@RequestMapping("/student")
	public ModelAndView studentStatistics(HttpSession session, Long studentId) {
		ModelAndView result;
		if (session.getAttribute("user") != null) {
			if (studentId != null) {
				result = new ModelAndView("teacherStatistic");
				result.addObject("teacherSchedule", studentStatisticService.howBusys(studentId));
			} else {
				return new ModelAndView("login");
			}
		} else {
			return new ModelAndView("login");
		}
		return result;

	}

}
