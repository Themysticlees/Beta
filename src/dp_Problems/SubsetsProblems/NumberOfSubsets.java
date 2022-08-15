package dp_Problems.SubsetsProblems;
import java.util.*;
/*
 * Calculate the number of subsets whose sum is equal to target.
 * Input:
 * 4 3
 * 1 2 2 3
 * 
 * Output:
 * 3
 * 
 * For the first test case, N = 4 and tar = 3 and array elements are [1, 2, 2, 2,3] 
 * then the number of possible ways of making sum = 5 are:
	{1,2}
	{3}
	{1,2}
	
	Hence the output will be 3.
 */
public class NumberOfSubsets {
	
	/*
	 * Instead of finding a subset, now we need to calculate all the subsets whose sum equals target
	 * So when target becomes 0, return 1 signifying that we got a subset
	 * If we reach the 0th index and it is equal to target then return 1
	 * and finally add the number of noTake and take subsets and return the final ans
	 */
	public static int findWays(int nums[], int tar) {
        // Write your code here..
        int n=nums.length;
        int[][] dp = new int[n][tar+1];
        
         for(int[] i:dp)
             Arrays.fill(i,-1);
        
//        return helper(n-1,nums,tar,dp);
         
         return tabulation(nums, tar);
    }
	
	//Tabulation
	public static int tabulation(int nums[], int tar) {
		
		int n=nums.length;
        int[][] dp = new int[n][tar+1];
		
        //Base cases
        if(nums[0]<=tar)
            dp[0][nums[0]]=1;
        
        for(int i=0;i<n;i++) {
            dp[i][0]=1;
            
            if(nums[i]==0)
            	dp[i][0]=2;
        }
        
        //Here t or target will start from 0 as we need to add it for calculating the final ans
        //rest is same
        for(int i=1;i<n;i++){
            for(int t=0;t<=tar;t++){
                int notTake=dp[i-1][t];
                int take=0;
                if(nums[i]<=t)
                    take=dp[i-1][t-nums[i]];

                dp[i][t]=notTake+take;
            }
        }
        
        return dp[n-1][tar];
	}
	
	//Memoization
	public static int helper(int n, int[] nums, int tar, int[][] dp){
        
		/*
		 * We wont stop when target becomes 0, as the array may contain 0s, thus adding 0 changes nothing
		 * but it increases the subset count, so we need to iterate till the last index
		 * then if we see the target has become 0 and the element is also 0, then we have two subsets, either
		 * taking the 0 or not taking the 0, both will be subsets
		 * 
		 * If tar becomes 0 or the element at 0th index is equal to target then return 1 as there is 
		 * only 1 subset possible
		 */
        if(n==0){
        	if(tar==0 && nums[0]==0)
        		return 2;
            if(nums[0]==tar || tar==0)
                return 1;
            return 0;
        }
        
        //Already calculated
        if(dp[n][tar]!=-1)
            return dp[n][tar];
        
        //take / noTake scenario
        int notTake=helper(n-1,nums,tar,dp);
        int take=0;
        if(nums[n]<=tar)
            take=helper(n-1,nums,tar-nums[n],dp);
        
        //just add them as the number of subsets possible with sum equal to target
        //and return it
        return dp[n][tar]=notTake+take;
    }
	
	public static void main(String[] args) {
		
		int[] arr= {0,0,1};
		System.out.println(findWays(arr, 1));
	}

}
