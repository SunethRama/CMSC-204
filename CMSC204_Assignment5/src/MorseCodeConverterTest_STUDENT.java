import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MorseCodeConverterTest_STUDENT {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConvertToEnglishString() {
		assertEquals(MorseCodeConverter.convertToEnglish("-- . .-. .-. -.-- / -.-. .... .-. .. ... - -- .- ...")
					,"merry christmas");
		assertEquals(MorseCodeConverter.convertToEnglish("--. --- --- -.. / -- --- .-. -. .. -. --."),
				"good morning");
		assertEquals(MorseCodeConverter.convertToEnglish(".... .- .--. .--. -.-- / -. . .-- / -.-- . .- .-."),
				"happy new year");
					
	}

	@Test
	public void testConvertToEnglishFile() {
		File file = new File("src/DaisyDaisy.txt");
		try {
			assertEquals(MorseCodeConverter.convertToEnglish(file)
					,"im half crazy all for the love of you");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		file = new File("src/Daisy.txt");
		try {
			assertEquals(MorseCodeConverter.convertToEnglish(file)
					,"give me your answer do");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		file = new File("src/LoveLooksNot.txt");
		try {
			assertTrue(MorseCodeConverter.convertToEnglish(file)
			.equalsIgnoreCase("LOVE LOOKS NOT WITH THE EYES BUT WITH THE MIND"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
