package com.chainsys.realestate.validate;

public class Validate {
	public static boolean emailValidate(String email) {
		boolean isValid=false;
		String emailRegex = "^([a-zA-Z0-9]+)@([a-zA-Z]+).([a-z]{2,3})$";
		if (email.matches(emailRegex)) {
			isValid=true;
		}
		return isValid;
	}
	public static boolean passwordValidate(String password) {
		boolean isValid=false;
		String passwordRegex = "^([a-zA-Z0-9$&]+)$";
		if (password.matches(passwordRegex)) {
			isValid=true;
		}
		return isValid;
	}
	public static boolean checkIsString(String input)
	{
		boolean isValid=false;
		String stringRegex = "^([a-zA-Z]+)$";
		if (input.matches(stringRegex)) {
			isValid=true;
		}
		return isValid;
	}
	public static boolean numberValidation(String number)
	{
		boolean isValid=false;
		String numberRegex = "^([0-9]+)$";
		if (number.matches(numberRegex)) {
			isValid=true;
		}
		return isValid;
	}
}
