package stack_queueProblems;

import java.util.Stack;

public class LargestAreaHistogram {
	
	public static int helper(int[] arr, int n) {
		
		//Find the prev smaller element
		
		int[] prev=new int[n];
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0;i<n;i++) {
			
			while(!stack.isEmpty() && arr[stack.peek()]>=arr[i])
				stack.pop();
			
			if(stack.isEmpty())
				prev[i]=-1;
			else
				prev[i]=stack.peek();
			stack.push(i);
		}
		
		stack.clear();
		
		int[] nxt = new int[n];
		
		for(int i=n-1;i>=0;i--) {
			
			while(!stack.isEmpty() && arr[stack.peek()]>=arr[i])
				stack.pop();
			
			if(stack.isEmpty())
				nxt[i]=-1;
			else
				nxt[i]=stack.peek();
			stack.push(i);
		}
		
		int max=Integer.MIN_VALUE;
		for(int i=0;i<n;i++) {
			int left=prev[i];
			int right=nxt[i];
			
			if(left==-1)
				left=0;
			if(right==-1)
				right=n-1;
			
			int area=(right-left)*arr[i];
			max=Math.max(max, area);
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		
		//Array determining the heights at every index
		int[] arr= {4,2,1,5,6,3,2,4,2};
		
		System.out.println(helper(arr, arr.length));
		
	}

}
