package dp_Problems.partitionProblems;
import java.util.*;
/*
 * You are given chocolate of ‘N’ length. The chocolate is labeled from 0 to ‘N’. 
 * You are also given an array ‘CUTS’ of size ‘C’, denoting the positions at which you can do a cut. 
 * The order of cuts can be changed. The cost of one cut is the length of the chocolate to be cut. 
 * Therefore, the total cost is the sum of all the cuts. Print the minimum cost to cut the chocolate.
 * 
 * Let ‘N’ be: 4
 * Let the ‘CUTS’ array be: [1, 3].
 * Let the order of doing the cut be [1, 3].
 * The first cut of 1 on length 4 results in a cost of 4, and chocolate is split into two parts 
 * of the length of 1 and 3.
 * The second cut of 3 on length 3 results in a cost of 3, and chocolate is split into two parts 
 * again of the length of 2 and 1. So the total cost is 7.
 * 
 * The cost will remain the same if we change the order of cutting. So the result is 7.
 */
public class MinCostCutChocolate {
	/*
	 * So the idea is to minimize the cost to perform all the cuts.
	 * The cost is equal to the remaining length of the chocolate in which the cut needs to be made.
	 * So we have to check all the possibilities to figure the best sequence.
	 * 
	 * The first thing which needs to be done is to sort the array. So that no cut will be dependent 
	 * on any other cut.
	 * 
	 * Then add 0 at the beginning and n to the last index of the cuts array, the first and last two 
	 * numbers determine the size of the chocolate which will help us to find the cost.
	 * So whenever we partition the array, the first and last will be the new length of the chocolate
	 */
	public static int cost(int n, int c, int cuts[]) {

        // Write your code here..
        Arrays.sort(cuts);
        List<Integer> cutlist=new ArrayList<>();
        
        //Add 0 and n
        cutlist.add(0);
        for(int i=0;i<c;i++)
            cutlist.add(cuts[i]);
        cutlist.add(n);
        
        int[][] dp = new int[n][n];
        for(int[] i:dp)
            Arrays.fill(i,-1);
        
        //i will start from 1 and j from n-2 as 0th and n-1th indexes are not cuts but simply used 
        //to calculate cost thus they shouldn't be used in partition.
        return helper(1,cutlist.size()-2,cutlist, dp);
    }
    
    public static int helper(int i, int j, List<Integer> cutlist, int[][] dp){
        
        if(i>j)
            return 0;
        
        if(dp[i][j]!=-1)
            return dp[i][j];
        
        int min=Integer.MAX_VALUE;
        //check for every cut and the call two functions for the left and right subarray
        //Calculate the min and store it
        for(int ind=i; ind<=j;ind++){
            int cost=cutlist.get(j+1)-cutlist.get(i-1)
                +helper(i,ind-1,cutlist,dp)+helper(ind+1,j,cutlist,dp);
            min=Math.min(min,cost);
        }
        
        return dp[i][j]=min;
    }

}
