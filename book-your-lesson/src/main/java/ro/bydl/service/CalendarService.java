package ro.bydl.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarService implements CalendarInterface{

	private String monday;
	private String tuesday;
	private String wednesday;
	private String thursday;
	private String friday;
	private String saturday;
	private String sunday;
	private int week = Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);

	public int getWeek() {

		return week;

	}

	public void setWeek(int week) {
		this.week = week + 1;

	}

	public void setPreviousWeek(int week) {
		this.week = week - 1;

	}
	public void setThisWeek() {
		this.week = Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);

	}

	public String getMonday() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.WEEK_OF_YEAR, week);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		monday = (sdf.format(cal.getTime()));
		return monday;
	}

	public String getTuesday() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.WEEK_OF_YEAR, getWeek());
		cal.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);
		tuesday = (sdf.format(cal.getTime()));
		return tuesday;
	}

	public String getWednesday() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.WEEK_OF_YEAR, getWeek());
		cal.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);
		wednesday = (sdf.format(cal.getTime()));
		return wednesday;
	}

	public String getThursday() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.WEEK_OF_YEAR, getWeek());
		cal.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);
		thursday = (sdf.format(cal.getTime()));
		return thursday;
	}

	public String getFriday() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.WEEK_OF_YEAR, getWeek());
		cal.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		friday = (sdf.format(cal.getTime()));
		return friday;
	}

	public String getSaturday() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.WEEK_OF_YEAR, getWeek());
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		saturday = (sdf.format(cal.getTime()));
		return saturday;
	}

	public String getSunday() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.WEEK_OF_YEAR, getWeek() + 1);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		sunday = (sdf.format(cal.getTime()));
		return sunday;
	}

}
