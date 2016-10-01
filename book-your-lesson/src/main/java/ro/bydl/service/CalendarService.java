package ro.bydl.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CalendarService{
	@SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(CalendarService.class);
	public String monday(int week) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.WEEK_OF_YEAR,week);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		
		return sdf.format(cal.getTime());
	}

	public String tuesday(int week) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.WEEK_OF_YEAR, week);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);

		return (sdf.format(cal.getTime()));
	}

	public String wednesday(int week) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.WEEK_OF_YEAR, week);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);

		return (sdf.format(cal.getTime()));
	}

	public String thursday(int week) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.WEEK_OF_YEAR, week);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);

		return (sdf.format(cal.getTime()));
	}
	public String friday(int week) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.WEEK_OF_YEAR, week);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);

		return (sdf.format(cal.getTime()));
	}

	public String saturday(int week) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.WEEK_OF_YEAR, week);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);

		return (sdf.format(cal.getTime()));
	}

	public String sunday(int week) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.WEEK_OF_YEAR, week + 1);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);

		return (sdf.format(cal.getTime()));
	}
	

	public String[] getDays(int week) {
		
	
		String [] days={monday(week),tuesday(week),wednesday(week),thursday(week),friday(week),saturday(week),sunday(week)};
		

		return days;

	}



}
