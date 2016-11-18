package ro.bydl.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * This class is a helper class for geting the days of the week giving a suritain week
 * 
 * @author Raul
 *
 */

public class CalendarHelper{
/**
 * Method returns date for money
 * @param week
 * @return
 */
	public String monday(int week) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.WEEK_OF_YEAR,week);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		
		return sdf.format(cal.getTime());
	}
	/**
	 * Method returns date for tuesday
	 * @param week
	 * @return String
	 */
	public String tuesday(int week) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.WEEK_OF_YEAR, week);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);

		return (sdf.format(cal.getTime()));
	}
	/**
	 * Method returns date for Wednesday
	 * @param week
	 * @return
	 */
	public String wednesday(int week) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.WEEK_OF_YEAR, week);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);

		return (sdf.format(cal.getTime()));
	}
	/**
	 * Method returns date for Thursday
	 * @param week
	 * @return
	 */
	public String thursday(int week) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.WEEK_OF_YEAR, week);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);

		return (sdf.format(cal.getTime()));
	}
	/**
	 * Method returns date for Friday
	 * @param week
	 * @return
	 */
	public String friday(int week) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.WEEK_OF_YEAR, week);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);

		return (sdf.format(cal.getTime()));
	}
	/**
	 * Method returns date for Saturday
	 * @param week
	 * @return
	 */
	public String saturday(int week) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.WEEK_OF_YEAR, week);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);

		return (sdf.format(cal.getTime()));
	}
	/**
	 * Method returns date for Sunday of next week
	 * @param week
	 * @return
	 */
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
