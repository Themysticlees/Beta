package dp_Problems.SubsetsProblems;
/*
 * Partition a set into two subsets such that the difference of subset sums is minimum.
 * Problem link: https://www.codingninjas.com/codestudio/problems/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum_842494?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0
 * 
 * You are given an array, your task is to partition the given array into two subsets such as the absolute
 * difference between them is minimum
 * 
 * Input:
 * 4
 * 1 2 3 4
 * 
 * Output: 
 * 0
 * 
 * We can partition the given array into {2,3} and {1,4}, as this will give us the minimum possible 
 * absolute difference i.e (5-5=0) in this case.
 */
public class PartitionSubset2 {
	
	/*
	 * So the first task is to find all the subsets and calculate the difference between them
	 * Now we only need to find the sum one subset, the other will be (total sum - sum of 1st subset)
	 * The tabulation table will help us with finding all the subsets, the tabulation table contains
	 * the combination of all cases, thus if the array contains the subset of a particular sum can be easily 
	 * identified.
	 * 
	 * So the last row i.e n-1th will tell us if the array contains a subset from sum 0->target
	 */
	public static int minSubsetSumDifference(int[] arr, int n) {
		// Write your code here.
		//Calculate total sum
        int sum=0;
        for(int i=0;i<n;i++)
            sum+=arr[i];
            
        boolean[][] dp = new boolean[n][sum+1];
        
        //if target becomes zero then the array contains such subset
        //so mark these cases true
        for(int i=0;i<n;i++)
            dp[i][0]=true;
        
        //for the 0th index, if target is equal to the 0th number then mark it as true
        if(arr[0]<=sum)
            dp[0][arr[0]]=true;
        
        //Now solve for all the other indexes for all target values
        for(int ind=1;ind<n;ind++){
            for(int tar=1;tar<=sum;tar++){
                
                boolean notTake=dp[ind-1][tar];
                boolean take=false;
                if(arr[ind]<=tar)
                    take=dp[ind-1][tar-arr[ind]];
                
                dp[ind][tar]=notTake || take;
            }
        }
        
        int min=9999;
        //iterate through the last row, and calculate the min absoulte difference
        for(int i=0;i<=sum;i++){
            if(dp[n-1][i]){
                int temp=i;
                int temp2=sum-i;
                
                min=Math.min(min,(int)Math.abs(temp-temp2));
            }
        }
        
        return min;
	}
}
