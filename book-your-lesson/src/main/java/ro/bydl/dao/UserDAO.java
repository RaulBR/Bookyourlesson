package ro.bydl.dao;

import ro.bydl.domain.User;

public interface UserDAO extends BaseDao<User> {

	User getByUserAndPaswoard(String user, String passwoard);
	User getByUser(String user);

	
}
