package dp_Problems;
import java.util.*;

/*
 * Problem link: https://www.codingninjas.com/codestudio/problems/frog-jump_3621012?leftPanelTab=0
 * 
 * There are n steps (1-n), the frog is standing at step 1, it can only jump one step or two steps,
 * Some energy is lost while jumping from one step to the other.
 * Calculate the min energy required to reach the last step
 */
public class FrogJump {
	/*
	 * The idea is to calculate all possible ways to reach the last index
	 * and select the min out of all
	 */
	public static int frogJump(int n, int heights[]) {

        // Write your code here..
		//dp array to store the energy required to reach the end from each index
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        
        return helper(heights,dp,n-1);
    }
    
	//Memorization
    public static int helper(int[] heights, int[] dp, int n){

    	//since we are starting from the last, the goal is to reach the 0 index
        if(n==0)
            return 0;

        //if value already calculated, just return it
        if(dp[n]!=-1)
            return dp[n];
        
        //otherwise call the function for one jump and two jumps, and return the min 
        int one=Integer.MAX_VALUE;
        int two=Integer.MAX_VALUE;
        
            one=helper(heights,dp,n-1)+Math.abs(heights[n]-heights[n-1]);
        //if n becomes 1 then it's not possible to take two jumps
        if(n>1)
            two=helper(heights,dp,n-2)+Math.abs(heights[n]-heights[n-2]);
        
        return dp[n]=Math.min(one,two);
    }
    
    //Tabulation
    public static int helper2(int[] heights, int[] dp, int n) {
    	
    	dp[0]=0;
    	
    	for(int i=1;i<=n;i++) {
    		int one=dp[i-1]+Math.abs(heights[i]-heights[i-1]);
    		int two=Integer.MAX_VALUE;
    		if(i>1)
    			two=dp[i-2]+Math.abs(heights[i]-heights[i-2]);
    		
    		dp[i]=Math.min(one, two);
    	}
    	
    	return dp[n];
    }

}
