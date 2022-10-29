package dp_Problems.partitionProblems;
import java.util.*;
/*
 * video link: https://www.youtube.com/watch?v=PhWWJmaKfMc&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=73
 * problem link: https://leetcode.com/problems/partition-array-for-maximum-sum/submissions/
 * 
 * Given an integer array arr, partition the array into (contiguous) subarrays of length at most k. 
 * After partitioning, each subarray has their values changed to become the maximum value of that subarray.
 * Return the largest sum of the given array after partitioning. Test cases are generated so that 
 * the answer fits in a 32-bit integer.

 
 */
public class PartitionArrayMaxSum {
	/*
	 * The idea is to make partitions of max size K such the subarray formed will have the max sum. Each
	 * element in the sub array will be replaced by the max element in the subarray.
	 * Thus find all the possibilities
	 */
	public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
       int[] dp = new int[n];
       Arrays.fill(dp,-1);
       return helper(0,k,arr,n,dp);
   }
	
	//Memoization
     public int helper(int i,int k,int[] arr, int n, int[] dp){
      
       if(i>=n)
           return 0;
      
       if(dp[i]!=-1)
           return dp[i];
      
       int maxE=arr[i];
       int ans=Integer.MIN_VALUE;
       
       //check for all possible partitions.
       for(int ind=i;ind<n && ind<i+k;ind++){
          
           int res=helper(ind+1,k,arr,n,dp);
           //store the max element found so far
           maxE=Math.max(maxE,arr[ind]);
          
           //find the sum
           //since all the elements will be replaced by the max element
           //Thus multiply the max element with the no.of elements so far.
           
           int sum=res+(ind-i+1)*maxE;
          
           //calculate max sum and store
           ans=Math.max(ans,sum);
       }
      
       //return it and store it int dp array
       return dp[i] =ans;
   }
     
   //Tabulation
     public int tabulation(int[] arr, int k) {
         int n=arr.length;
        int[] dp = new int[n+1];
        // Arrays.fill(dp,-1);
        // return helper(0,k,arr,n,dp);
        
        //base case
        dp[n]=0;
        
        //As the recursion went to 0-n for i, thus for tabulation i will start from n-1 to 0
        //Rest of the code is same, just copy paste
        for(int i=n-1;i>=0;i--){
            int maxE=arr[i];
            int ans=Integer.MIN_VALUE;
            for(int ind=i;ind<n && ind<i+k;ind++){

                int res=dp[ind+1];
                maxE=Math.max(maxE,arr[ind]);

                int sum=res+(ind-i+1)*maxE;

                ans=Math.max(ans,sum);
            }

            dp[i] =ans;
        }
        return dp[0];
    }

}
