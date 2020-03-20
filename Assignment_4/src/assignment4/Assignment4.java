/*
 * SYSC 2100 Algorithms and Data Structures 
 * Assignment 4: Queues and Sorting
 * 
 * @Author: Hasan Baig
 * @Student_ID: 101032292
 * @Date: March 22 2020
 * 
 */
package assignment4;
import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Stack;


public class Assignment4 {

	private static Queue<Character> q2 = new LinkedList<Character>();
	private static Stack<Character> s2 = new Stack<Character>();
	
	private static Queue<Character> q3 = new LinkedList<Character>();

	/** 
     *  Method recursively performs Selection Sort on an array of elements into ascending order.
     *  
     *  @param theArray - array of unsorted elements
     *  @param n - size of array
    */
	public static <T extends Comparable<? super T>> void recursiveSelectionSort (T[] theArray, int n) {
		try {
			//last = index of last item in sub-array of items to be sorted
			for(int last = n-1; last >= 1; last--) {
				
				//index of largest item found so far
				int indexSoFar = 0;
				
				for(int currIndex = 1; currIndex < last+1; ++currIndex) {
					if(theArray[currIndex].compareTo(theArray[indexSoFar])>0) {
						indexSoFar = currIndex;
					}
				}
				
				// largest item in theArray
				int largest = indexSoFar;
				
				//swap largest item theArray[largest] with theArray[last]
				T temp = theArray[largest];
				theArray[largest] = theArray[last];
				theArray[last] = temp;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	/** 
     *  Method recursively performs Bubble Sort on an array of elements into ascending order.
     *  
     *  @param theArray - array of unsorted elements
     *  @param n - size of array
    */
	public static <T extends Comparable<? super T>> void recursiveBubbleSort (T[] theArray, int n) {
		try {
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/** 
     *  Method is recognition algorithm for the language:
     *  L={w$w’: w is a possibly empty string of characters other than $, w’ = reverse(w)} 
     *  
     *  Method uses both a queue & stack and returns true if str in in language L.
     *  
     *  @param str - input given by user to check if word is from language L
     *  @output true or false depending if word is in language
    */
	public static boolean isInLanguage (String str) {
		boolean charSame = true;
		
		try{
			// Input is empty
			if(str.equals("")) {
				return true;
			}
			
			int i=0;
			
			// Add before $ to queue
			while(i<str.length()) {
				if(str.charAt(i) == '$') {
					break;
				}
				q2.add(str.charAt(i));
				++i;
			}
			
			// Skip the $
			++i;
			
			// Add after $ to stack
			while(i<str.length()) {
				s2.push(str.charAt(i));
				++i;
			}
			
			// Compare the queue char with the stack char
			while(!q2.isEmpty() && charSame) {
				try {
					if(q2.remove() != s2.pop()) {
						charSame=false;
					}
				} catch (EmptyStackException e) { // Stack is empty
					System.out.println(e);
				} catch (NoSuchElementException e) { // Queue is empty
					System.out.println(e);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return charSame;
	}
	
	/** 
     *  Method splits all characters in str into a queue (reference-based: linked list) 
     *  and removes spaces, returning only the digits.
     *  
     *  @param str - input given by user of characters containing only spaces or digits
     *  @output integer containing only the digits from str
    */
	public static int convertToNumber (String str) {
		String convert = "";
		try{
			// Input is empty or only contains spaces
			if(str.isEmpty() || str.matches("\\s+")) {
				System.out.println("User input is empty");
				return 0;
			}
			
			// Add each char of str to queue if not " "
			for(int i=0; i<str.length(); i++) {
				if (str.charAt(i) != ' ') {
					q3.add(str.charAt(i));
				}
			}
		
			// Add each queue element to return integer
			while(!q3.isEmpty()) {
				convert += q3.remove();
			}
		} catch (NumberFormatException e) {
			System.out.println("User input is empty");
		} catch (Exception e) {
			System.out.println(e);
		} 
		
		return Integer.parseInt(convert);
	}
}
