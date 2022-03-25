package array_Problems;

import java.util.*;
/*
 * problem link : https://leetcode.com/problems/rotate-array/
 * 
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
	Input: nums = [1,2,3,4,5,6,7], k = 3
	Output: [5,6,7,1,2,3,4]
	Explanation:
	rotate 1 steps to the right: [7,1,2,3,4,5,6]
	rotate 2 steps to the right: [6,7,1,2,3,4,5]
	rotate 3 steps to the right: [5,6,7,1,2,3,4]
*/
public class ArrayRotation {
	
	public static int[] rotation(int[] arr, int c)
	{
		List<Integer> list = new LinkedList<>();
		
		for(int i=0;i<arr.length;i++)
			list.add(arr[i]);
		
		while(--c>=0)
		{
			int temp=list.get(arr.length-1);
			list.add(0, temp);
		}
		
		for(int i=0;i<arr.length;i++)
			arr[i]=list.get(i);
		
		return arr;
		
	}
	
	//Optimized approach
	public void rotate(int[] nums, int k) {
        
		//using an dequeue so that we can add and delete from both ends
        ArrayDeque<Integer> aq=new ArrayDeque<>();
        for(int i=0;i<nums.length;i++)
            aq.add(nums[i]);
        
        while(k-->0)
        {
        	//removing the last element and adding it to the front
        	//doing this for k elements from the end
            int r=aq.removeLast();
            aq.addFirst(r);
        }
        
        int j=0;
        //transferring the queue to the array
        for(int i:aq)
            nums[j++]=i;
    }

	public static void main(String[] args) {
		
		int[] A={9, 8, 7, 6, 4, 2, 1, 3};
		int c=3;
		
		A=rotation(A,c);
		
		for(int i=0;i<A.length;i++)
			System.out.print(A[i]+" ");

	}

}
