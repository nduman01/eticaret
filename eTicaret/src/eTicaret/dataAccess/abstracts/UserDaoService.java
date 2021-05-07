package eTicaret.dataAccess.abstracts;

import eTicaret.entities.concretes.User;

public interface UserDaoService {
	void add(User user);
	boolean checkEmail(User user);
	boolean login(String email, String password);
	
}
