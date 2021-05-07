package eTicaret.business.concretes;

import eTicaret.business.abstracts.UserService;
import eTicaret.core.abstracts.ValidatorService;
import eTicaret.core.abstracts.VerificationService;
import eTicaret.dataAccess.abstracts.UserDaoService;
import eTicaret.entities.concretes.User;

public class UserManager implements UserService{
	VerificationService verificationService;
	UserDaoService userDaoService;
	ValidatorService validatorService;
	
	
	
	public UserManager(VerificationService verificationService, 
			UserDaoService userDaoService,
			ValidatorService validatorService) {
		
		this.verificationService = verificationService;
		this.userDaoService = userDaoService;
		this.validatorService = validatorService;
	}
	

	@Override
	public void register(User user) {
		if(!verificationService.isValid(user)) {
			System.out.println("Kullan�c� bilgilerinde hata. Kay�t ba�ar�s�z!");
		}else if(!userDaoService.checkEmail(user)) {
			System.out.println(user.getEmail()+" adresi daha �nce kullan�lm��. Kay�t ba�ar�s�z!");
			}
		else {
			userDaoService.add(user);
			validatorService.sendMail();
		}
	
		
	}

	@Override
	public void login(String email, String password) {
		if(userDaoService.login(email, password)) {
			System.out.println("Giri� yap�ld�.");
		}
		else {
			System.out.println("Kullan�c� ad� veya �ifre yanl��. Giri� ba�ar�s�z!");			
		}
		
	}
	
}
