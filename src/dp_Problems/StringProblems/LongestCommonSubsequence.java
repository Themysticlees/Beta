package dp_Problems.StringProblems;
import java.util.*;
//We need to find the longest common string, but the characters need not be the in the same sequence
//however the match must not criss cross, if we match two characters, we move forward and we cannot check
//the previous characters
public class LongestCommonSubsequence {
	
	//Recursive approach O(2^n)
	public static int LCS(String s1, String s2) {
    	
		//if we get an empty string
    	if(s1.length()==0 || s2.length()==0)
    		return 0;
    	
    	//if the character matches,then move both the indexes forward and add 1 as this particular
    	//character matched
    	if(s1.charAt(0) == s2.charAt(0))
    	{
    		return 1+LCS(s1.substring(1),s2.substring(1));
    	}
    	
    	//if we don't get a match, then make two checks, 
    	//one with the next element of the first string and same element of the second string
    	//another with the same element of the first string and the next element of the second string
    	//since we need to find the longest subsequence, we have to check all the possibilities
    	return Math.max(LCS(s1.substring(1),s2), LCS(s1,s2.substring(1)));
    }
	
	//The problem with the recursive solution is, we are performing unnecessary checks, if we have already
	//checked for particular indexes then no need to check it again. Thus we can store that somewhere
	//to save time
    
	//Memoization
	public static int helper(int n, int m, String s, String t, int[][] dp){
        
		//If any one of the strings gets finished checking then no need to check anymore
		//return 0
        if(n<0 || m<0){
            return 0;
        }
        
        //if already calculated
        if(dp[n][m]!=-1)
            return dp[n][m];
        
        /*
         * If the characters at the indexes match, then move both the indexes forward
         * Otherwise do two function calls with one index moving forward at a time and return the max of them
         */
        if(s.charAt(n)==t.charAt(m))
            return dp[n][m]=1+helper(n-1,m-1,s,t,dp);
        else
            return dp[n][m]=Math.max(helper(n-1,m,s,t,dp),helper(n,m-1,s,t,dp));
    }
	
	//Tabulation (No recursion call)
	public static int tabulation(String s, String t) {
		
		int n=s.length();
        int m=t.length();
        
        //The reason we are creating a 2D array of size n+1 and m+1 is, the base condition says that
        //if either of the indexes become negative then return 0, but we can't declare that in the array
        //As array don't have negative indexes
        //Thus we have used Index Shifting technique where the 0th row and 0th column will be treated 
        //as the negative indexes and thus we'll add a space before the strings
        int[][] dp = new int[n+1][m+1];
        
        s=" "+s;
        t=" "+t;
        
        //Declare the base cases
        for(int i=0;i<=m;i++)
            dp[0][i]=0;
        for(int i=0;i<=n;i++)
            dp[i][0]=0;
        
        //Copy the recurrence relation and return the final ans
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i)==t.charAt(j))
                    dp[i][j]=1+dp[i-1][j-1];
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        
        //Print the longest subsequence
        printLCS(n,m,s,t,dp);
        
        return dp[n][m];
	}
	
	/*
	 * We can print the LCS using the dp table formed by tabulation method.
	 * We'll start from the end, if the characters of the indexes match, then just add that character
	 * to the ans string and move to i-1 and j-1
	 * If the characters do not match, then check if dp[i-1][j] is greater than dp[i][j-1]
	 * If it satisfies then move to i-1 but dont add any character
	 * 
	 * We are simply checking which characters were same thus going backwards to print the subsequence
	 */
	public static void printLCS(int n, int m, String s, String t, int[][] dp) {
		// TODO Auto-generated method stub
			
		String ans="";
		while(n>0 && m>0) {
			
			if(s.charAt(n)==t.charAt(m)) {
				ans=s.charAt(n)+ans;
				n--;
				m--;
			}
			else if(dp[n-1][m]>dp[n][m-1])
				n--;
			else
				m--;
		}
		
		System.out.println(ans);
	}

	public static int lcs(String s1, String s2) {
        //Your code goes here
		int n=s1.length();
        int m=s2.length();
        
        int[][] dp = new int[n][m];
	    
        for(int[] i:dp)
	      Arrays.fill(i,-1);
        
//        return helper(n-1, m-1, s1, s2, dp);
        
        return tabulation(s1, s2);
	        
	}
    
    public static void main(String[] args) {
		
    	String s1="bbabcbcab";
		String s2="bacbcbabb";
		
		
        System.out.println(lcs(s1,s2));
	}

}
