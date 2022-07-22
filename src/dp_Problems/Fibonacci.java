package dp_Problems;

import java.util.Arrays;

//Calculate the nth number of the Fibonacci series
public class Fibonacci {
	
	//Recursive Approach
	public int fibo1(int n) {
		
		//The first and second numbers are 0 and 1 so no need to compute that just return n
		if(n<=1)
			return n;
		
		//otherwise return the addition of previous two elements
		return fibo1(n-1)+fibo1(n-2);
	}
	
	//Dp with Memorization
	public int fibo2(int n, int[] dp) {
		
		if(n<=1)
			return n;
		
		//if we have already solved the subproblem just return the saved value
		if(dp[n]!=-1)
			return dp[n];
		
		//otherwise compute and store it in the dp array
		return dp[n]=fibo2(n-1,dp)+fibo2(n-2,dp);
	}
	
	//Dp with tabulation
	public int fibo3(int n, int[] dp) {
		
		//The first two values are known
		dp[0]=0;dp[1]=1;
		
		//So instead of recursion, we can just add the prev two elements and store the result
		//and this cycle goes on
		for(int i=2;i<=n;i++)
			dp[i]=dp[i-1]+dp[i-2];
		return dp[n];
	}
	
	//Sometimes we dont need to use any space at all, simply by observing we can understand
	//prev2 and prev are shifting after every iteration.
	public int fibo4(int n) {
		
		int prev2=0;
		int prev=1;
		
		for(int i=2;i<=n;i++) {
			int curr=prev+prev2;
			prev2=prev;
			prev=curr;
		}
		
		return prev;
	}
	
	public static void main(String[] args) {
		
		Fibonacci ob = new Fibonacci();
		
		//System.out.println(ob.fibo1(7));
		int n=9;
		int[] dp = new int[n+1];
		
		Arrays.fill(dp, -1);
		System.out.println(ob.fibo4(n));
		
	}

}
