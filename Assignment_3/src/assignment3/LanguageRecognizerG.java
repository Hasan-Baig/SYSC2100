package assignment3;
import java.util.ArrayList;

public class LanguageRecognizerG {
	
	private String userInput;
	ArrayList<Character> inputList = new ArrayList<Character>();
	
    /** 
     *	Method assigns user's String input to an ArrayList where each node contains a Character
     * 
     * @param input is the user's String input
     */
	public LanguageRecognizerG(String input) {
		userInput = input;
		for (char i : input.toCharArray()) {
			inputList.add(i);
	    }
	}
	
    /** 
     *	Method recursively determines if inputList contains the correct Characters to make a valid word
     * 
     * @param inputList is an ArrayList of characters which make up the user's input
     * @output true if input is valid
     * @output false if input is invalid
     */
	public boolean recursiveRecogG(ArrayList<Character> inputList) {
		// if input is empty (base case)
		if (inputList.size() == 0) {
			return true;
		} 
		
		// if input is <E> (base case)
		else if (inputList.size() == 1) {
			if (inputList.get(0) == '&' || inputList.get(0) == '#') {
				return true;
			}
		} 
		
		// if input is <V> <E> (base case)
		else if (inputList.size() == 2) {
			if ((inputList.get(0) == 'W' || inputList.get(0) == 'A') && (inputList.get(1) == '&' || inputList.get(1) == '#')) {
				return true;
			}
			if ((inputList.get(0) == '#' || inputList.get(0) == '&') && (inputList.get(1) == 'W' || inputList.get(1) == 'A')) {
				return true;
			}
		} 
		
		// if input is <E> <G> <V>
		else {
			if ((inputList.get(0) == '&' || inputList.get(0) == '#') && (inputList.get(inputList.size()-1) == 'W' || inputList.get(inputList.size()-1) == 'A')) {
				inputList.remove(0);
				inputList.remove(inputList.size()-1);
				return recursiveRecogG(inputList);
			}
		}
		
		return false;
	}
	
    /** 
     *	Method prints output statement if the user input is a valid or invalid word, in correspondence to the grammar of the G language
     */
	public void recursivePrintG() {
		boolean print = recursiveRecogG(inputList);
		if (print) {
			System.out.println("Recursion: Word “" + userInput + "” IS a word of the G language");
		} else {
			System.out.println("Recursion: Word “" + userInput + "” is NOT a word of the G language");
		}
	}
}
