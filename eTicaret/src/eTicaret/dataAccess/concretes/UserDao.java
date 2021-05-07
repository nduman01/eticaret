package eTicaret.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import eTicaret.dataAccess.abstracts.UserDaoService;
import eTicaret.entities.concretes.User;

public class UserDao implements UserDaoService{
	List<User> users=new ArrayList<>();
	
	
	

	@Override
	public void add(User user) {
		users.add(user);
		System.out.println(user.getFirstName()+ " adlý kullanýcý eklendi.");
		
	}

	@Override
	public boolean checkEmail(User user) {
		
		for (User userx : users) {
			if(userx.getEmail()==user.getEmail()) {
				return false;
				}
			
		}
		return true;
	}

	@Override
	public boolean login(String email, String password) {
		for (User usery : users) {
			if(usery.getEmail()==email && usery.getPassword()==password) {
				return true;
			}
			
		}
		
		return false;
	}
	

}
