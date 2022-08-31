package dp_Problems.lis_Problems;
import java.util.*;
/*
 * Given an integer array ‘ARR’ of length ‘N’, return the number of longest increasing 
 * subsequences in it.
 * The longest increasing subsequence(LIS) is the longest subsequence of the given 
 * sequence such that all elements of the subsequence are in increasing order.
 * 
 * Let ‘ARR’ = [50, 3, 90, 60, 80].
 * In this array the longest increasing subsequences are [50, 60, 80] and [3, 60, 80]. 
 * There are other increasing subsequences as well but we need the number of longest ones. 
 * Hence the answer is 2.
 */
public class NumberOfLIS {
	/*
	 * Here we need to maintain a count array to count the max subsequences formed for a 
	 * particular element
	 * Now while checking with the prev element, if it matches with the max subsequence length
	 * then we add the prev elements count with the curr element's count. That will be the total count 
	 * of the subsequences of the particular length
	 * 
	 * If the lenght is greater than the curr element max length, then just assign the count of the 
	 * prev element as previous count will be discarded.
	 */
	public static int findNumberOfLIS(int n, int[] arr) {
		// Write your code here.
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        
        int[] count=new int[n];
        Arrays.fill(count,1);
        int max=1;
        for(int curr=1;curr<n;curr++){
            for(int prev=0;prev<curr;prev++){
                
                if(arr[curr]>arr[prev] && dp[prev]+1>=dp[curr])
                {
                	//if max length is same, just add count to the curr count array
                    if(dp[prev]+1==dp[curr])
                        count[curr]+=count[prev];
                    else{
                    	//otherwise update the max length and initialize count with the prev element count
                        dp[curr]=dp[prev]+1;
                        count[curr]=count[prev];
                    }
                    
                    //keep a track of the max length found so far
                    max=Math.max(dp[curr],max);
                }
            }
        }
        int total=0;
        for(int i=0;i<n;i++){
        	//add all the counts of the elements which have the longest increasing subsequence length
            if(dp[i]==max)
                total+=count[i];
                
        }
        return total;
	}

}
