package sorting_Algo;

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
			int j=0;
			for(j=i;j>=0;j--) {
				if(arr[j]>temp)
					arr[j+1]=arr[j];
				else {
					arr[j+1]=temp;
					break;
				}
			}
			if(j<0)
				arr[0]=temp;
				
		}
	}
	
	public static void main(String[] args) {
		
		int[] arr= {8,40,1,6,15,3,9};
		sort(arr, arr.length);
		
		for(int i:arr)
			System.out.print(i+" ");
	}

}
