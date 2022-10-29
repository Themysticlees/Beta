package dp_Problems.partitionProblems;
import java.util.*;
/*
 * video link: https://www.youtube.com/watch?v=_H8V5hJUGd0&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=54
 * 
 * Given a string ‘str’. Find the minimum number of partitions to make in the string such that 
 * every partition of the string is a palindrome.
 * 
 * Given a string, make cuts in that string to make partitions containing substrings with size 
 * at least 1, and also each partition is a palindrome. For example, consider “AACCB” we can make 
 * a valid partition like A | A | CC | B. Among all such valid partitions, return the minimum number 
 * of cuts to be made such that the resulting substrings in the partitions are palindromes.
 * The minimum number of cuts for the above example will be AA | CC | B. i.e 2 cuts
 */
public class Palindrome_Partition {
	/*
	 * Thus we have to check every possibilities for making partition and check for palindrome
	 */
	public static int palindromePartitioning(String str) {
	    // Write your code here
        int n=str.length();
        int[] dp = new int[n];
        
        Arrays.fill(dp,-1);
        return helper(0,n,str,dp)-1;
	}
    
	//Palindrome check function
    public static boolean isPalindrome(int i, int j, String str){
        
        while(i<=j){
            if(str.charAt(i)!=str.charAt(j))
                return false;
            i++;
            j--;
        }
        
        return true;
    }
    
    //Memoization
    public static int helper(int i, int n, String str, int[] dp){
        //if no character is left to check, just return 0 as we cannot make any partitions
        if(i>=n)
            return 0;
        
        if(dp[i]!=-1)
            return dp[i];
        
        int min=Integer.MAX_VALUE;
        //We'll pick every character and check if it becomes a palindrome,
        //If it becomes , then we make a partition and call the function for the right side
        //as left side is a palindrome (already checked).
        for(int ind=i;ind<n;ind++){
            if(isPalindrome(i,ind,str)){
                int partitions=1+helper(ind+1,n,str,dp);
                //check for the min partitions returned from the right side
                min=Math.min(min,partitions);
            }
        }
        //store the value and return 
        return dp[i]=min;
    }
    
    //Tabulation
    public static int tabulation(String str) {
    	
    	int n=str.length();
        int[] dp = new int[n+1];

        //Base case not needed as the value is 0.
        
        //reverse to the memoization, will start from n-1 to 0
        for(int i=n-1;i>=0;i--){
            int min=Integer.MAX_VALUE;
            for(int ind=i;ind<n;ind++){
                if(isPalindrome(i,ind,str)){
                    int partitions=1+dp[ind+1];
                    min=Math.min(min,partitions);
                }
            }

            dp[i]=min;
        }
        
        return dp[0]-1;
    }

}
