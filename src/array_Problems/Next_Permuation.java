package array_Problems;

import java.util.Arrays;

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
			Arrays.sort(nums);
		else
		{
			//find the next greater number than nums[index-1] and smaller than nums[temp]
			int temp=index;
			for(int i=n-1;i>=index;i--)
			{
				if(nums[i]>nums[index-1])
				{
					temp=i;
					break;
				}
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
		
		String s="74 65 42 12 54 69 48 45 63 58 38 60 24 42 "
				+ "30 79 17 36 91 43 89 7 41 43 65 49 47 6 91 "
				+ "30 71 51 7 2";
		int[] arr= {74, 65, 42, 12, 54, 69, 48, 45, 63, 58, 38, 60, 24, 42,
				 30, 79, 17, 36, 91, 43, 89, 7 ,41, 43, 65, 49, 47, 6, 91, 
				30, 71, 51, 7, 2};
		nextPermutation(arr);
	}

}
