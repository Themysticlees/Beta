package dp_Problems;
import java.util.*;
/*
 * This problem is similar to Coin Change, however in this problem you have to return 
 * the no.of ways target can be achieved, all the ways must be unique.
 */
public class CoinChange2 {
	/*
	 * The previous problem (Coin Change) deals with duplicate ans thus we have used a different approach.
	 * In this approach, we use the take/not Take technique.
	 * If we don't take a coin, then we move ahead and the index decreases
	 * But if we take a coin, we stay at the same index as we can have unlimited supply and we use a coin of 
	 * same denomination more than once. Only the target decreases
	 */
	public static long countWaysToMakeChange(int num[], int x){
        //write your code here			

        long dp[][] = new long[num.length][x+1];
        for(long[] i:dp)
            Arrays.fill(i,-1);
        return helper(num.length-1,num,x,dp);
	}
    
	//Memoization
    public static long helper(int n, int[] arr, int target, long[][] dp){
        
    	//Once we reach the 0th index, then if we can form the target so far with the given coin at the
    	//0th index then return 1
        if(n==0){
            if(target%arr[0]==0)
                return 1;
            return 0;
        }
        
        //If already calculated
        if(dp[n][target]!=-1)
            return dp[n][target];
        
        //If we don't take a coin then we move ahead, this neglects duplicate ways as we cannot go the 
        //prev coin 
        long notTake=helper(n-1,arr,target,dp);
        long take=0;
        // And if we take a coin, we stay at the same index as we can take it again
        if(arr[n]<=target)
            take=helper(n,arr,target-arr[n],dp);
        
        //add the total ways we can achieve target
        return dp[n][target]=take+notTake;
    }
    
    //Tabulation (No Recursion stack space)
    public static long tabulation(int[] num, int x) {
    	
    	long dp[][] = new long[num.length][x+1];

    	//Base case
	     for(int i=0;i<=x;i++){
	         if(i%num[0]==0)
	             dp[0][i]=1;
	     }
	     
	     //Simply copy paste the recurrence relation
	     //Since we are moving from bottom to top, thus loop will run from 0 to x
	     //Calculate for all target values
	     for(int i=1;i<num.length;i++){
	         for(int tar=0;tar<=x;tar++){
	             long notTake=dp[i-1][tar];
	             long take=0;
	             if(num[i]<=tar)
	                 take=dp[i][tar-num[i]];
	
	             dp[i][tar]=take+notTake;
	         }
	     }
	    
	     return dp[num.length-1][x];
	    }

}
