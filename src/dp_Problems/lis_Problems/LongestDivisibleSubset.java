package dp_Problems.lis_Problems;
import java.util.*;
/*
 * You are given an array of distinct numbers ‘arr’. Your task is to return the largest subset 
 * of numbers from ‘arr’, such that any pair of numbers ‘a’ and ‘b’ from the subset satisfies 
 * the following: a % b == 0 or b % a == 0.
 */
public class LongestDivisibleSubset {
	/*
	 * Similar to LIS, but in this we need to find the longest divisible subset that means 
	 * the elements need not be in a sequence.
	 * 
	 * First sort them, the reason being
	 * if a bigger number is divisible by a smaller number, then if the next bigger number 
	 * is divisible by the curr big number then it will also be divisible by the small number
	 * in this way find the longest subset possible
	 * 
	 */
	public static ArrayList<Integer> divisibleSet(int arr[]) {
        // Write your code here..
        int n=arr.length;
        
        //sort the array first
        Arrays.sort(arr);
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        
        //to trace back all the elemets of the longest subset
        int[] hash=new int[n];
        int max=1;
        int mindex=0;
        for(int curr=1;curr<n;curr++){
            hash[curr]=curr;
            for(int prev=0;prev<curr;prev++){
            	//instead of checking if the curr number is greater 
            	//check whether it's divisible or not.
                if(arr[curr]%arr[prev]==0 && dp[prev]+1>dp[curr])
                {
                    dp[curr]=dp[prev]+1;
                    hash[curr]=prev;
                    
                    if(dp[curr]>max){
                        max=dp[curr];
                        mindex=curr;
                    }
                }
            }
        }
        
        ArrayList<Integer> ans=new ArrayList<>();
        
        while(true){
            ans.add(arr[mindex]);
            if(mindex==hash[mindex])
                break;
            mindex=hash[mindex];
        }
        
        return ans;
    }
}
