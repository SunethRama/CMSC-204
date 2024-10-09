import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NotationTestStudent {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testConvertInfixToPostfix() {
		 assertEquals("53+", Notation.convertInfixToPostfix("5+3"));
	     assertEquals("82/", Notation.convertInfixToPostfix("8/2"));
	     assertEquals("53+2*", Notation.convertInfixToPostfix("(5+3)*2"));
	     assertEquals("543*+", Notation.convertInfixToPostfix("5+(4*3)"));
	     assertEquals("34+56-*", Notation.convertInfixToPostfix("(3+4)*(5-6)"));
	     assertEquals("234*+82/-", Notation.convertInfixToPostfix("(2+(3*4))-(8/2)"));
	}

	@Test
	void testConvertPostfixToInfix() {
		  
        assertEquals("(5+3)", Notation.convertPostfixToInfix("53+"));
        assertEquals("(8/2)", Notation.convertPostfixToInfix("82/"));
        assertEquals("((5+3)*2)", Notation.convertPostfixToInfix("53+2*"));
        assertEquals("(5+(4*3))", Notation.convertPostfixToInfix("543*+"));
        assertEquals("((3+4)*(5-6))", Notation.convertPostfixToInfix("34+56-*"));
        assertEquals("((2+(3*4))-(8/2))", Notation.convertPostfixToInfix("234*+82/-"));
	}

	@Test
	void testEvaluatePostfixExpression() {
		
		 assertEquals(8.0, Notation.evaluatePostfixExpression("53+"));
	     assertEquals(4.0, Notation.evaluatePostfixExpression("82/"));
	     assertEquals(16.0, Notation.evaluatePostfixExpression("53+2*"));
	     assertEquals(17.0, Notation.evaluatePostfixExpression("543*+"));
	     assertEquals(10.0, Notation.evaluatePostfixExpression("234*+82/-"));
	}
	
	@Test
	void testThatInvalidInfixExpressionThrowsException() {
		try {
			Notation.convertInfixToPostfix("5 + (3 * 2");
			assertTrue("Should have thrown the exception", false);
		}
		catch (InvalidNotationFormatException e) {
			assertTrue("Exception thrown successfully", true);
		}
		
		try {
			Notation.convertInfixToPostfix("(5 + 3)) * 2");
			assertTrue("Should have thrown the exception", false);
		}
		catch (InvalidNotationFormatException e) {
			assertTrue("Exception thrown successfully", true);
		}
		
		try {
			Notation.convertInfixToPostfix("(5 + 3 * 2");
			assertTrue("Should have thrown the exception", false);
		}
		catch (InvalidNotationFormatException e) {
			assertTrue("Exception thrown successfully", true);
		}
	}
	
	@Test
	void testThatInvalidPrefixExpressionThrowsException() {
		try {
			Notation.convertPostfixToInfix("53+2");
			assertTrue("Should have thrown the exception", false);
		}
		catch (InvalidNotationFormatException e) {
			assertTrue("Exception thrown successfully", true);
		}
		
		try {
			Notation.convertPostfixToInfix("53+*");
			assertTrue("Should have thrown the exception", false);
		}
		catch (InvalidNotationFormatException e) {
			assertTrue("Exception thrown successfully", true);
		}
		
		try {
			Notation.convertPostfixToInfix("53+*2/");
			assertTrue("Should have thrown the exception", false);
		}
		catch (InvalidNotationFormatException e) {
			assertTrue("Exception thrown successfully", true);
		}
		
	}
	
	@Test
	void testThatInvalidEvaluationThrowsException() {
		try {
			Notation.evaluatePostfixExpression("53+2*+");
			assertTrue("Should have thrown the exception", false);
		}
		catch (InvalidNotationFormatException e) {
			assertTrue("Exception thrown successfully", true);
		}
		
		try {
			Notation.evaluatePostfixExpression("53+2");
			assertTrue("Should have thrown the exception", false);
		}
		catch (InvalidNotationFormatException e) {
			assertTrue("Exception thrown successfully", true);
		}
		
		try {
			Notation.evaluatePostfixExpression("123+*-");
			assertTrue("Should have thrown the exception", false);
		}
		catch (InvalidNotationFormatException e) {
			assertTrue("Exception thrown successfully", true);
		}
		
	}

}
