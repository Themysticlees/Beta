package stack_queueProblems;
import java.util.*;
public class NextandPrevSmallestElement {
	
	/*
	 * Similar to next and prev greater elements
	 * Use a stack to store the elements, now check if the top element of the stack is smaller than the 
	 * current element in the array.
	 * If not, then just keep popping elements until you find the smaller element.
	 * We won't need the popped elements in the future as they were bigger or equal to the current element
	 * thus they can never be smaller than the current element.
	 * If stack becomes empty then there are no smaller elements, simply add -1 in the res array.
	 * Otherwise,
	 * 	Next push the current element.
	 * Follow the same steps for the next element
	 */
	public static int[] nextSmallEl(int[] arr, int n) {
		
		//Since we are concerned about the elements to the right of element, thus the loop will start
		//from n-1 and end at 0.
		int[] ans=new int[n];
		Stack<Integer> stack = new Stack<>();
		
		for(int i=n-1;i>=0;i--) {
			
			while(!stack.isEmpty() && stack.peek()>=arr[i])
				stack.pop();
			
			if(stack.isEmpty())
				ans[i]=-1;
			else
				ans[i]=stack.peek();
			stack.push(arr[i]);
		}
		
		return ans;
	}
	
	public static int[] prevSmallEl(int[] arr, int n) {
		
		//Since we are concerned about the elements to the left of element, thus the loop will start
		//from 0 and end at n-1.
		int[] ans=new int[n];
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0;i<n;i++) {
			
			while(!stack.isEmpty() && stack.peek()>=arr[i])
				stack.pop();
			
			if(stack.isEmpty())
				ans[i]=-1;
			else
				ans[i]=stack.peek();
			stack.push(arr[i]);
		}
		
		return ans;
		
	}
	
	public static void main(String[] args) {
		
		int[] arr= {4,2,1,5,6,3,2,4,2};
		
		System.out.println("Next Smallest elements: \n"+Arrays.toString (nextSmallEl(arr, arr.length)));
		System.out.println("Previous Smallest elements: \n"+Arrays.toString (prevSmallEl(arr, arr.length)));
		
	}

}
