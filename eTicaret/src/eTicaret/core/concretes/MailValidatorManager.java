package eTicaret.core.concretes;

import eTicaret.core.abstracts.ValidatorService;

public class MailValidatorManager implements ValidatorService{

	@Override
	public void sendMail() {
		System.out.println("Doðrulama için mail gönderildi.");
		
	}
	

}
