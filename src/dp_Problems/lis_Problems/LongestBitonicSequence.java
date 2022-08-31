package dp_Problems.lis_Problems;
import java.util.*;
/*
 * You are given an array/list 'ARR' consisting of 'N' positive integers. 
 * A subsequence of 'ARR' is called bitonic if it is first increasing and then decreasing.
	For Example:
	An example of a bitonic sequence will be 1 < 2 < 3 < 4 > 2 > 1.
	Your task is to return the length of the longest bitonic sequence of 'ARR'.
 */
public class LongestBitonicSequence {
	/*
	 * If you observe carefully, this problem wants us to find a position upto which the numbers are
	 * increasing and after that decreasing.
	 * 
	 * Thus we have to find LIS from left to right and from right to left.
	 * left -> right will denote increasing and right->left will denote decreasing
	 * We'll store the max length subsequence for every element for both the LIS
	 * 
	 * Now for every element check the left->right LIS max length, right->left LIS max length
	 * and find the max of that, remember to subtract 1 as the current element will be taken twice
	 * once for increasing LIS and once for decreasing LIS.
	 * 
	 * Thus compare and calculate the max
	 * 
	 */
	public static int longestBitonicSequence(int[] arr, int n) {
        // Write your code here.
        
        int[] dp1=new int[n];
        Arrays.fill(dp1,1);
        
        //from left to right
        for(int curr=1;curr<n;curr++){
            for(int prev=0;prev<curr;prev++){
                
                if( arr[curr]>arr[prev] && dp1[prev]+1>dp1[curr])
                    dp1[curr]=dp1[prev]+1;    
            }
        }
        
        int[] dp2=new int[n];
        Arrays.fill(dp2,1);
        
        //from right to left
        for(int curr=n-2;curr>=0;curr--){
            for(int prev=n-1;prev>curr;prev--){
                if( arr[curr]>arr[prev] && dp2[prev]+1>dp2[curr])
                    dp2[curr]=dp2[prev]+1;    
            }
        }
        
        //check for the max increasing LIS and decreasing LIS length
        int max=1;
        for(int i=0;i<n;i++){
            if(dp1[i]+dp2[i]-1>max)
                max=dp1[i]+dp2[i]-1;
        }
        
        return max;
    }

}
