package dp_Problems.StringProblems;
import java.util.*;
/*
 * Problem link: https://www.codingninjas.com/codestudio/problems/wildcard-pattern-matching_701650?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0
 * 
 * Given a text and a wildcard pattern of size N and M respectively, implement a 
 * wildcard pattern matching algorithm that finds if the wildcard pattern is matched with the text. 
 * The matching should cover the entire text not partial text.
 * 
	 The wildcard pattern can include the characters ‘?’ and ‘*’
	 ‘?’ – matches any single character 
	 ‘*’ – Matches any sequence of characters(sequence can be of length 0 or more)
 
 
 */
public class WilcardPatternMatching {
	/*
	 * This is like string matching but with ? and *
	 * The idea will be to start with two pointers and keep checking.
	 */
	public static boolean wildcardMatching(String pattern, String text) {
		// Write your code here.
        int n=pattern.length();
        int m=text.length();
        
        int[][] dp = new int[n][m];
        
        for(int[] i:dp)
            Arrays.fill(i,-1);
        
        return helper(n-1,m-1,pattern,text,dp);
	}
	
	//1D array space optimaztion
	public static boolean spaceOptimized(String p, String t) {
		
		int n=p.length();
        int m=t.length();
        
        //Instead of using a whole 2D array, we just need the current and previous rows to
        //calculate all the values
        boolean[] prev = new boolean[m+1];
        boolean[] curr =  new boolean[m+1];
        
        //--Base case---//
        //0th row and 0th column i.e both strings empty store true
        prev[0]=true;
        //0th row so all j values from 1->m will store false
        for(int j=1;j<=m;j++)
            prev[j]=false;

        //Now when j becomes empty and i remains, that case will be checked for each row
        //Since we dont have the entire 2D array, thus we need evaluate it for every row
        for(int i=1;i<=n;i++){

        	//checking if all the characters of i are starts when j is 0
                boolean flag=true;
                for(int x=1;x<=i;x++){
                        if(p.charAt(x-1)!='*'){
                            flag=false;
                            break;
                        }
                 }
                 curr[0]=flag;
            
            //rest is the recurrence relation
            for(int j=1;j<=m;j++){
                if(p.charAt(i-1)==t.charAt(j-1) || p.charAt(i-1)=='?')                   
                    curr[j]=prev[j-1];

                else if(p.charAt(i-1)=='*')
                    curr[j]=prev[j] || curr[j-1];
                else
                    curr[j]=false;
            }
            //prev becomes curr as we'll be calculating the next row
            prev=curr.clone();
        }
        
        return prev[m];
	}
	
	//Tabulation
	public static boolean tabulation(String p, String t) {
		
		int n=p.length();
        int m=t.length();
        
        boolean[][] dp = new boolean[n+1][m+1];
        
        //Base cases
        //Since this is tabulation method, we have used index shifting as -1 cant be represented as an index
        //Thus if both strings exhaust store true
        dp[0][0]=true;
        //if i exhausts return false for all values of j
        for(int j=1;j<=m;j++)
            dp[0][j]=false;
        
        //if j exhausts check if all the characters of i are stars or not
        for(int x=1;x<=n;x++){
            boolean flag=true;
            for(int i=1;i<=x;i++){
                    if(p.charAt(i-1)!='*')
                    {
                        flag=false;
                        break;
                    }
             }
             dp[x][0]=flag;
        }
        
        //Copy the recurrence relation
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(p.charAt(i-1)==t.charAt(j-1) || p.charAt(i-1)=='?')                   
                    dp[i][j]=dp[i-1][j-1];

                else if(p.charAt(i-1)=='*')
                    dp[i][j]=dp[i-1][j] || dp[i][j-1];
                else
                    dp[i][j]=false;
            }
        }
        
        return dp[n][m];
        
	}
    
	//Memoization
    public static boolean helper(int i, int j, String p, String t, int[][] dp){
        
    	//----------Base case--------------//
    	/*
    	 * if i and j both gets exhausted then we have matched both the strings, return true.
    	 * if i gets exhausted and j still remains, then we couldnt match thus return false
    	 * if i remains and j gets exhausted, then there is one 1 chance that they might match
    	 * if all the charaters of the pattern string are '*' then all the stars can match an empty 
    	 * string, Thus check for that
    	 */
        if(i<0 && j<0)
            return true;
        if(i<0 && j>=0)
            return false;
        //check if pattern string is all stars
        if(i>=0 && j<0){
            for(int x=0;x<=i;x++){
                if(p.charAt(x)!='*')
                    return false;
            }
            return true;
        }
        
        //if already calculated
        if(dp[i][j]!=-1)
            return (dp[i][j]==1)?true:false;
        
        /*
         * If the characters are same, then move ahead.
		 * If any one of characters of the pattern string is '?' then also move ahead as it will 
		 * match with any character.
         */
        if(p.charAt(i)==t.charAt(j) || p.charAt(i)=='?'){
            boolean ans=helper(i-1,j-1,p,t,dp);
            dp[i][j]=ans?1:0;
            return ans;
        }
        /*
         * If we encounter a '*', then '*' can match any sequence of characters,
         * thus there will be two possibilities, 
         * 1. the star matches will 0 length of characters so we just move ahead the pattern pointer
         * 2. the star matches the curr 'text' character and maybe more so we just move the text pointer
         * ahead.
         * 
         * Now whichever function call gives us true, we take it.
         */
        else if(p.charAt(i)=='*'){
            boolean ans=helper(i-1,j,p,t,dp) || helper(i,j-1,p,t,dp);
            dp[i][j]=ans?1:0;
            return ans;
        }
        
        //if none of conditions match, then strings wont match, simply return false
        dp[i][j]=0;
        return false;
    }

}
