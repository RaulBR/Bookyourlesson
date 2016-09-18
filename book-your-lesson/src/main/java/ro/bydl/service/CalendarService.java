package ro.bydl.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class CalendarService implements CalendarInterface {

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

		return (sdf.format(cal.getTime()));
	}

	public String getTuesday() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.WEEK_OF_YEAR, getWeek());
		cal.set(Calendar.DAY_OF_WEEK, Calendar.TUESDAY);

		return (sdf.format(cal.getTime()));
	}

	public String getWednesday() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.WEEK_OF_YEAR, getWeek());
		cal.set(Calendar.DAY_OF_WEEK, Calendar.WEDNESDAY);

		return (sdf.format(cal.getTime()));
	}

	public String getThursday() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.WEEK_OF_YEAR, getWeek());
		cal.set(Calendar.DAY_OF_WEEK, Calendar.THURSDAY);

		return (sdf.format(cal.getTime()));
	}

	public String getFriday() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.WEEK_OF_YEAR, getWeek());
		cal.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);

		return (sdf.format(cal.getTime()));
	}

	public String getSaturday() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.WEEK_OF_YEAR, getWeek());
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);

		return (sdf.format(cal.getTime()));
	}

	public String getSunday() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.WEEK_OF_YEAR, getWeek() + 1);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);

		return (sdf.format(cal.getTime()));
	}

	public ArrayList<String> getAll() {
		ArrayList<String> s = new ArrayList<>();
		s.add(getMonday());
		s.add(getTuesday());
		s.add(getWednesday());
		s.add(getThursday());
		s.add(getFriday());
		s.add(getSaturday());
		s.add(getSunday());

		return s;

	}

}
