package array_Problems;
/*
 * Given an array nums with n integers, your task is to check if it could become 
 * non-decreasing by modifying at most one element.
 * We define an array is non-decreasing if nums[i] <= nums[i + 1] holds 
 * for every i (0-based) such that (0 <= i <= n - 2).
 * 
 * Input: nums = [4,2,3]
 * Output: true
 * Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
 */
public class IncreasingArray {
	
	//First we need to find the pair of elements which needs modification
	//if element at i is greater than i+, then we need to modify it
	public static boolean checkPossibility(int[] nums) {
        
		//for counting the no.of modifications
        int count=0;
        
        //for finding the max for every element, needed for modification
        int max=0;
        
        for(int i=0;i<nums.length-1;i++){
        	
        	//if we find that element at i is greater than i+1 then modification required
        	//we can modify any one of the numbers (i or i+1)
            if(nums[i]>nums[i+1]){
                count++;
                
                //store the max so far
                //we cannot decrease the element at i below max as this will break the increasing 
                //property for the previous elements which we have already checked
                //so we can decrease the curr element to max
                int temp=max;
                
                //if that solves our problem then just assign nums[i]=temp(max) and continue
                if(temp<=nums[i+1]){
                    nums[i]=max;
                    continue;
                }
                //if this doesnt solve the problem, then we have to change the nums[i+1], just assign
                //nums[i+1]=nums[i] (minimum we can increase so that it follows the increasing property)
                //we can increase more but that may disrupt the rest of the elements thus we'll increase
                //it to the minimum value that is possible.
                else{
                    nums[i+1]=nums[i];
                } 
            }
            //and update the max value so that we can compare for the rest of the elements
            max=nums[i];
        }
        
        //now if count is more than 1, then we cannot correct the array by doing just 1 modification
        //thus return false otherwise return true
        if(count>1)
            return false;
        return true;
    }
	
	public static void main(String[] args) {
		
		int[] arr = {1,2,3,5,2,4,5,6};
		System.out.println(checkPossibility(arr));
		
	}

}
