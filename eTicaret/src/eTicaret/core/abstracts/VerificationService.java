package eTicaret.core.abstracts;

import eTicaret.entities.concretes.User;

public interface VerificationService {
	boolean isValid(User user);

}
