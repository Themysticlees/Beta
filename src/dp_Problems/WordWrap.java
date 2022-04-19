package dp_Problems;
import java.util.*;

/*
 * Given an array nums[] of size n, where nums[i] denotes the number of characters in one word. 
 * Let K be the limit on the number of characters that can be put in one line (line width). 
 * Put line breaks in the given sequence such that the lines are printed neatly.
 * Assume that the length of each word is smaller than the line width. When line breaks are inserted 
 * there is a possibility that extra spaces are present in each line. 
 * The extra spaces include spaces put at the end of every line except the last one. 
 * You have to minimize the following total cost where total cost = Sum of cost of all lines, 
 * where cost of line is = (Number of extra spaces in the line)2.
 * 
 * Input: nums = {3,2,2,5}, k = 6
	Output: 10
	Explanation: Given a line can have 6
	characters,
	Line number 1: From word no. 1 to 1
	Line number 2: From word no. 2 to 3
	Line number 3: From word no. 4 to 4
	So total cost = (6-3)2 + (6-2-2-1)2 = 32+12 = 10.
	As in the first line word length = 3 thus
	extra spaces = 6 - 3 = 3 and in the second line
	there are two word of length 2 and there already
	1 space between two word thus extra spaces
	= 6 - 2 -2 -1 = 1. As mentioned in the problem
	description there will be no extra spaces in
	the last line. Placing first and second word
	in first line and third word on second line
	would take a cost of 02 + 42 = 16 (zero spaces
	on first line and 6-2 = 4 spaces on second),
	which isn't the minimum possible cost.
 */
public class WordWrap {
	//We'll use dp to store the results for the indexes
	//to reuse them and reduce time
	public int solveWordWrap (int[] nums, int k)
    {
        // Code here 
        int[] dp = new int[k+5];
        Arrays.fill(dp,-1);
        return helper(0,nums,nums.length,k,dp);
        
    }
    
    public int helper(int ind,int[]nums,int n, int k, int[]dp){
        
    	//if we reach the last point return 0
        if(ind>=n)
            return 0;
        
        //for storing the no.of characters and spaces
        int sum=0;
        //for storing the min ans
        int ans=Integer.MAX_VALUE;
        
        for(int i=ind;i<n;i++){
        	//add the no.of characters of a word to the sum 
            sum+=nums[i];
            
            int subans=0;
            //i-ind represents the spaces between words
            //ind is the starting word, i is the last word, thus we need to add the spaces in the sum
            //and then check
            if(sum+(i-ind)<=k){
            	//if we already have the ans for the next index then dont need to calculate 
            	//just return it otherwise do a recursive call
                if(dp[i+1]!=-1)
                    subans= dp[i+1];
                else
                    subans=helper(i+1,nums,n,k,dp);
            
            //now calculate the cost of the current words
            int cost=0;
            //if not the last index as the last word will always be in the last line
            //and cost of the last line will be zero
            if(i!=n-1)
                cost=(int)Math.pow(k-sum-i+ind,2);
                
            //now check for the min ans
            ans=Math.min(ans,cost+subans);
            }
            
        }
        //store the ans of the index in the dp array for future use
        return dp[ind]=ans;
    }

}
