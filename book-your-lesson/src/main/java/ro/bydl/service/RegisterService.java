package ro.bydl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.bydl.dao.database.JdbcTemplateUserDao;
import ro.bydl.domain.User;

@Service
public class RegisterService {

	@Autowired
	JdbcTemplateUserDao dao;

	public boolean checkUserUnique(User user) {
		boolean isFree = true;

		for (User users : dao.getAllUsers()) {
			String userFromDao=users.getUser();
			String inComingUser=user.getUser();
			if (inComingUser.equals(userFromDao)) {
				isFree = false;

			}
		}
		return isFree;

	}

	public void addUser(User user) {

		dao.update(user);
	}

	public boolean checkPass(String pass, String pass2) {
		if (pass.equals(pass2)) {
			return true;
		} else {
			return false;
		}
	}
}
