/*
 * SYSC 2100 Algorithms and Data Structures 
 * Assignment 2: Comparing List Implementations
 * 
 * @Author: Hasan Baig
 * @Student_ID: 101032292
 * @Date: February 16 2020
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.*;
import java.util.*;
import java.lang.*;

public class CountSubstrings2{
	
	private int countArray = 0;
    private int countLinked = 0;
    
    private double arrayTime;
    private double linkedTime;
    
    ArrayList<Character> ArrayList = new ArrayList<Character>();
    LinkedList<Character> LinkedList = new LinkedList<Character>();
    
    public CountSubstrings2() {

    }
	
	public static void main(String[] args){		
		try {
			
			CountSubstrings2 count = new CountSubstrings2();
			Scanner input = new Scanner(System.in);
			
			System.out.print("Please enter the path for the input file: ");
			String file = input.next();
			
			System.out.print("Enter the pattern to look for: ");
			String pattern = input.next();
			
			input.close();
			count.comparePattern(pattern, file);
			
		} catch (IOException e){
			System.out.println(e);
			System.exit(1);			
		}		
	}
	
    /** 
     *  Method splits all words in file into tokens line by line and compares them. 
     *  Completed via ArrayList and LinkedList.
     *  
     *  @param pattern - input given by user to search through file
     *  @param file - name of file
     *  
     *  Counts the number of times pattern appears in file and runtime of arraylist vs linkedlist 
    */
    public void comparePattern(String pattern, String file) throws IOException{
        try {
        	BufferedReader reader = new BufferedReader(new FileReader(file));
            String read = reader.readLine();

            //reads and stores each char in List
            for (int index = 0; index < pattern.length(); index++) {
                ArrayList.add(pattern.charAt(index));
                LinkedList.add(pattern.charAt(index));
            }
            
            // split into tokens and count time
            while(read != null) {
                StringTokenizer obj = new StringTokenizer(read);

                while (obj.hasMoreTokens()) {
                    time(obj);
                }
                read = reader.readLine();
            }
            System.out.println("Using ArrayLists: " + countArray + " matches, derived in " + arrayTime + " milliseconds.");
			System.out.println("Using LinkedLists: " + countLinked + " matches, derived in " + linkedTime + " milliseconds.");
            
        } catch (IOException e) {
        	System.out.println(e);
			System.exit(1);
        }
    }
    /** 
     *	Method checks start/end time of program using the two different Lists
     * 
     * @param obj is the pattern broken up into tokens
     */
    private void time(StringTokenizer object) {
    	ArrayList<Character> objArrayList = new ArrayList<Character>();
    	LinkedList<Character> objLinkedList = new LinkedList<Character>();

        // Returns next token in object
        String token = object.nextToken();

        for (int index = 0; index < token.length(); index++) {
        	objArrayList.add(token.charAt(index));
        	objLinkedList.add(token.charAt(index));
        }

        //count start time for ArrayList approach
		double startTimeArray = System.currentTimeMillis();
		if(findBrute(objArrayList,ArrayList)!=-1){
			countArray++;
        }
        //count end time for ArrayList approach
		double endTimeArray = System.currentTimeMillis();
		arrayTime = arrayTime + (endTimeArray-startTimeArray);

		//count start time for LinkedList approach
		double timeStartList = System.currentTimeMillis();
		if(findBrute(objLinkedList,LinkedList)!=-1){
			countLinked++;
        }
        //count end time for LinkedList approach
		double timeEndList = System.currentTimeMillis();
		linkedTime = linkedTime + (timeEndList-timeStartList);


    }
	
	/*
	 * Returns the lowest index at which substring pattern begins in text (or
	 * else -1).
	 */

	private static int findBrute(List<Character> text, List<Character> pattern) {
			int n = text.size();
			int m = pattern.size();
			for (int i = 0; i <= n - m; i++) { // try every starting index 
								     // within text
				int k = 0; // k is index into pattern
				while (k < m && text.get(i + k) == pattern.get(k))
					// kth character of pattern matches
					k++;
				if (k == m) // if we reach the end of the pattern,
					return i; // substring text[i..i+m-1] is a match
			}
			return -1; // search failed
	}

	
}
