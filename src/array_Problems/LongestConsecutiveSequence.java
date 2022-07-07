package array_Problems;
import java.util.*;
/*
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * You must write an algorithm that runs in O(n) time.
 *  Example 1:

	Input: nums = [100,4,200,1,3,2]
	Output: 4
	Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
	Example 2:
	
	Input: nums = [0,3,7,2,5,8,4,6,0,1]
	Output: 9
 */

public class LongestConsecutiveSequence {
	
	//So basically we have to find the longest consecute sequence
	//The numbers need not be in consecutive indexes
	//Approach : Use a set to store all the numbers so that we can easily access them in O(1)
	//Then run a loop for the array, for every element (i) check if the prev element (i-1) and 
	//next element(i+1) is present.
	public static int longestConsecutive(int[] nums) {
        
		//for storing the elements
        Set<Integer> set = new HashSet<>();
        
        if(nums.length==0)
            return 0;
            
        for(int i:nums)
            set.add(i);
        
        //1 since atleast 1 element will be there
        int max=1;
        
        for(int i:nums){
            
        	//the next and prev consecutive element
            int nextVal=i+1;
            int prevVal=i-1;
            
            int count=1;
            
            //now check if the next consecutive element exists
            //if yes increase counter and increase nextVal
            while(set.contains(nextVal))
            {
                count++;
                set.remove(nextVal++);
                
            }
            
            //now check if the prev consecutive element exists
            //if yes then increase counter and decrease prevVal
            while(set.contains(prevVal))
            {
                count++;
                set.remove(prevVal--);
                
            }
            //store the max consecutive numbers
            max=Math.max(max,count);
            
        }
        
        return max;
    }
	
	public static void main(String[] args) {
		
		int[] arr= {100,4,200,1,3,2};
		
		System.out.println(longestConsecutive(arr));
	}

}
