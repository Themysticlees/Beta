package array_Problems;

import utilty_Algorithm.Numbers;

public class Next_Permuation {
	
	public static void nextPermutation(int[] nums) {
		
		int n=nums.length;
		int index=-1;
		
		for(int i=n-1;i>0;i--) 
		{
			//check for such pair where the previous 
			//number is less than the next number
			if(nums[i]>nums[i-1])
			{
				index=i;
				break;
			}	
		}
		//Means array is in Descending
		if(index==-1)
			Numbers.reverse(nums, 0, n-1);
		else
		{
			//find the next greater number than nums[index-1] and smaller than nums[temp]
			int temp=index;
			for(int i=index+1;i<n;i++)
			{
				if(nums[i]>nums[index-1] && nums[i]<nums[temp])
					temp=i;
			}
			
			//swap the two numbers
			Numbers.swap(nums, index-1, temp);
			//reverse the rest of the array starting from
			//index position
			Numbers.reverse(nums, index, n-1);
		}
		
		for(int i=0;i<n;i++)
			System.out.print(nums[i]);
	}
	public static void main(String[] args) {
		
		int[] arr= {1,2,5,3};
		nextPermutation(arr);
	}

}
