package sliding_window_Problems;
import java.util.*;

/*
 * Given an array arr[] of n integers. Count the total number of sub-array having 
 * total distinct elements same as that of total distinct elements of the original array.
 * 
 *  Input:
	N=5
	arr[] = {2, 1, 3, 2, 3} 
	Output: 5
	Explanation:
	Total distinct elements in array is 3
	Total sub-arrays that satisfy the condition
	are:
	Subarray from index 0 to 2
	Subarray from index 0 to 3
	Subarray from index 0 to 4
	Subarray from index 1 to 3
	Subarray from index 1 to 4
 */
public class EquivalentSubArrays {
	
	/*
	 * We'll use sliding window, set and hashmap for this problem
	 * First we'll calculate the distinct elements using set
	 * Then initialize three variables left, right and window size
	 * increase right until the window contains all the distinct elements
	 */
	
	
	// Method to calculate distinct sub-array 
    static int countDistinctSubarray(int arr[], int n) 
    { 
        Set<Integer> set = new HashSet<>();
        
        for(int i=0;i<n;i++)
            set.add(arr[i]);
        
        int k=set.size();
        int left=0,right=0,winsize=0,count=0;
        
        Map<Integer,Integer> map = new HashMap<>();
        
        while(left<=right){
            
            if(winsize<k && right<n){
                map.putIfAbsent(arr[right],0);
                
                map.put(arr[right],map.get(arr[right])+1);
                winsize=map.size();
                right++;
                
            }
            
            else if(winsize==k){
            	count+=n-right+1;
            	
                map.put(arr[left],map.get(arr[left])-1);
                if(map.get(arr[left])==0) {
                	map.remove(arr[left]);
                    winsize--;
                }
                left++;
            }
            else
            	break;
            
        }
        
        return count;
        
    }
    
    public static void main(String[] args) {
		
    	int arr[] = {2,2};
		System.out.println(countDistinctSubarray(arr, arr.length));
	}

}
