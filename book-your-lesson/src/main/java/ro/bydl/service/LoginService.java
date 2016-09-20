package ro.bydl.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	public boolean validateAdmin(String user, String password) {
		return user.equalsIgnoreCase("admin") && password.equals("admin");
	}

	public boolean validateUser(String name, String password) {
		return name.equalsIgnoreCase("user") && password.equals("user");
	}
}
