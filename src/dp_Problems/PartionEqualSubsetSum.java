package dp_Problems;

/*
 * Problem link: https://www.codingninjas.com/codestudio/problems/partition-equal-subset-sum_892980?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0
 * 
 * Given an array, you have to partition the array into two subsets whose sum are equal.
 * For eg:
 * Input: 
 * 6
 * 3 1 1 2 2 1
 * 
 * Output:
 * For the first test case, the array can be partitioned as ([2,1,1,1] and [3, 2]) or ([2,2,1], 
 * and [1,1,3]) with sum 5.
 *  
 */
public class PartionEqualSubsetSum {
	
	/*
	 * This is similar to subset sum with target k,
	 * We are told that the partitions made must have equal sum
	 * Thus, S1=S2, S1+S2=S (S= sum of the total array)
	 * replace S2 with S1 as they are similar, S1+S1=S, 2S1=S, S1=S/2
	 * 
	 * Thus we need to find a subset whose sum is equal to half the sum of the array
	 * If we can find one subset, the remaining elements will form the other subset.
	 */
	public static boolean canPartition(int[] arr, int n) {
		// Write your code here.
        
		//Calculate the sum of the array
        int sum=0;
        for(int i=0;i<n;i++)
            sum+=arr[i];
        
        //If the sum is odd, then we cannot make a partition as we need to find a subset whose
        //sum is half of the total sum
        if((sum&1) != 0)
            return false;
        
        //set the target as sum/2 and then call the SubsetSumK function
        //If we get any such subset with sum= sum/2 then it will return true
        int target=sum/2;
        
        return SubsetSumK.tabulation(n, target, arr);
	}
	
	public static void main(String[] args) {
		
		int[] arr= {3, 1, 1, 2, 2, 1};
		
		System.out.println(canPartition(arr,arr.length));
	}

}
