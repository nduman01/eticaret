package eTicaret;

import eTicaret.business.abstracts.UserService;
import eTicaret.business.concretes.UserManager;
import eTicaret.core.concretes.JGoogleVerificationServiceAdapter;
import eTicaret.core.concretes.MailValidatorManager;
import eTicaret.core.concretes.Verification;
import eTicaret.dataAccess.concretes.UserDao;
import eTicaret.entities.concretes.User;

public class Main {
	public static void main(String[] args) {
		User ahmet=new User(1,"Ahmet","Mahmet","ahmet@gmail.com","12345");
		User ayþe=new User(2,"Ayþe","Mayþe","ayþe1gmail.com","123456");
		User ali=new User(3,"Ali","Mali","ali@gmail.com","123456");
		
		UserService userService=new UserManager(new Verification(),
				new UserDao(), new MailValidatorManager());
		
		userService.register(ahmet);
		userService.register(ayþe);
		userService.register(ali);
		
		UserService userService2=new UserManager(new JGoogleVerificationServiceAdapter(), new UserDao(), new MailValidatorManager());;
		userService2.register(ali);
		
		userService.login("ali@gmail.com", "123456");
		userService.login("ali@gmail.com", "1234");
		
				
		
		
		
		
		
	}
}
