import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordCheckerUtility {


	public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException{
		
		boolean isValid;
		isValid = isValidLength(password) && hasUpperAlpha(password)
				&& hasLowerAlpha​(password) && hasDigit​(password)&& 
				hasSpecialChar​(password) && NoSameCharInSequence​(password);
		
		return isValid;
	}
	
	public static void comparePasswords(String password, String passwordConfirm)throws UnmatchedException{
		if (!password.equals(passwordConfirm)) {
			throw new UnmatchedException();
		};
	}
	
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
		return password.equals(passwordConfirm);
	}
	
	public static boolean isValidLength(String password) throws LengthException {
		
		if (password.length()>= 6) {
			return true;
		}
		else 
			throw new LengthException();
	}
	
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
		int upperAlphaCount = 0;
		
		for (int i = 0 ; i < password.length(); i++) {
			if (Character.isUpperCase(password.charAt(i)))  {
				upperAlphaCount++;
			}
		}
		
		if (upperAlphaCount > 0) {
			return true;
		}
		
		else 
			throw new NoUpperAlphaException();
	}
	
	public static boolean hasLowerAlpha​(String password) throws NoLowerAlphaException {
		int lowerAlphaCount = 0;
		
		for (int i = 0 ; i < password.length(); i++) {
			if (Character.isLowerCase(password.charAt(i))) {
				lowerAlphaCount++;
			}
		}
		
		if (lowerAlphaCount > 0) {
			return true;
		}
		
		else 
			throw new NoLowerAlphaException();
	}
	
	public static boolean hasDigit​(java.lang.String password) throws NoDigitException {
	
		int digitCount = 0;
		
		for (int i =0 ; i < password.length() ; i++) {
			
			if (Character.isDigit(password.charAt(i))) {
				digitCount++;
			}
		}
		
		if (digitCount > 0) {
			return true;
		}
		
		else {
			throw new NoDigitException();
		}
	}
	
	public static boolean hasSpecialChar​(String password) throws NoSpecialCharacterException {
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		Matcher matcher = pattern.matcher(password);
		boolean result = (matcher.matches());

		if (result == false) {
			return true;
		}
		else 
			throw new NoSpecialCharacterException();
	}
	
	public static boolean NoSameCharInSequence​(String password) throws InvalidSequenceException {
		
		for (int i = 1 ; i < password.length()-1 ; i++) {
		
			if (password.charAt(i) == password.charAt(i-1) 
					&& password.charAt(i) == password.charAt(i+1)) {
				throw new InvalidSequenceException();
			}
		}
		return true;
	}
	
	
	public static boolean hasBetweenSixAndNineChars(String password){
		return password.length() >= 6 && password.length() <= 9;
	}

	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords){
		
		
		ArrayList<String> invalidPasswords = new ArrayList<>();
		
		for (String p : passwords) {
			
			try {
				isValidPassword(p);
			} 
			catch (LengthException e) {
				invalidPasswords.add(p + " " + e.getMessage());
			} 
			catch (NoUpperAlphaException e) {
				invalidPasswords.add(p + " " + e.getMessage());
			} 
			catch (NoLowerAlphaException e) {
				invalidPasswords.add(p + " " + e.getMessage());
			} 
			catch (NoDigitException e) {
				invalidPasswords.add(p + " " + e.getMessage());
			} 
			catch (NoSpecialCharacterException e) {
				invalidPasswords.add(p + " " + e.getMessage());
			} 
			catch (InvalidSequenceException e) {
				invalidPasswords.add(p + " " + e.getMessage());
			}
		}
		
		return invalidPasswords;
	}
	
	public static boolean isWeakPassword(String password) throws WeakPasswordException, LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException{
	
		if (isValidPassword(password) && !hasBetweenSixAndNineChars(password)) {
			return false;
		}
		else
			throw new WeakPasswordException();
	}
}
