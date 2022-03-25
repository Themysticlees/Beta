package searching_Problems;

import java.util.Arrays;

/*
 * Given an array A of N length. 
 * We need to calculate the next greater element for each element in a given array. 
 * If the next greater element is not available in a given array then we need to fill 
 * -10000000 at that index place.
 * 
 * Input : arr[] = {13, 6, 7, 12}
	Output : _ 7 12 13 
	Explanation:
	Here, at index 0, 13 is the greatest value 
	in given array and no other array element 
	is greater from 13. So at index 0 we fill 
	'-10000000'.
 */
public class Smallestgreaterelements {
	
	public static int[] greaterElement (int arr[], int n) {
        // Complete the function
        
        int[] res=new int[n];
        int[] sorted = arr.clone();
        
        Arrays.sort(sorted);
        
        for(int i=0;i<n;i++){
            
            int low=0,high=n-1;
            int index=0;
            //for each element we are searching for an element in the sorted array 
            //which is just bigger than it using binary search
            while(low<=high){
                int mid=(low+high)/2;
                
                //if we get a bigger number
                //we decrease the end pointer so that we can get a smaller number which is greater than arr[i]
                //and storing the that particular index incase no other number is found
                if(sorted[mid]>arr[i])
                {
                    high=mid-1;
                    index=mid;
                }
                else
                    low=mid+1;
            }
            //if no bigger number is present in the sorted array, then the low must have got bigger than n
            if(low>=n)
                res[i]=-10000000;
            else
                res[i]=sorted[index];
        }
        
        //Brute Force
        // for(int i=0;i<n;i++){
        //     int max=Integer.MAX_VALUE;
            
        //     for(int j=0;j<n;j++){
        //         if(arr[j]>arr[i] && arr[j]<max)
        //             max=arr[j];
        //     }
            
        //     if(max==Integer.MAX_VALUE)
        //         max=-10000000;
        //     res[i]=max;
        // }
        
        
        return res;
    }

}
