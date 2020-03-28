package assignment4;

public class SelectionSort {
	
	public <T extends Comparable<? super T>> SelectionSort (T[] theArray, int n) {
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
	
}
