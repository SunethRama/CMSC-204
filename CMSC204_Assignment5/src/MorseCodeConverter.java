import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * MorseCodeConverter class
 * @author Suneth Ramawickrama
 */
public class MorseCodeConverter {

	private static MorseCodeTree tree = new MorseCodeTree();;
	
	
	/**
	 * Constructor
	 */
	public MorseCodeConverter() {
	}
	
	
	/**
	 * This method prints the letters in the tree according the LNR traversal order
	 * @return an arrayList of the LNR order
	 */
	public static String printTree(){
		ArrayList<String> list = tree.toArrayList();
		String traversalList = "";
		
		for (int i =0 ; i < list.size(); i++) {
			traversalList = traversalList + list.get(i) + " ";
		}
		
		return traversalList.substring(0, traversalList.length()-1);
	}
	
	
	/**
	 * Convert a string in morse code to English
	 * @param morseCodeString the morse code string
	 * @return the converted English text 
	 */
	public static String convertToEnglish(String morseCodeString) {
		
		String convertedCode = ""; 
		
		String[] wordList = morseCodeString.split("/");
		String[] letterList; 
		
		for (int i=0 ; i < wordList.length ; i++) {
			
			letterList = wordList[i].split(" ");
	
			for (int j=0 ; j < letterList.length ; j++) {
				
				if (!letterList[j].isEmpty()) {
					convertedCode += tree.fetch(letterList[j]);
				}
			}
			
			convertedCode += " ";
		}
		
		return convertedCode.substring(0, convertedCode.length()-1);
	}

	
	/**
	 * Convert a string in morse code read from a file to English
	 * @param file the file to read from
	 * @return the converted English text
	 * @throws FileNotFoundException
	 */
	public static String convertToEnglish(File file) throws FileNotFoundException{
		
		String code = "";
		try (Scanner inputFile = new Scanner(file)) {
		
			while(inputFile.hasNext()) {
				 code = code + inputFile.next() + " ";
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 

		return convertToEnglish(code);
	}
}
