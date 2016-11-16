package ro.bydl.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import ro.bydl.domain.Person;

public class PersonHelper extends RegisternService  {

	public boolean isCnpCorectFormat(Person person) {
	
		return 	person.getCnp().matches("[+-]?\\d*(\\.\\d+)?");
	}

	public Date birthDay(Person person) {
		Date date = null;
		if(!isCnpRightLength(person)){
			date = null;
		}else  if(isCnpRightLength(person)){
	
		String[] cnpElements = person.getCnp().split("");
		String year = "";
		String day = "";
		String month = "";
		for (int i = 1; i < 3; i++) {
			year = year + cnpElements[i];
		}
		for (int i = 3; i < 5; i++) {
			month = month + cnpElements[i];
		}

		for (int i = 5; i < 7; i++) {
			day = day + cnpElements[i];
		}
		int intYear = Integer.parseInt(year);
		if (intYear > 20) {
			year = "19" + year;
		} else {
			year = "20" + year;
		}
		String stringDate = day + "." + month + "." + year;
		DateFormat formatter;

		formatter = new SimpleDateFormat("dd.MM.yyyy");
		
		try {
			date = formatter.parse(stringDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return date;

	}

	protected void refinePerson(Person person) {
		person.setBirthDay(birthDay(person));
		StringHelper stringHelper=new StringHelper();
		person.setName(stringHelper.formatFirstToUpeerOtherToLowerCase(person.getName()));
		person.setSirName(stringHelper.formatFirstToUpeerOtherToLowerCase(person.getSirName()));
	}

	
	public boolean isCnpRightLength(Person person) {
		String cnp = person.getCnp();
		if (cnp.length() < 12) {
			return false;
		} else {
			return true;
		}

	}
	public boolean isEmpty(Person person) {
		if(person.getName().equals("")){
			return true;
		}
		if(person.getSirName().equals("")){
			return true;
		}
		if(person.getCnp().equals("")){
			return true;
		}
		if(person.getCategory().equals("")){
			return true;
		}
		if(person.getPhoneNumber().equals("")){
			return true;
		}
		if(person.getEmail().equals("")){
			return true;
		}
		return false;
	}

}
