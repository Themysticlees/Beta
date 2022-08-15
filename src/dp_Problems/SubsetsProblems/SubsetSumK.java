package dp_Problems.SubsetsProblems;
import java.util.*;

/*
 * Problem link: https://www.codingninjas.com/codestudio/problems/subset-sum-equal-to-k_1550954?leftPanelTab=0
 * 
 * Given an array arr[], find a subset whose sum is equal to target. If such subset is found, return true 
 * otherwise false.
 * 
 * Input:
 * 4 5
 * 4 3 2 1
 * 
 * Output:
 * true
 * 
 * In example 1, ‘ARR’ is {4,3,2,1} and ‘K’ = 5. There exist 2 subsets with sum = 5. 
 * These are {4,1} and {3,2}. Hence, return true.
 */
public class SubsetSumK {
	
	/*
	 * In order to solve this problem, we'll use the concept of pick and not pick, by this we can generate
	 * all the subsets/subsequences. Now we'll just check if the subset sum is equak to target or not.
	 */
	
	//Memoization
	static boolean subsetSumUtil(int ind, int target,int[] arr,int[][] dp){
		//If target becomes zero, then we have got a subset whose sum is equal to target
		//Here target will decrease as we are subtracting the elements from the target
        if(target==0)
            return true;

        //If we reach the 0th index, and the target remaining is equal to the element in that index
        //Then return true
        if(ind == 0)
            return arr[0] == target;

        //if we have already calculated for the particular index and target, then return the stored value
        //here we are using a int dp array instead of boolean, as we need to mark the elements unvisited
        //by marking them with -1
        //Thus we'll check the stored value and return accordingly
        if(dp[ind][target]!=-1)
            return dp[ind][target]==0?false:true;

        //First we wont take the curr element and move ahead, in this case target remains unchanged
        boolean notTaken = subsetSumUtil(ind-1,target,arr,dp);
        
        //Next we'll take the curr element if it is less or equal to target
        //and move ahead, we'll subtract the element from target
        boolean taken = false;
        if(arr[ind]<=target)
            taken = subsetSumUtil(ind-1,target-arr[ind],arr,dp);
        
        //now return and store in the dp array accordingly
        //if either of the one returned true, then store 1 else 0
        dp[ind][target]=notTaken||taken?1:0;
        return notTaken||taken;
    }
	
	static boolean subsetSumToK(int n, int k,int[] arr){
		
	      int dp[][]=new int[n][k+1];
	      for(int row[]: dp)
	      Arrays.fill(row,-1);
	     
	      return subsetSumUtil(n-1,k,arr,dp);
	}
	
	//Tabulation (No recursion)
	static boolean tabulation(int n, int k,int[] arr) {
		
		//We can use a boolean array as we just need the values to calculate (no checking)
		//First index represents the index of the array, Second one represents the target
		boolean dp[][]=new boolean[n][k+1];
        
		//-----------------Write down the base cases--------------------
		/*
		 * If target becomes 0, then we return true, thus mark all the elements true where target is 0
		 * For the 0th index, if the value of that element is equal to target then mark it true
		 * This is only valid if 0th element is <= target
		 */
        for(int i=0;i<n;i++)
            dp[i][0]=true;
        
        if(arr[0]<=k)
            dp[0][arr[0]]=true;
        
        /*
         * Now compute for every index and for every target value
         * index will start from 1, since at index 0 there's only 1 possibility and target will also
         * start from 1 as we have marked the elements with target 0
         */
        for(int ind=1;ind<n;ind++){
            for(int tar=1;tar<=k;tar++){
            	/*
            	 * Now for every target we'll compute the not take and take condition
            	 * and store the values returned
            	 */
                boolean notTaken = dp[ind-1][tar];
                boolean taken = false;
                if(arr[ind]<=tar)
                    taken = dp[ind-1][tar-arr[ind]];
                dp[ind][tar]=notTaken||taken;
            }
        }
        
        //since we started from n-1 with target k, thus return the value computed at that index
        return dp[n-1][k];
	}

}
