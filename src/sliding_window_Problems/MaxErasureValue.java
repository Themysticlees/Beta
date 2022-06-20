package sliding_window_Problems;
import java.util.*;
/*
 * You are given an array of positive integers nums and want to erase a subarray containing 
 * unique elements. The score you get by erasing the subarray is equal to the sum of its elements.
 * Return the maximum score you can get by erasing exactly one subarray.
 * 
 *  Example 1:

	Input: nums = [4,2,4,5,6]
	Output: 17
	Explanation: The optimal subarray here is [2,4,5,6].
	
	Example 2:
	
	Input: nums = [5,2,1,2,5,2,1,2,5]
	Output: 8
	Explanation: The optimal subarray here is [5,2,1] or [1,2,5].
 */
public class MaxErasureValue {
	
	//We'll use sliding window to determine the subarray and a set to check the unique elements
	
	public int maximumUniqueSubarray(int[] nums) {
        
        int n=nums.length;
        int left=0,right=0;
        
        //for calculating the max erasure value
        int max=-1;
        int currsum=0;
        
        Set<Integer> set = new HashSet<>();
        
        while(left<=right && right<n){
            
        	//if the set contains the current elemenet
        	//then subtract arr[left] from the curr sum and remove arr[left] from the set
        	//do this until we have removed the current element from the set
            while(set.contains(nums[right])){
                currsum-=nums[left];
                set.remove(nums[left]);
                left++;    
            }
            
            //add the element to curr sum and add it in the set
            currsum+=nums[right];
            set.add(nums[right]);
            right++;
            
            //store the max value calculated so far
            max=Math.max(max,currsum);
        }
        
        return max;
    }

}
