package dp_Problems.SubsequencesProblems;

/*
 * Problem link: https://www.codingninjas.com/codestudio/problems/unbounded-knapsack_1215029?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=1
 * 
 * Similar to 01 Knapsack, the only difference here you can take an item multiple times
 */
public class UnboundedKnapsack {
	
	public static int unboundedKnapsack(int n, int W, int[] val,int[] wt) {
		
		int[][] dp=new int[n][W+1];
	    
        //Base Condition
		//For the 0th index, if the item weight is less than the bag weight, then simply divide it
		//Then we'll get the no.of times we can take and multiply it with the value of the item
        for(int i=wt[0]; i<=W; i++){
            dp[0][i] = ((int) i/wt[0]) * val[0];
        }

        //Similar to 01Knapsack
        for(int ind =1; ind<n; ind++){
            for(int cap=0; cap<=W; cap++){

                int notTaken = 0 + dp[ind-1][cap];

                int taken = Integer.MIN_VALUE;
                if(wt[ind] <= cap)
                    taken = val[ind] + dp[ind][cap - wt[ind]];

                dp[ind][cap] = Math.max(notTaken, taken);
            }
        }

        return dp[n-1][W];
	}

}
