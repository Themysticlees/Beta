package dp_Problems;

//We need to find the longest common string, but the characters need not be the in the same sequence
//however the match must not criss cross, if we match two characters, we move forward and we cannot check
//the previous characters
public class LongestCommonSubsequence {
	
	//Recursive approach O(2^n)
	public static int LCS(String s1, String s2) {
    	
		//if we get an empty string
    	if(s1.equals(" ") || s2.equals(" "))
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
    
	//DP approach O(m*n)
    public static int LCS(String s1, String s2, int[][] arr) {
    	
    	//same approach as the recursive one
    	//however this is bottom  up approach
    	//we are storing the checks in a 2d array
    	for(int i=1;i<arr.length;i++) {
    		
    		for(int j=1;j<arr[0].length;j++) {
    			
    			//if we get a check then add one and move both the indexes
    			if(s1.charAt(i)==s2.charAt(j))
    				arr[i][j]=1+arr[i-1][j-1];
    			else
    				arr[i][j]=Math.max(arr[i][j-1], arr[i-1][j]);
    			
    			//if not, then check the other possibilities
    		}
    	}
    	
    	return arr[arr.length-1][arr.length-1];
    }

}
