package dp_Problems;
import java.util.*;

public class MaxSumAdjacent {
	
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		// Write your code here.
        int n=nums.size();
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return helper(nums,dp,n-1);
	}
    
    public static int helper(ArrayList<Integer> nums, int[]dp, int n){
        
        if(n==0)
            return nums.get(n);
        if(n<0)
            return 0;
        
        if(dp[n]!=-1)
            return dp[n];
        
        int pick=nums.get(n)+helper(nums,dp,n-2);
        int notpick=0+helper(nums,dp,n-1);
        
        return dp[n]=Math.max(pick,notpick);
    }

}
