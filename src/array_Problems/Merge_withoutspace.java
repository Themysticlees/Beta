package array_Problems;
import java.util.*;

public class Merge_withoutspace {
	
	//utility function for swaping two elements
		static void swap(int[] arr1, int[] arr2, int i, int j) {
			int temp=arr1[i];
			arr1[i]=arr2[j];
			arr2[j]=temp;
		}
		
		//we are using the gap method
		//where we'll compare the elements in the particular gap and swap accordingly
		//we'll reduce the gap by 2 untill gap becomes less than 1
		static void merge(int[] arr1, int[] arr2, int m, int n) {
			
			//calculating gap : m+n/2. we take the ceil value if we divide an odd number
			int gap=(int)Math.ceil(n+(m-n)/2);
			
			while(gap>0) {
				//initializing two pointers
				int i=0,j=i+gap;
				
				//There will be 3 cases
				//1. when both the pointers are in the first array
				//2. when both the pointers are in two different arrays
				//3. when both the pointers are in the second array
				
				//1st case
				while(i<m && j<m) {
					//we are checking untill the pointers go over range.
					if(arr1[i]>arr1[j])
						swap(arr1,arr1,i,j);
					i++;j++;
				}
				
				//2nd case, we are subtracting the second pointer by m(size of 1st array)
				//to get the correct indexes of the second array
				while(i<m && j-m<n) {
					if(arr1[i]>arr2[j-m])
						swap(arr1,arr2,i,j-m);
					i++;j++;
				}
				
				//3rd case when both the pointers are in 2nd array
				while(i-m<n && j-m<n) {
					if(arr1[i-m]>arr2[j-m])
						swap(arr2,arr2,i-m,j-m);
					i++;j++;
				}
				
				//dividing the gap by 2
				gap=gap/2;
				
			}
			
			//sorting the arrays once more
			Arrays.sort(arr1);
			Arrays.sort(arr2);
		}
	    
	    public static void main(String[] args) {
			
	    	int[] arr1= {5,4,6,7,9};
	    	int[] arr2= {1,2,3};
	    	
	    	merge(arr1,arr2,arr1.length,arr2.length);
	    	
	    	for(int i:arr1)
				System.out.print(i+" ");
			for(int i:arr2)
				System.out.print(i+" ");
		}

}
