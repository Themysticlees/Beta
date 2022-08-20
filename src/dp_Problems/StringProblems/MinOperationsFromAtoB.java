package dp_Problems.StringProblems;
import java.util.*;
/*
 * Problem Link: https://www.codingninjas.com/codestudio/problems/edit-distance_630420?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0
 * 
 * You are given two strings 'S' and 'T' of lengths 'N' and 'M' respectively. 
 * Find the "Edit Distance" between the strings.
 * Edit Distance of two strings is the minimum number of steps required to make one string 
 * equal to the other. In order to do so, you can perform the following three operations:
 * 
	1. Delete a character
	2. Replace a character with another one
	3. Insert a character
 */
public class MinOperationsFromAtoB {
	/*
	 * This is similar to the problem Min Operations(Insert and Delete) to convert A to B. However there
	 * we first calculated the LCS between two strings.
	 * Then the remaining characters from String A were deleted and the remaining characters from 
	 * String B were added in String A
	 * 
	 * Thus total operations : characters deleted from string A + 
	 * 													characters from string B added to String A
	 * 
	 * This problem is slightly different as we can Replace characters now.
	 * Thus doing LCS wont give us the min operations required. 
	 */
	public static int editDistance(String str1, String str2) {
        //Your code goes here
        int n=str1.length();
        int m=str2.length();
        
        int[][] dp = new int[n][m];
        for(int[] i:dp)
            Arrays.fill(i,-1);
        
        return helper(n-1,m-1,str1,str2,dp);
    }
    /*
     * If the characters are equal then we dont need to do any operations, simply move ahed
     * otherwise we have to check for all the ways, 
     * 1. Insert
     * 2. Delete
     * 3. Replace
     * 
     * and which ever gives me the min operations just return that
     */
    public static int helper(int i,int j,String s1,String s2,int[][] dp){
        
    	//-------------Base cases-------------//
    	/*
    	 * If string A (i<0) exhausts, then inorder to convert from A to B, we need add the remaning
    	 * characters of B to A thus return j+1 (rem characters of B)
    	 * 
    	 * If string B (j<0) exhausts, then just remove the extra characters of string A thus
    	 * return i+1;
    	 */
        if(i<0)
            return j+1;
        if(j<0)
            return i+1;
        
        if(dp[i][j]!=-1)
            return dp[i][j];
        
        //if the characters are same then no operation required thus this will minimun 
        //compared to the other ones so just return it, no need to check it again.
        if(s1.charAt(i)==s2.charAt(j))
            return dp[i][j]=helper(i-1,j-1,s1,s2,dp);
        //otherwise perform all the operations and return the min of them
        else
        {
            //delete 
        	//if we delete from string A, then move index i by 1
            int a=1+helper(i-1,j,s1,s2,dp);
            //insert
            //if we insert then we match the characters then just move j by 1 and i remains same
            int b=1+helper(i,j-1,s1,s2,dp);
            //replace
            int c=1+helper(i-1,j-1,s1,s2,dp);
            
            return dp[i][j]=Math.min(a,Math.min(b,c));
        }
    }
    
    //Tabulation
    public static int tabulation(String str1, String str2) {
    	
    	int n=str1.length();
        int m=str2.length();
        
        int[][] dp = new int[n+1][m+1];

        //---------Base case----------//
        for(int i=0;i<=n;i++)
            dp[i][0]=i;
        for(int j=0;j<=m;j++)
            dp[0][j]=j;
        
        //Copy the recurrence relation
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1];
                else
                {
                    //delete 
                    int a=1+dp[i-1][j];
                    //insert
                    int b=1+dp[i][j-1];
                    //replace
                    int c=1+dp[i-1][j-1];

                    dp[i][j]=Math.min(a,Math.min(b,c));
                }
            }
        }
        
        return dp[n][m];
    }

}
