package dp_Problems;
import java.util.*;
/*
 * You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. 
 * That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a 
 * security system connected, and it will automatically contact the police if two adjacent houses 
 * were broken into on the same night.
 * Given an integer array nums representing the amount of money of each house, return the maximum 
 * amount of money you can rob tonight without alerting the police.
 * 
 *  Input: nums = [2,3,2]
	Output: 3
	Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are 
	adjacent houses.
 */
public class HouseRobber {
	/*
	 * This is similar to max sum of non adjacent numbers in an array, the only difference is 
	 * the first and the last house are adjacent since the houses are placed in a circle
	 */
	public int rob(int[] nums) {
        
        int n=nums.length;
        n--;
        
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        //Thus we'll make two function calls, when we have selected the nth house and when we havent selected
        //nth house
        //nth house visited
        int a=nums[n]+helper(n-2,nums,dp,1);
        //nth house not visited
        Arrays.fill(dp,-1);
        int b=helper(n-1,nums,dp,0);
        
        //and just return the max money collected from both the houses
        return Math.max(a,b);
    }   
    
    public int helper(int n, int[] nums, int[] dp, int c){
        //if we reach the first house (since we are starting from last), then we'll check
    	//whether we have selected the nth house, if yes we cannot select the 0th house as they are 
    	//adjacent thus return accordingly
        if(n==0){
            if(c==1)
                return 0;
            else
                return nums[0];
        }
        
        if(n<0)
            return 0;
        
        //if already calculated
        if(dp[n]!=-1)
            return dp[n];
        
        //otherwise, select a house and move to the next to next one
        int take=nums[n]+helper(n-2,nums,dp,c);
        //or donot select a house and move to the next one
        int nottake=0+helper(n-1,nums,dp,c);
        
        //This way we'll select all the adjacent houses
        //calculate max and store it in the dp array
        return dp[n]=Math.max(take,nottake);
    }

}
