package array_Problems;

/*
 * You are given an integer array nums and an integer x. In one operation, you can either remove 
 * the leftmost or the rightmost element from the array nums and subtract its value from x.
 * Note that this modifies the array for future operations.
 * Return the minimum number of operations to reduce x to exactly 0 if it is possible, 
 * otherwise, return -1.
 * 
 * Input: nums = [3,2,20,1,1,3], x = 10
 * Output: 5
 * Explanation: The optimal solution is to remove the last three elements and the 
 * first two elements (5 operations in total) to reduce x to zero.
 */
public class MinOperationsToXequals0 {
	
	//You can solve this problem by using two pointer approach by taking a number from either sides
	//and then subtracting and checking if x reaches 0, but this will give TLE for large test cases
	
	//Optimized approach
	//Find the longest subarray whose sum is equal to total sum-x
	//So the elements which wont be included in the subarray are the elements which we need to subtract 
	//from x to get 0
	public static int minOperations(int[] nums, int x) {
        
		//calculating the total sum
		int sum=0;
        for(int i:nums)
        	sum+=i;
        
        return helper(nums,x,sum);
    }
	
	public static int helper(int[] arr, int x, int sum) {
		
		int i=0,j=0;
		
		//keep on adding elements to currsum
		int currsum=0;
		int max=-1;
		while(i<=j && j<arr.length) {
			
			currsum+=arr[j];
			
			//if currsum becomes more than sum-x then we need to subtract arr[i] until it becomes less than it
			//also increase i as the length of the subarray should be decreasing
			while(currsum>sum-x && i<=j) {
				currsum-=arr[i++];
			}
			
			//if currsum becomes equal to sum-x store the length of the subarray in max
			//we need to find the max length subarray since the elements which will be left will be
			//the operations required to get x to 0
			//thus the subarray needs to be largest
			if(currsum==sum-x) {
				max=Math.max(max, j-i+1);
			}
			
			//increase j 
			j++;
		}
		
		//if max is still -1 that means no subarray of the desired sum was found
		//thus return -1
		if(max==-1)
			return max;
		//else return length of array-lenght of subarray
		//this will give the no.of elements which were not included in the subarray and we need to 
		//subtract these numbers to get x to 0.
		return arr.length-max;
	}
	
	public static void main(String[] args) {
		
		int[] a= {1,5,3,9,1,7,1,3};
		minOperations(a, 12);
		
	}

}
