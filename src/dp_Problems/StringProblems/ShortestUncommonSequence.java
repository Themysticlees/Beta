package dp_Problems.StringProblems;
import java.util.*;
/*
 * Given two strings S and T, find length of the shortest subsequence in S which is not a subsequence in T. 
 * If no such subsequence is possible, return -1. A subsequence is a sequence that appears in the 
 * same relative order, but not necessarily contiguous. A string of length n has 2^n different 
 * possible subsequences.
 * 
 *  Example 1:

	Input:
	S = "babab"
	T = "babba"
	Output:
	3
	Explanation:
	There are no subsequences of S with
	length less than 3 which is not a
	subsequence of T. "aab" is an example of
	a subsequence of length 3 which isn't a
	subsequence of T.
	Example 2:
	
	Input:
	S = "babhi"
	T = "babij"
	Output:
	1
	Explanation:
	"h" is a subsequence of S that is
	not a subsequence of T.
 */
public class ShortestUncommonSequence {
	/*
	 * We have to use recursion and memorization to solve this problem
	 * We'll start from the base case, 
	 * if size of S is 0, then we cannot form a subsequence of S, thus return -1
	 * if size of T is 0, then any 1 character from S can be the subsequence which is not present in T 
	 * thus return 1
	 * 
	 * If these conditions doesn't match, then search for the current element of S in T
	 * if not found, then we can say, that character is the subsequence thus return 1
	 * if found, then you can include that character or exclude that character to form the ans
	 * whichever comes to have the min length we'll return that.
	 */
	static int shortestUnSub(String S, String T) {
        // code here
        int n=S.length();
        int m=T.length();
        
        int[][] dp = new int[n+1][m+1];
        
        for(int[] i:dp)
            Arrays.fill(i,-1);
            
        int ans=helper(n,m,S,T,dp);
        
        if(ans==999)
            return -1;
        return ans;
    }
    
	//n and m are the current lengths left to check
	//since we have to check all the possible subsequences
    static int helper(int n, int m, String s, String t, int[][] dp){
        //if s becomes 0, then return 999
    	//we are not return -1 as if we have a short subsequcne then -1 will overwrite it
    	//thus we return any large no. and later we'll check it
        if(n==0)
            return 999;
        if(m==0)
            return 1;
        
        //if we have already calculated then just return it
        if(dp[n][m]!=-1)
            return dp[n][m];
        
        //current character from s
        int key=s.charAt(n-1);
        int i;
        //check if it is present in t
        for(i=m-1;i>=0;i--)
        {
            if(t.charAt(i)==key)
                break;
        }
        
        int ans=0;
        //if not present simply return 1 since the character itself is the shortest subsequence
        if(i==-1)
            ans= 1;
        else{
        	//otherwise take the min of both
        	//1. include the character 2. exclude the character
            ans=Math.min(helper(n-1,m,s,t,dp),helper(n-1,i,s,t,dp)+1);
        }
        
        return dp[n][m]=ans;
    }
    
    public static void main(String[] args) {
		String s="babab";
		String t="babba";
		
		System.out.println(shortestUnSub(s, t));
	}

}
