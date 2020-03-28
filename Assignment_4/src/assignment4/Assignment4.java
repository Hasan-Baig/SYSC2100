/*
 * SYSC 2100 Algorithms and Data Structures 
 * Assignment 4: Queues and Sorting
 * 
 * @Author: Hasan Baig
 * @Student_ID: 101032292
 * @Date: March 28 2020
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
			// largest item in theArray (last item)
			int largest = n-1;
			
			// find largest item in theArray descending through array
			for(int currIndex = n-2; currIndex >= 0; currIndex--) {
				if(theArray[currIndex].compareTo(theArray[largest])>0) {
					largest = currIndex;
				}
			}
			
			// swap largest item with the n-1 element in theArray			
			if(largest != n-1) {
				T temp = theArray[largest];
				theArray[largest] = theArray[n-1];
				theArray[n-1] = temp;
			}
			
			if(n>2) {
				recursiveSelectionSort(theArray, n-1);
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
			
			boolean sorted = true; // true for recursion
			
			for(int index = n-1; index > 0; index--) {
				int lastIndex = index-1;
				
				// swap current index with previous element if smaller in value
				if(theArray[index].compareTo(theArray[lastIndex])<0) {
					//swap theArray[index] with theArray[lastIndex]
					T temp = theArray[index];
					theArray[index] = theArray[lastIndex];
					theArray[lastIndex] = temp;
					
					sorted = false; // false when swaps occurs
				}
				
				if(sorted != true) {
					recursiveBubbleSort(theArray, n-1);
				}
			}	
			
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
