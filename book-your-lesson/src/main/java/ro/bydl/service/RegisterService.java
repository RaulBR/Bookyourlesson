package ro.bydl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.bydl.dao.database.jdbcTemplateUserDao;
import ro.bydl.domain.User;

@Service
public class RegisterService {
	
@Autowired
jdbcTemplateUserDao dao;


public boolean checkUserUnique(User user2) {
		boolean isFree=true;
	
		for(User user: dao.getAllUsers()){
		if(user2.getUser().equals(user)){
			isFree= false;
			System.out.println("e fals");
			
		}
	
	}
		
		return isFree;


}
public void addUser(User user){
	
	dao.update(user);
}
	public boolean checkPass(String pass, String pass2) {
		if(pass==pass2){
			return true;
		}else{
		return false;
		}
	}
}
