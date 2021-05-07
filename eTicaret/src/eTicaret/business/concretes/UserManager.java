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
			System.out.println("Kullanýcý bilgilerinde hata. Kayýt baþarýsýz!");
		}else if(!userDaoService.checkEmail(user)) {
			System.out.println(user.getEmail()+" adresi daha önce kullanýlmýþ. Kayýt baþarýsýz!");
			}
		else {
			userDaoService.add(user);
			validatorService.sendMail();
		}
	
		
	}

	@Override
	public void login(String email, String password) {
		if(userDaoService.login(email, password)) {
			System.out.println("Giriþ yapýldý.");
		}
		else {
			System.out.println("Kullanýcý adý veya þifre yanlýþ. Giriþ baþarýsýz!");			
		}
		
	}
	
}
