package eTicaret.core.concretes;

import eTicaret.JGoogleUserValid.JGoogleVerificationService;
import eTicaret.core.abstracts.VerificationService;
import eTicaret.entities.concretes.User;

public class JGoogleVerificationServiceAdapter implements VerificationService{

	@Override
	public boolean isValid(User user) {
		JGoogleVerificationService googleUserValid=new JGoogleVerificationService();
		return googleUserValid.isValid();
	}

}
