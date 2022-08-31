package dp_Problems.lis_Problems;
import java.util.*;
/*
 * You are given an array ‘ARR’ of strings, where each string consists of English lowercase letters.
 * Let’s say a string ‘A’ is a predecessor of string ‘B’ if and only if we can add exactly one 
 * letter anywhere in ‘A’ to make it equal to ‘B’. For example “abd” is a predecessor of “abcd”, 
 * we can add “c” in “abd” to make a string “abcd”
 * A string chain is a sequence of strings where for every ‘i’ in [1 . . . (K - 1)], ‘Si’ is the 
 * predecessor of ‘Si+1’. And the length of such a string chain is ‘K’.
 * 
 * Now your task is to find the length of the longest possible string chain.
 * 
 * Let ‘ARR’ = ["x", “xx”, “y”, “xyx”] 
 * The longest possible string chain is “x” -> “xx” -> “xyx”
 * The length of the given chain is 3, hence the answer is 3.
 */
public class LongestStringChain {
	/*
	 * Similar to LIS, but here two strings differ by a single character
	 * Since this is not a subsequence, we can sort the strings acc to their length so that 
	 * we can get max length of the chain
	 * 
	 * Now simply pick a string and compare with all it's prev strings and update the dp array
	 */
	public static int longestStrChain(int n, String[] arr) {
		// Write your code here.
        
        //sort the array first
        Comparator<String> com=new Comparator<String>() {
            
            @Override
            public int compare(String a, String b) {
                // TODO Auto-generated method stub
                return a.length()-b.length();
            }
        };
        
        Arrays.sort(arr,com);
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        
        //to trace back all the elements of the longest subset
        int[] hash=new int[n];
        int max=1;
        int mindex=0;
        for(int curr=1;curr<n;curr++){
            hash[curr]=curr;
            for(int prev=0;prev<curr;prev++){
                //instead of checking if the curr number is greater 
                //compare the two strings
                if(compare(arr[curr],arr[prev]) && dp[prev]+1>dp[curr])
                {
                    dp[curr]=dp[prev]+1;
                    
                    //store the prev index to trace back
                    hash[curr]=prev;
                    
                    //if the curr length is greater than ma, update it
                    if(dp[curr]>max){
                        max=dp[curr];
                        mindex=curr;
                    }
                }
            }
        }
        
        return max;
	}
    
	/*
	 * This function will compare two strings and return true
	 * if they differ by 1 character
	 */
    public static boolean compare(String curr, String prev){
    	
    	//check the lengths of both
        if(prev.length()+1!=curr.length())
            return false;
       
        //two pointers for the strings
        int i=0,j=0;
        //count the dissimilar characters
        int count=0;
        while(i<curr.length()){
        	//if both the characters match, simply move ahead
            if(j<prev.length() && prev.charAt(j)==curr.charAt(i))
            {
                i++;
                j++;
            }
            //otherwise increase count and i(curr string pointer) as it will have that extra character
            else{
                count++;
                i++;
            }
        }
        
        
        //if count is 1 i.e only 1 character is not present return true
        if(count==1)
            return true;
        return false;
    }

}
