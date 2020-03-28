package assignment4;

public class BubbleSort {
	
	public <T extends Comparable<? super T>> BubbleSort (T[] theArray, int n) {
		try {
			boolean sorted = false; // false when swaps occurs

			for(int pass = 1; (pass < n) && !sorted; ++pass) {
				//assume sorted
				sorted = true;

				for(int index = 0; index < n-pass; ++index) {
					int nextIndex = index + 1;
					
					if(theArray[index].compareTo(theArray[nextIndex])>0) {
						//swap theArray[index] with theArray[nextIndex]
						T temp = theArray[index];
						theArray[index] = theArray[nextIndex];
						theArray[nextIndex] = temp;
						sorted = false; // signal exchange
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
