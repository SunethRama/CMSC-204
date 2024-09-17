
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author 
 * 
 *
 */
public class PasswordCheckerTest_STUDENT {

	
	ArrayList<String> passwords;
	
	@Before
	public void setUp() throws Exception {
		passwords = new ArrayList<>();
		
		// valid
		passwords.add("Hello@123");
		passwords.add("!!_123Aab");
		passwords.add("Abcd@$!!123");
		
		// Invalid
		passwords.add("123");
		passwords.add("abcd123");
		passwords.add("Abcd123");
		passwords.add("Abcd!@#$");
		passwords.add("Abcd@$$$123");
	}

	@After
	public void tearDown() throws Exception {
		passwords = null;
	}

	/**
	 * Test if the two passwords user entered does not match.
	 * This test should throw a UnmatchedException for second case.
	 */
	@Test
	public void testThatComparePasswordsThrowUnmatchedException(){
		try {
			PasswordCheckerUtility.comparePasswords("password1", "password2");
			assertTrue("Failure: Exception should have been thrown", false);
		}
		catch (UnmatchedException e) {
			assertTrue("Correct Exception thrown", true);
		}
		catch (Exception e) {
			assertTrue("Failure: Invalid Exception thrown", false);
		}
	}
	
	/**
	 * Test if the two passwords user entered does match or not.
	 */
	@Test
	public void testThatComparePasswordsReturnTrueWhenMatched(){
		assertTrue(PasswordCheckerUtility.comparePasswordsWithReturn("password1", "password1"));
		assertTrue(PasswordCheckerUtility.comparePasswordsWithReturn("Hello@123!!", "Hello@123!!"));
		assertTrue(PasswordCheckerUtility.comparePasswordsWithReturn("abc@123", "abc@123"));
		
		assertFalse(PasswordCheckerUtility.comparePasswordsWithReturn("password1", "password2"));
		assertFalse(PasswordCheckerUtility.comparePasswordsWithReturn("Hello@123!!", "Hello@123!!@"));
		assertFalse(PasswordCheckerUtility.comparePasswordsWithReturn("abc@123", "abc@123_!#"));
	}
	
	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try {
			PasswordCheckerUtility.isValidLength("abc");
			assertTrue("Failure: Exception should have been thrown", false);
		} 
		catch (LengthException e) {
			assertTrue("Successfully thrown the length exception", true);
		}
		catch (Exception e) {
			assertTrue("Invalid exception thrown", false);
		}
	}
	
	/**
	 * Test if the password has at least one upper case alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try {
			PasswordCheckerUtility.hasUpperAlpha("abc2005");
			assertTrue("Failure: Exception should have been thrown", false);
		} 
		catch (NoUpperAlphaException e) {
			assertTrue("Successfully thrown the NoUpperAlpha exception", true);
		}
		catch (Exception e) {
			assertTrue("Invalid exception thrown", false);
		}
	}
	
	/**
	 * Test if the password has at least one lower case alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try {
			PasswordCheckerUtility.hasLowerAlpha​("ABC2005");
			assertTrue("Failure: Exception should have been thrown", false);
		} 
		catch (NoLowerAlphaException e) {
			assertTrue("Successfully thrown the NoLowerAlpha exception", true);
		}
		catch (Exception e) {
			assertTrue("Invalid exception thrown", false);
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try {
			PasswordCheckerUtility.hasDigit​("ABC!@abc");
			assertTrue("Failure: Exception should have been thrown", false);
		} 
		catch (NoDigitException e) {
			assertTrue("Successfully thrown the NoLowerAlpha exception", true);
		}
		catch (Exception e) {
			assertTrue("Invalid exception thrown", false);
		}
	}
	
	/**
	 * Test if the password has at least one special character
	 * One test should throw a NoSpecialCharacterException
	 */
	@Test
	public void testIsValidPasswordNoSpecialCharcter()
	{
		try {
			PasswordCheckerUtility.hasSpecialChar​("Abcd123");
			assertTrue("Failure: Exception should have been thrown", false);
		} 
		catch (NoSpecialCharacterException e) {
			assertTrue("Successfully thrown the NoLowerAlpha exception", true);
		}
		catch (Exception e) {
			assertTrue("Invalid exception thrown", false);
		}
	}
	
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try {
			PasswordCheckerUtility.NoSameCharInSequence​("ABC2005!!!abc");
			assertTrue("Failure: Exception should have been thrown", false);
		} 
		catch (InvalidSequenceException e) {
			assertTrue("Successfully thrown the NoLowerAlpha exception", true);
		}
		catch (Exception e) {
			assertTrue("Invalid exception thrown", false);
		}
	}
	
	/**
	 * Test if the password has between six to nine characters
	 */
	@Test
	public void testHasSixAndNineChars() {
		assertTrue(PasswordCheckerUtility.hasBetweenSixAndNineChars("Hello@123"));
		assertTrue(PasswordCheckerUtility.hasBetweenSixAndNineChars("Hello@12"));
		assertTrue(PasswordCheckerUtility.hasBetweenSixAndNineChars("ABc@123"));
		
		assertFalse(PasswordCheckerUtility.hasBetweenSixAndNineChars("ABc@123!!_"));
		assertFalse(PasswordCheckerUtility.hasBetweenSixAndNineChars("Hello@123!!"));
	}
	
	/**
	 * Test if the password is a weak password
	 * This test should throw a WeakPasswordException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try {
			PasswordCheckerUtility.isWeakPassword("AbC2005!@");
			assertTrue("Failure: Exception should have been thrown", false);
		} 
		catch (WeakPasswordException e){
			assertTrue("Successfully thrown the WeakPasswordException exception", true);
		}
		catch (Exception e) {
			assertTrue("Invalid exception thrown", false);
		}
	}
	
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 * @throws InvalidSequenceException 
	 * @throws NoSpecialCharacterException 
	 * @throws NoDigitException 
	 * @throws NoLowerAlphaException 
	 * @throws NoUpperAlphaException 
	 * @throws LengthException 
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("Hello@123"));
			assertTrue(PasswordCheckerUtility.isValidPassword("!!_123Aab"));
			assertTrue(PasswordCheckerUtility.isValidPassword("Abcd@$!!123"));
			

			assertFalse(PasswordCheckerUtility.isValidPassword("123"));
			assertFalse(PasswordCheckerUtility.isValidPassword("abcd123"));
			assertFalse(PasswordCheckerUtility.isValidPassword("Abcd123"));
			assertFalse(PasswordCheckerUtility.isValidPassword("Abcd!@#$"));
			assertFalse(PasswordCheckerUtility.isValidPassword("Abcd@$$$123"));
		} 
		
		catch (LengthException | NoUpperAlphaException | NoLowerAlphaException | NoDigitException
				| NoSpecialCharacterException | InvalidSequenceException e) {
			
			e.getMessage();
		}
		
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		
		ArrayList<String> invalidPasswords = PasswordCheckerUtility.getInvalidPasswords(passwords);
		assertEquals(5, invalidPasswords.size());
		assertEquals("123 The password must be at least 6 characters long", invalidPasswords.get(0));
		assertEquals("Abcd@$$$123 The password cannot contain more than two of the same character in sequence.", invalidPasswords.get(4));
	}
	
	
}
