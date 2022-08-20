package dp_Problems.SubsequencesProblems;
import java.util.*;
/*
 * There are n items with weight wi and value vi. A theif can steal items such that the weight of 
 * total items stolen is equal to his bag weight. He can take an item only once.
 * Calculate the max value the theif can get by stealing the items.
 */
public class _01Knapsack {
	
	public static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

	    int[][] dp = new int[n][maxWeight+1];
//	     for(int[] i:dp)
//	         Arrays.fill(i,-1);
//	     
//	     return helper(n-1,weight,value,maxWeight,dp);
	    
	    
	    //Tabulation + Space Optimization
	    /*
	     * We can use a single dimmension array to calculate our ans
	     * In order to calculate for the curr row, we needed the prev row (dp[i-1])
	     * Instead of using a prev array, use the curr array and save the ans in the curr array
	     * 
	     * The only change is, the iteration for the weight count will be from W to 0, 
	     * So every time we the value of the prev row and the weight less or equal to the curr row
	     * thus the weight values to the right are not used.
	     * Thus we will start the iteration from the right and will save the ans in that curr array only
	     * 
	     * Now as we move ahead, we'll require the weight values left of the curr index
	     */
	    int[] curr=new int[maxWeight+1];
        
        for(int w=weight[0];w<=maxWeight;w++)
            curr[w]=value[0];
        
        for(int i=1;i<n;i++){
        	//loop it from the end to 0
            for(int w=maxWeight;w>=0;w--){
                int notTake=0+curr[w];
                int take=-999;

                if(weight[i]<=w)
                    take=value[i]+curr[w-weight[i]];

                curr[w]=Math.max(take,notTake);
            }
        }
        
        return curr[maxWeight];
	}
	
	
	
	//Memoization
	/*
	 * The idea is to try all possibilities
	 * Use take/not take technique, and thus find all the subsequences and their sum
	 */
	public static int helper(int n, int[] weight, int[] value, int maxW, int[][] dp){
        
		//if we reach the 0th index
		//Then if the weight of the 0th item is less than or equal to the bag weight then return it 
        if(n==0){
            if(weight[n]<=maxW)
                return value[n];
            return 0;
        }
        
        //if already calculated
        if(dp[n][maxW]!=-1)
            return dp[n][maxW];
        
        //dont take the curr item, just move forward
        int notTake=0+helper(n-1,weight,value,maxW,dp);
        int take=0;
        //Then if the weight of the curr item is less than or equal to the bag weight then call the funtion
        //with bag weight reduced
        if(weight[n]<=maxW)
            take=value[n]+helper(n-1,weight,value,maxW-weight[n],dp);
        
        return dp[n][maxW]=Math.max(take,notTake);
    }
	
	public static void main(String[] args) {
		
		int[] w= {1,2,4,5};
		int[] v= {5,4,8,6};
		
		System.out.println(knapsack(w, v, w.length, 5));
	}

}
