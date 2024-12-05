import java.util.ArrayList;

public class Driver {
	
	public static void main (String args[]) {
		MorseCodeTree tree = new MorseCodeTree();
		
		System.out.println(tree==null);
		
		ArrayList<String> list = tree.toArrayList();
		System.out.println("size of the list " + list.size());
		for (int i =0 ; i < list.size(); i++) {
			System.out.print(list.get(i)+ " ");
		}
		
		
		String s =MorseCodeConverter.convertToEnglish(".... . .-.. .-.. --- / .-- --- .-. .-.. -..");
		System.out.println(s);
	}

}
