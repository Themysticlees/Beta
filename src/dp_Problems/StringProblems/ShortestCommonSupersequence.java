package dp_Problems.StringProblems;

/*
 * 
 * Given two strings, ‘A’ and ‘B’. Return the shortest supersequence string ‘S’, 
 * containing both ‘A’ and ‘B’ as its subsequences. If there are multiple answers, return any of them.
 * 
 * Note: A string 's' is a subsequence of string 't' if deleting some number of characters 
 * from 't' (possibly 0) results in the string 's'.
 * 
 * For Example:
 * Suppose ‘A’ = “brute”, and ‘B’ = “groot”
 * 
 * The shortest supersequence will be “bgruoote”. As shown below, it contains both ‘A’ and ‘B’ 
 * as subsequences.

	A   A A     A A
	b g r u o o t e
	  B B   B B B  
	
	It can be proved that the length of supersequence for this input cannot be less than 8. 
	So the output will be bgruoote.
 */
public class ShortestCommonSupersequence {
	/*
	 * So in simple terms, we have a make a string which contains both String A and B as subsequences.
	 * Inorder to find the length of such string first calculate the LCS of both the strings
	 * After that just add the remaining characters left in both the strings.
	 * Thus we can get the length of the min supersequence
	 * 
	 */
	public static String shortestSupersequence(String a, String b) {
        // Write your code here..
        return lcs(a,b);
    }
    
	//Tabulation method
    public static String lcs(String s1, String s2){
        
        int n=s1.length();
        int m=s2.length();
        
        
        s1=" "+s1;
        s2=" "+s2;
        
        int[][] dp = new int[n+1][m+1];
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                
                if(s1.charAt(i)==s2.charAt(j))
                    dp[i][j]=1+dp[i-1][j-1];
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        /*
         * But here we have to return that supersequence string.
		 * We'll use the technique of printing the LCS using tabulation method
		 * So first we'll fill the dp table and then do the following steps
		 * 1. we'll start from the last index and keep checking
		 * 2. if both the characters are same, just add it to the final string and move both the indexes
		 * 3. if they dont match, then move to the index which is greater and as you move
		 * 		add that character to the final string
		 * (While printing LCS, we'll didnt add anything when the characters didnt match, but here, 
		 * since we are calculating the supersequence all the characters must be present in it and the 
		 * common ones shall be considered once.)
         */
        
        String ans="";
        while(n>0 && m>0){
            if(s1.charAt(n)==s2.charAt(m)){
                ans=s1.charAt(n)+ans;
                n--;m--;
            }
            else if(dp[n-1][m]>dp[n][m-1]){
                ans=s1.charAt(n)+ans;
                n--;
            }
            else{
                ans=s2.charAt(m)+ans;
                m--;
            }
        }
        
        //Since any one of the strings might get exhausted, thus add the remaining characters to
        //the final string and return it
        while(n>0){
            ans=s1.charAt(n)+ans;
            n--;
        }
        while(m>0){
            ans=s2.charAt(m)+ans;
            m--;
        }
            
        return ans;
    }

}
