package searching_Problems;

import java.util.Arrays;

public class Search_Infinite_SortedArray {
	
	//must be done in O(logn)
	public static int searchInfinite(int[] arr, int key) {
		
		//we are taking a range such as 0 to 1.
		//and we are expanding this range exponentially until
		//the key falls under the range
		int low=0,high=1;
		
		while(arr[high]<key)
		{
			//we are increasing the range by 2
			low=high;
			high*=2;
		}
		//if the key falls under the specified range then do 
		//a binarysearch and return it's index
		return BinarySearch.search(arr, low, high, key);
	}
	
	public static void main(String[] args) {
		
		int[] arr= {5,6,9,2,3,10,12};
		Arrays.sort(arr);
		
		System.out.println(searchInfinite(arr, 3));
	}

}
