package ro.bydl.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;

import ro.bydl.domain.Student;

public class StudentHelper {
	public String birthDay(long cnp){
		String stringCnp= Long.toString(cnp);
		String []cnpElements=stringCnp.split("");
		String year="";
		String day="";
		String month="";
		for(int i=1;i <3;i++){
			year=year+cnpElements[i];
		}
		for(int i=3;i <5;i++){
			month=month+cnpElements[i];
		}
		
		for(int i=5;i <7;i++){
			day=day+cnpElements[i];
		}
		int intYear=Integer.parseInt(year);
		if(intYear>20){
			year="19"+year;
		}else{
			year="20"+year;
		}
		return day+"."+month+"."+year;
		
	}
	
	
	
	public boolean isAllawed(Student student ){
		DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
		java.util.Date date = null;
		try {
			 date =  formatter.parse(student.getBirthDay());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar calendar = Calendar.getInstance();
		
		calendar.setTime(date);
		LocalDateTime now = LocalDateTime.now();
		
		if(now.getYear()-calendar.getWeekYear()<18){
			return false;
		}else{
		return true;
		
	}}
}
