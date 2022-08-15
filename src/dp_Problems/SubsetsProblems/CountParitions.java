package dp_Problems.SubsetsProblems;
import java.util.*;
/*
 * You are given an array, you are required to make partitions such that S1>S2 and S1-S2=D
 * D is provided to you, you have to calculate the number of such partitions that can be made.
 * 
 * Input:
 * 4 3
 * 5 2 6 4
 * 
 * Output:
 * 1
 * 
 * We will print 1 because :
 * There is only one possible partition of this array.
 * Partition : {6, 4}, {5, 2}.
 * The subset difference between subset sum is: (6 + 4) - (5 + 2) = 3
 */
public class CountParitions {
	/*
	 * The idea is to find subsets, S1-S2=D ---> 1
	 * Total sum = S1+S2
	 * S1=Total-S2 ---> 2
	 * Replace S1 int the first equation with the 2nd equation
	 * 
	 * Total-S2-S2=D
	 * Total-2S2=D
	 * S2=Total-D/2
	 * 
	 * Thus find a subset whose sum is (Total-D)/2
	 */
	public static int countPartitions(int n, int d, int[] arr) {
		// Write your code here.
        
        int total=0;
        for(int i=0;i<n;i++)
            total+=arr[i];
        
        //Two base cases, if the total-D becomes less than 0, then no subset will exists
        //or if it is odd then also no subset is possible
        if(total-d<0 || ((total-d)&1) !=0)
            return 0;
        
        int tar=(total-d)/2;
        
        int[][] dp = new int[n][tar+1];
        
        for(int[] i:dp)
            Arrays.fill(i,-1);
        
        //Now simply call No.of subsets and return the ans
        return NumberOfSubsets.tabulation(arr,tar);
	}
	
	public static void main(String[] args) {
		
		int[] arr= {1,1,1,1};
		System.out.println(countPartitions(arr.length, 2, arr));
	}

}
