package dp_Problems.stock_Problems;
import java.util.*;
/*
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day, 
 * and an integer k.
 * Find the maximum profit you can achieve. You may complete at most k transactions.
 * Note: You may not engage in multiple transactions simultaneously 
 * (i.e., you must sell the stock before you buy again).
 */
public class BuySellStocks3 {
	
	/*
	 * This is similar to Buy and sell stocks but here you can do at most k transactions 
	 * and thus find out the max profit you can make.
	 * Explaination inside function
	 */
	public int maxProfit(int[] prices, int k) {
        
        int n=prices.length;
        int[][][] dp = new int[n][2][k+1];
        for(int[][] i:dp)
            for(int[] j:i)
                Arrays.fill(j,-1);
        
        
        return helper(0,prices,n,1,k,dp);
    }
	
	//Tabulation + Space optimization
	public int tabulation(int[] prices, int k) {
		int n=prices.length;
        
		//Since we were requiring the curr and the next row to calculate the results
		//just use two 2d arrays
        int[][] curr=new int[2][k+1];
        int[][] after=new int[2][k+1];
        
        //We didnt write the base cases as both the base case return 0, our array is already
        //initialized with 0 thus no need to assign 0 again.
        
        //ind will start from n-1 to 0 (bottom to top) [check the memoization fucntion call and do it accordingly]
        //buy will be either 0 or 1
        //cap will start from 0 as in memoization it started from k so this will be reversed.
        //Just copy the recurrence relation
        for(int ind=n-1;ind>=0;ind--){
            for(int buy=0;buy<=1;buy++){
                for(int cap=1;cap<=k;cap++){
                    int profit=0;
                    if(buy==1){
                        int bought=-prices[ind]+after[0][cap];
                        int notBought=0+after[1][cap];

                        profit=Math.max(bought,notBought);
                    }
                    else{
                        int sold=prices[ind]+after[1][cap-1];
                        int notSold=0+after[0][cap];

                        profit=Math.max(sold,notSold);
                    }

                    curr[buy][cap]=profit;
                }
                after=curr.clone();
            }
        }
        
        return after[1][k];
	}
    
	//Memoization
    public int helper(int ind, int[] prices, int n, int buy, int cap, int[][][]dp){
        //if we reach beyond the size then return 0
    	//if the capactity (no.of transactions) exceeds then return 0 as you cannot do any other 
        if(ind==n)
            return 0;
        if(cap==0)
            return 0;
        
        //if already calculated
        if(dp[ind][buy][cap]!=-1)
            return dp[ind][buy][cap];
        
        int profit=0;
        //if buy is 1, then we can buy the stock
        //we have two options again
        /*
         * Either buy it and move to the next index and then we have to sell it
         * or not buy it and move ahead
         */
        if(buy==1){
        	//buy will become 0, as we cannot buy further until we have sold the stock
        	// -prices[ind] as we are paying this money so it will be deducted from the profit
            int bought=-prices[ind]+helper(ind+1,prices,n,0,cap,dp);
            int notBought=0+helper(ind+1,prices,n,1,cap,dp);
            
            profit=Math.max(bought,notBought);
        }
        //if we have to sell it, then add prices[ind] as we are getting money
        //move to the next index with cap-1 as we performed a complete transaction and 
        //and buy =1 as we can buy again
        else{
            int sold=prices[ind]+helper(ind+1,prices,n,1,cap-1,dp);
            int notSold=0+helper(ind+1,prices,n,0,cap,dp);
            
            profit=Math.max(sold,notSold);
        }
        
        //store the max profit
        return dp[ind][buy][cap]=profit;
    }

}
