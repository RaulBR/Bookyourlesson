package ro.bydl.dao;

import java.util.Collection;

import org.springframework.stereotype.Component;

import ro.bydl.domain.User;

public interface UserDAO extends BaseDao<User> {

	public Collection<User> getAllUsers();
	
}
