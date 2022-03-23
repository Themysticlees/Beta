package sorting_Problems;

public class InsertionSort {
	
	public static void sort(int[] arr, int n) {
		//we keep a sorted window and compare each index with that window
		//8|40,1,6,15,3,9 = in the 1st pass only the first index is in the window
		//we store the current element which is 40 in temp
		//we compare 40 with the last element in the window, if it is smaller then swap
		//keep comparing until the current element is more than an element in the sorted window or
		//until the loop ends
		//8,40|1,6,15,3,9
		//Repeat the steps
		for(int i=0;i<n-1;i++) {
			int temp=arr[i+1];
			int j=i;
			
			//here we are comparing with with all the elements in the sorted window
			while(j>=0 && arr[j]>temp)
			{
				arr[j+1]=arr[j];
				j--;
			}
			
			//if an element is smaller or j becomes less than zero, i,e we have no elements to compare
			//thus put the temp in j+1 since in j we have the element which we were comparing with.
			arr[j+1]=temp;
		}
	}
	
	public static void main(String[] args) {
		
		int[] arr= {8,40,1,6,15,3,9};
		sort(arr, arr.length);
		
		for(int i:arr)
			System.out.print(i+" ");
	}

}
