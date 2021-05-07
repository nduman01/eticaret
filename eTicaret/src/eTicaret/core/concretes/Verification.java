package eTicaret.core.concretes;

import java.util.regex.Pattern;

import eTicaret.core.abstracts.VerificationService;
import eTicaret.entities.concretes.User;

public class Verification implements VerificationService{
	
	public boolean isValidEmail(String email) {
		String emailRegex="^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
		Pattern pattern=Pattern.compile(emailRegex);
		if(email==null) return false;
		return pattern.matcher(email).matches();
	}
	
	public boolean isValidPassword(String password) {
		if(password==null || password.length()<6) {
			return false;
		}
		return true;
	}
	
	public boolean isValidString(String name) {
		if(name==null || name.length()<2) {
			return false;
		}
		return true;
	
	}

	@Override
	public boolean isValid(User user) {
		if(!isValidEmail(user.getEmail())) {
			System.out.println("e-mail adresini do�ru girmediniz!");
			return false;
		}
		
		if(!isValidString(user.getFirstName())) {
			System.out.println("Kullan�c� ad� en az iki karakter olmal�d�r!");
			return false;
		}
		if(!isValidString(user.getLastName())) {
			System.out.println("Kullan�c� soyad� en az iki karakter olmal�d�r!");
			return false;
		}
		if(!isValidPassword(user.getPassword())) {
			System.out.println("�ifre en az 6 karakterden olu�mal�d�r.");
			return false;
		}
		return true;
	}

}
