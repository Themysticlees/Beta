package searching_Problems;

import java.util.Arrays;

public class BinarySearch {
	
	public static int search(int[] arr, int low, int high, int search) {
		
		int mid=(low+high)/2;
		
		if(arr[mid]==search)
			return mid;
		
		else if(search>arr[mid])
			return search(arr,mid+1,high,search);
		else
			return search(arr,low,mid-1,search);
	}
	
	public static void main(String[] args) {
		
		int[] arr= {5,6,9,2,3,10,12};
		
		Arrays.sort(arr);
		
		System.out.println(search(arr, 0, arr.length-1,9));
		
	}

}
