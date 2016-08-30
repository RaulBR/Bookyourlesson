package ro.bydl.service;

import java.util.ArrayList;

import ro.bydl.domain.Schedule;

public class Main {

	public static void main(String[] args) {
		Schedule s = new Schedule();
		ArrayList<Schedule> a = new ArrayList<>();

		s.setStartHour("8");
		s.setEndHour("10");
		s.setDay("31");
		s.setMonth("11");
		s.setYear("2016");

		a.add(s);
		Schedule s1 = new Schedule();
		s1.setStartHour("8");
		s1.setEndHour("10");
		s1.setDay("30");
		s1.setMonth("11");
		s1.setYear("2016");

		a.add(s1);
		Schedule s2 = new Schedule();
		s2.setStartHour("8");
		s2.setEndHour("10");
		s2.setDay("29");
		s2.setMonth("11");
		s2.setYear("2016");

		a.add(s2);

		ScheduleService service = new ScheduleService();

		service.setScheduels(a);
		Schedule tobe = new Schedule();
		tobe.setStartHour("8");
		tobe.setEndHour("10");
		tobe.setDay("30");
		tobe.setMonth("11");
		tobe.setYear("2016");
		System.out.println(service.checkIfFree(tobe));

	}

}
