package ro.bydl.service;

import java.util.ArrayList;

import ro.bydl.domain.Schedule;

public class Main {

	public static void main(String[] args) throws ValidationException {
		Schedule s = new Schedule();
		s.setDate("13.13.2016");
		
		ScheduleService se=new ScheduleService();
		
		System.out.println(se.validate(s));

	

	}

}
