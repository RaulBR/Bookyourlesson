package ro.bydl.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import ro.bydl.domain.Person;

public class PersonHelper {
	
	
	public boolean isCnpCorectFormat(Person student) {
		String stringCnp= student.getCnp();
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
		
		String stringDate=day+"."+month+"."+year;
		DateFormat formatter ; 
	
		   formatter = new SimpleDateFormat("dd.MM.yyyy");
		   
		try {
			 @SuppressWarnings("unused")
			Date date = formatter.parse(stringDate);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}
	
	
	public Date birthDay(String cnp) {
		
		String stringCnp= cnp;
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
		String stringDate=day+"."+month+"."+year;
		DateFormat formatter ; 
	
		   formatter = new SimpleDateFormat("dd.MM.yyyy");
		   Date date = null;
		try {
			date = formatter.parse(stringDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return date;
		
		
		
	}
	
	
	protected void refinePerson(Person person){
		person.setBirthDay(birthDay(person.getCnp()));
		
		person.setName(formatName(person.getName()));
		person.setSirName(formatName(person.getSirName()));
	}
	private String formatName(String nameToDo) {
		String name="";
		
		
		
		String[]first=nameToDo.split("");
		
		int count=0;
		for(String s:first){
			if(count==0){
			name=s.toUpperCase();	
			}else{
				name+=s.toLowerCase();
			}
			count++;
		}
		return name;
		
	}
}
