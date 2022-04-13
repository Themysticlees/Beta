package dp_Problems;
import java.util.*;
/*
 * Given a list of coins of distinct denominations and total amount of money.
 * Find the minimum number of coins required to make up that amount. Output -1 
 * if that money cannot be made up using given coins.
 * You may assume that there are infinite numbers of coins of each type.
 * 
 *  Input: arr = [1, 2, 5], amount = 11
	Output: 3
	Explanation: 2*5 + 1 = 11. So taking 2 
	denominations of 5 and 1 denomination of  
	1, one can make 11.
 */
public class CoinChange {
	
	public static int CoinChange(int[] nums, int amount)
    {
        //Dp array to store the results so that if we hit a similar scenario,
		//instead of calculating, we'll search the result from the array
        int[] dp = new int[amount+1];
        dp[0]=0;
        
        Arrays.fill(dp,-1);
        
        int ans=helper(nums,amount,dp);
        
        //If no ans was found , then ans must be max value as in the helper function, we initialized ans with it
        if(ans==Integer.MAX_VALUE || ans==-1)
            return -1;
        return ans;
    }
    
    public static int helper(int [] arr, int amount, int[]dp){
        
    	//if we get zero, then no need check return 0
        if(amount==0)
            return 0;
        
        //this will denote the min coins needed
        int ans=Integer.MAX_VALUE;
        
        //we check for each denominations
        for(int i=0;i<arr.length;i++){
            
            int subans=0;
            //if we subtract the amount with a denomination, and we get less than then it is not possible
            if(amount-arr[i]>=0){
                
            	//if we have already calculated the min coins for a particular amount
            	//check for it and if found, insert that
            	//if we havent calculated, then we need to calculate,
            	//do a recursive call for amount-arr[i]
                if(dp[amount-arr[i]]!=-1)
                    subans=dp[amount-arr[i]];
                else
                    subans=helper(arr,amount-arr[i],dp);
                
                //now from all the possible brances, we'll take the branch or path that used the min coins
                //+1 because a certain coin was subtracted, thus +1
                if(subans!=Integer.MAX_VALUE && subans+1<ans)
                    ans=subans+1;
                
            }
        }
        //store the no.of coins for that amount in the dp array and return the result
        dp[amount]=ans;
        return ans;
    }
    
    public static void main(String[] args) {

		int[] a= {1,2,5};
		System.out.println(CoinChange(a,11));
	}

}
