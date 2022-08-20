package dp_Problems.StringProblems;

/*
 * In this problem, you have find the the longest common substring which means the characters
 * needs to be consecutive.
 */
public class LongestCommonSubstring {
	
	/*
	 * This is similar to LCS, but in LCS if the characters didnt match, we made two functions calls
	 * but here if they dont match then we dont need to do anything as if the middle character
	 * didnt match then it is not a substring. 
	 * Thus even if we had moved forward and did get some character match still it wont matter as 
	 * the match wont be consecutive.
	 * 
	 * Thus if we get a match, we check the previous characters and store the max length found so far
	 */
	public static int lcs(String str1, String str2) {
        // Write your code here.
        int n=str1.length();
        int m=str2.length();
        
        str1=" "+str1;
        str2=" "+str2;
        
        int[][] dp = new int[n+1][m+1];
        
        int max=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
            	
            	//if it matches, check for the prev indexes and store the max value found so far
                if(str1.charAt(i)==str2.charAt(j)){
                    dp[i][j]=1+dp[i-1][j-1];
                    max=Math.max(max,dp[i][j]);
                }
            }
        }
        
        return max;
    }
	
	public static void main(String[] args) {
		String s1="tyfg";
		String s2="cvbnuty";
		
		System.out.println(lcs(s1, s2));
	}
}
