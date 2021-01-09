package MorseCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This is the class MorseCodeConverter where morse code is translated to English
 * 
 * Morse Code Converter Class
 * 
 * @author Diego Amores
 *
 */

public class MorseCodeConverter {
	private static MorseCodeTree morseCodeTree = new MorseCodeTree();
	
	/**
	 * Returns a string with all the data in the tree in LNR order with an space in between them. 
	 * Uses the toArrayList method in MorseCodeTree It should return the data in this order:
	 * "h s v i f u e l r a p w j b d x n c k y t z g q m o"
	 * Note the extra space between j and b - that is because there is an empty string that is the root, 
	 * and in the LNR traversal, the root would come between the right most child of the left tree (j) 
	 * and the left most child of the right tree (b). 
	 * This is used for testing purposes to make sure the MorseCodeTree has been built properly 
	 * @return The data in the tree in LNR order separated by a space.
	 */
	
	public static String printTree() {
		String printTree = "";
		ArrayList<String> morseCodeList = morseCodeTree.toArrayList();
		
		for(int i = 0; i < morseCodeList.size(); i++) {
			printTree += morseCodeList.get(i) + " ";
		}
	
		return printTree;
	}
	
	/**
	 * Converts Morse code into English. Each letter is delimited by a space (� �). Each word is delimited by a �/�.
	 * Example:
	 * code = ".... . .-.. .-.. --- / .-- --- .-. .-.. -.."
	 * string returned = "Hello World" 
	 * @param code The morse code 
	 * @return The English translation
	 */
	
	public static String convertToEnglish(String code) {
		String[] morseCodeWord = code.split(" ");
		ArrayList<String> list = new ArrayList<String>();
		String convertToEnglish = "";
		
		for(int i = 0; i < morseCodeWord.length; i++) {
			list.add(morseCodeWord[i]);
			
			if(list.get(i).equals("/"))
				convertToEnglish += " ";
			else
				convertToEnglish += morseCodeTree.fetch(list.get(i));
		}
	
		return convertToEnglish;
	}
	
	/**
	 * Converts a file of Morse code into English Each letter is delimited by a space (� �). Each word is delimited by a �/�.
	 * Example:
	 * a file that contains ".... . .-.. .-.. --- / .-- --- .-. .-.. -.."
	 * string returned = "Hello World" 
	 * @param codeFile Name of the File that contains Morse Code 
	 * @return The English translation of the file 
	 * @throws FileNotFoundException Throws if file is not found
	 */
	
	public static String convertToEnglish(File codeFile) throws FileNotFoundException {
		String code = "";
		Scanner scan = new Scanner(codeFile);
		
		while(scan.hasNextLine()) {
			code += scan.nextLine();
		}
		
		scan.close();
		
		String[] morseCodeWord = code.split(" ");
		ArrayList<String> list = new ArrayList<String>();
		String convertToEnglish = "";
		
		for(int i = 0; i < morseCodeWord.length; i++) {
			list.add(morseCodeWord[i]);
			
			if(list.get(i).equals("/"))
				convertToEnglish += " ";
			else
				convertToEnglish += morseCodeTree.fetch(list.get(i));
		}
	
		return convertToEnglish;
	}
}