package array_Problems;
import java.util.*;

public class Merge_withoutspace {
	
	public static void swap(int arr1[], int arr2[],int i, int j)
	{
		int temp=arr1[i];
        arr1[i]=arr2[j];
        arr2[j]=temp;
	}
	
	public static void merge(int arr1[], int arr2[], int m, int n) {
        // code here
        
        int gap=(m+n)/2;
        
        while(gap>=1)
        {
            int i=0;
            int j=gap;
            
            
            while(j<m+n)
            {
	            if(j>=m)
	            {
	            	int j1=j-m;
	            	if(i>=m)
	            	{
	            		int i1=i-m;
	            		if(arr2[i1]>arr2[j1])
	            			swap(arr2,arr2,i1,j1);
	            	}
	            	else
	            	{
	            		if(arr1[i]>arr2[j1])
	            			swap(arr1,arr2,i,j1);
	            	}
	            }
	            else
	            {
	            	if(arr1[i]>arr1[j])
	            	swap(arr1,arr1,i,j);
	            }
	            
	            i++;
	            j++;
            }
            
            gap=gap/2;
        }
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
	}

	public static void main(String[] args) {
			
		int arr1[] = {7, 9, 9, 10, 11, 11, 13, 14, 17, 19};
		int arr2[] = {1, 1, 4, 5, 8, 11, 13, 16, 19, 19};
		
		merge(arr1,arr2,arr1.length,arr2.length);
		
		for(int i:arr1)
			System.out.println(i);
		for(int i:arr2)
			System.out.println(i);
		
	}

}
