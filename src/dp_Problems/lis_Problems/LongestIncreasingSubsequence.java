package dp_Problems.lis_Problems;
import java.util.*;
/*
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 */
public class LongestIncreasingSubsequence {
	/*
	 * Since this is a problem of subsequence, we'll use the take/notTake technique.
	 * Also for the the 0th index, the prev is -1 but we cannot represent -1 as an index
	 * thus we'll do a index shifting similar to LCS
	 */
	public int lengthOfLIS(int[] arr) {
        int n=arr.length;
        int[][] dp=new int[n][n+1];
        for(int[] i:dp)
            Arrays.fill(i,-1);
        return helper(0,arr,0,dp);
    
    }
	//Memoization
    public int helper(int ind, int[] arr, int prev_ind, int[][] dp){
        
    	//when there are no more elements left, return 0
        if(ind==arr.length){
            return 0;
        }
        
        //if already calculated
        if(dp[ind][prev_ind]!=-1)
            return dp[ind][prev_ind];
        
        //if we dont take the curr element simply move ahead, increase ind by 1 and prev index remains same
        int notTake=helper(ind+1,arr,prev_ind,dp);
        int take=0;
        //if the curr element is more than the [prev-1] (since we did index shifting) element
        //or the prev index is 0, i.e we are at the 0th index so we have to consider it
        //increase ind by 1 and the prev index becomes the curr index
        
        if(prev_ind==0 || arr[ind]>arr[prev_ind-1])
            take=1+helper(ind+1,arr,ind+1,dp);
        
        return dp[ind][prev_ind]=Math.max(take,notTake);
    }
    
    //Tabulation + Space optimazation
    public int tabulation(int[] arr) {
        int n=arr.length;
        
        //Declare similar size array
        int[] curr=new int[n+1];
        int[] after=new int[n+1];
       
        //start iterating from the end (bottom - top approach)
        for(int ind=n-1;ind>=0;ind--){
        	//prev will be from ind to 0 
        	//(index shifting used as for the 0th element prev is -1 which is not possible to represent
        	//Thus we have shifted the index, while comparing we'll compare with prev-1)
            for(int prev=ind; prev>=0;prev--){
                int notTake=after[prev];
                int take=0;
                //if prev is 0 i.e if we reach the 0th element no need to compare just pick it
                //otherwise compare with prev-1
                if(prev==0 || arr[ind]>arr[prev-1])
                    take=1+after[ind+1];

                curr[prev]=Math.max(take,notTake);
            }
            after=curr.clone();
        }
        return after[0];
        
    }

}
