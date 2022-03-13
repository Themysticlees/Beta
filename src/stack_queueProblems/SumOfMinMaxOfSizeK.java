package stack_queueProblems;

import java.util.ArrayDeque;

//Sliding window problem
public class SumOfMinMaxOfSizeK {
	
	//Sum of minimum and maximum elements of all subarrays of size k.
	
	/*
	 * Input : arr[] = {2, 5, -1, 7, -3, -1, -2}  
        K = 4
		Output : 18
		Explanation : Subarrays of size 4 are : 
		     {2, 5, -1, 7},   min + max = -1 + 7 = 6
		     {5, -1, 7, -3},  min + max = -3 + 7 = 4      
		     {-1, 7, -3, -1}, min + max = -3 + 7 = 4
		     {7, -3, -1, -2}, min + max = -3 + 7 = 4   
		     Sum of all min & max = 6 + 4 + 4 + 4 
		                          = 18     
	 */
	
	//We will maintain two deques, in which dq1 will store the max element at front and will do decreasing orde
	//dq2 will store min element at rear and will go increase order
	
	public static int calculate(int[] arr, int k) {
		
		ArrayDeque<Integer> dq1 = new ArrayDeque<Integer>();
		ArrayDeque<Integer> dq2 = new ArrayDeque<Integer>();
		
		//firstly we'll find the max and min of first k elements and store it in the dqs.
		int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
		for(int i=0;i<k;i++)
		{
			max=Math.max(max, arr[i]);
			min=Math.min(min, arr[i]);
		}
		
		dq1.addLast(max);
		dq2.addLast(min);
		
		//calculate the sum 
		int sum=dq1.peekFirst()+dq2.peekFirst();
		
		for(int i=k;i<arr.length;i++) {
			
			//now we traverse from kth element, as we slide the window each time, we will get a new element and will get rid of an old element
			//if that element is bigger than the rear element, it may be the biggest in the window,
			//thus we'll keep popping until our element is bigger than the rear.
			//once the rear element is bigger, we'll push the element at rear for future ref as it may be the biggest in other windows
			//If the element is the biggest, we'll pop all the elements and add it to the queue
			
			while(!dq1.isEmpty() && dq1.peekLast()<=arr[i])
				dq1.removeLast();
			dq1.addLast(arr[i]);
			
			//We'll the opposite thing to find the min 
			//if the element is smaller than the rear, keep poping util we find a smaller rear element
			while(!dq2.isEmpty() && dq2.peekLast()>=arr[i])
				dq2.removeLast();
			dq2.addLast(arr[i]);
			
			//find the sum of the front elements of the dqs
			sum+=dq1.peekFirst()+dq2.peekFirst();
			
			//since the window is sliding, we'll check if the the min or max element is the old element 
			//if it matches, then it cannot be the max or min of the particular window thus pop it
			if(arr[i-k+1]==dq1.peekFirst())
				dq1.removeFirst();
			
			if(arr[i-k+1]==dq2.peekFirst())
				dq2.removeFirst();
			
			//continue checking for other windows
			
		}
		
		return sum;
	}

}
