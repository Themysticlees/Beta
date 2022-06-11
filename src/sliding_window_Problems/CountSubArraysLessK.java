package sliding_window_Problems;

/*
 * The score of an array is defined as the product of its sum and its length.
 * For example, the score of [1, 2, 3, 4, 5] is (1 + 2 + 3 + 4 + 5) * 5 = 75.
 * Given a positive integer array nums and an integer k, return the number of 
 * non-empty subarrays of nums whose score is strictly less than k.
 * A subarray is a contiguous sequence of elements within an array.
 * 
 *  Input: nums = [2,1,4,3,5], k = 10
	Output: 6
	Explanation:
	The 6 subarrays having scores less than 10 are:
	- [2] with score 2 * 1 = 2.
	- [1] with score 1 * 1 = 1.
	- [4] with score 4 * 1 = 4.
	- [3] with score 3 * 1 = 3. 
	- [5] with score 5 * 1 = 5.
	- [2,1] with score (2 + 1) * 2 = 6.
	Note that subarrays such as [1,4] and [4,3,5] are not considered because
	 their scores are 10 and 36 respectively, while we need scores strictly less than 10.
 */
public class CountSubArraysLessK {
	
	//We can solve this problem using Sliding window
	//we'll add elements into the window , calculate the result and check if it less than k
	//if the result is more or equal to k, then subtract arr[start] from sum and calculate the result untill
	//result is less than k
	//if yes then just add the count of subarrays = (end-start+1) and increase end pointer
	public static long countSubarrays(int[] nums, long k) {
        
        int n=nums.length;
        
        int start=0,end=0;
        long count=0;
        long sum=0;
        while(start<=end && end<n){
            
            sum+=nums[end];
            
            //calculate the result acc to the logic
            long ans=sum*(end-start+1);
            
            //if ans is more or equal then subtract 
            while(ans>=k){
                sum-=nums[start++];
                ans=sum*(end-start+1);
            }
            
            //if ans is less than k,
            if(ans<k){
                count+=end-start+1;
                end++;
            }

        }
        return count;
        
    }
	
	public static void main(String[] args) {
		int[] arr={2,1,4,3,5};
		
		System.out.println(countSubarrays(arr, 10));
	}

}
