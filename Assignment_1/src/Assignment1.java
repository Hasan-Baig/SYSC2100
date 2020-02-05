/*
 * SYSC 2100 Algorithms and Data Structures 
 * Assignment 1: Recursion
 * 
 * @Author: Hasan Baig
 * @Student_ID: 101032292
 * @Date: January 31 2020
 * 
 */

public class Assignment1 {

	/*
	 * 1. Write a Java method for the Spock problem c(n, k) seen in class. 
	 * Include output code that shows the actual sequence of calls that are 
	 * made and the value that they will return when the method is executed. 
	 * 
	 * @param n - number of planets in Unexplored solar system
	 * @param k - number that we can visit
	 * @return number of groups of k planets chosen from n
	 * 
	 */
	public static int c(int n, int k) {
		if(n==k) {
			//Base Case 1 - time is available to visit all the planets
			return 1;
		} else if (k==0) {
			//Base Case 2 - no time is available to visit any planet
			return 1;
		} else if (k==1) {
			//Base Case 3 - time is available to visit only one planet
			return n;
		} else if (k>n) {
			//Base Case 4 - impossible case
			return 0;
		} else {
			//Equation
            return c((n-1),(k-1)) + c((n-1),k);
		}
	}
	
	/*
	 * 2. Write a Java method for the problem of Organizing a Parade as presented 
	 * in class. Name your method P.
	 * 
	 * F(n) be the number of parades of length n that end with a float: F(n) = P(n-1)
	 * B(n) be the number of parades of length n that end with a band: B(n) = F(n-1) = P(n-2)
	 * P(n) be the number of ways to organize a parade of length n: P(n) = F(n)+B(n) = P(n-1)+P(n-2)
	 * 
	 * @param n - length of parade
	 * @return number of ways to organize a parade of length n
	 * 
	 */
    public static int P(int n) {
        if (n==1) {
            //Base Case 1 - parades of length 1 are float and band
            return 2;
        } else if (n==2) {
        	//Base Case 2 - parades of length 2 are float-float, band-float, and float-band
            return 3;
        } else {
        	//Equation for n>2
            return P(n-1) + P(n-2);
        }
    }
    
	/*
	 * 3. Write a recursive Java method writeLine that writes a character repeatedly to form 
	 * a line of n characters. For example, writeLine(‘*’,5) produces the line *****. Then write 
	 * a recursive method writeBlock that uses writeLine to write m lines of n characters each. 
	 * 
	 * @param ch - character
	 * @param n - number of times to print ch
	 * @param m - number of lines of n characters
	 * 
	 */
    public static void writeLine(char ch, int n) {
    	if(n==1) {
    		//Base Case
    		System.out.print(ch);
    	} else {
    		System.out.print(ch);
    		writeLine(ch,(n-1));
    	}
    }
    
    public static void writeBlock(char ch, int n, int m) {
    	if(m==1) {
    		//Base Case
    		writeLine(ch,n);
    		System.out.println();
    	} else {
    		writeLine(ch,n);
    		System.out.println();
    		writeBlock(ch,n,(m-1));
    	}
    }
    
	/*
	 * 4. Write a recursive Java method that writes the digits of a positive decimal integer in
	 * reverse order. Name your method reverseDigits
	 * 
	 * @param number - input positive decimal integer to printed in reverse
	 * 
	 */
    public static void reverseDigits(int number) {
    	String num = Integer.toString(number);
    	if (num.length()==1) {
    		//Base Case - number is of size 1
    		System.out.print(num);
    	} else {
    		//Print last character of String num
    		System.out.print(num.substring(num.length()-1));
    		//num minus last character and changed back to integer
    		reverseDigits(Integer.parseInt(num.substring(0,(num.length()-1))));
    	}
    }
    
	/*
	 * 5. Implement the recursive binary search algorithm presented in class for an array of
	 * strings. Name your method myBinarySearch. 
	 * 
	 * Precondition: 0 <= first, last <= SIZE-1, where SIZE = max size of array and array is sorted from first to last
	 * Postcondition: If value is in array, method returns index of array item the equals value,
	 * otherwise returns -1.
     * 
     * @param anArray - array of strings
     * @param first - first index
     * @param last - last index
     * @param value - value of index looked at
	 * 
	 */
    public static int myBinarySearch(String[] anArray, int first, int last, String value) {
    	while (first < last) {
        	//finds middle element index of array 
        	int mid = (first+last)/2;
        	
        	if (value.compareTo(anArray[mid])<0) {
        		//if value in first half of array, iterate through that part
        		return myBinarySearch(anArray,first,mid,value);
        	} else if(value.compareTo(anArray[mid])>0) {
        		//if value in second half of array, iterate through that part
        		return myBinarySearch(anArray,mid,last,value);
        	} else {
        		//if value equal mid
        		return mid;
        	}
    	}
    	// value not in empty array
    	return -1;
    }
    
    public static void main (String[] args) {
		//System.out.println(c(3,2));
		//System.out.println(c(2,1));
		//System.out.println(c(1,0));
		//System.out.println(c(1,1));
		//System.out.println(c(2,2));
    	//System.out.println(P(3)); 
    	//writeLine('*',5);
    	//writeBlock('*',5,3);
    	//reverseDigits(677657579);
        //String anArray[] = {"apple", "baby", "california", "digit"};
        //System.out.println(myBinarySearch(anArray, 0, anArray.length, "digit"));
        //System.out.println(myBinarySearch(anArray, 0, anArray.length, "apple"));
        //System.out.println(myBinarySearch(anArray, 0, 0, "apple"));
	}
}
