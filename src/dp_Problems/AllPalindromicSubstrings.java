package dp_Problems;

/*
 * Given a string, the task is to count all palindromic sub-strings present in it. 
 * Length of palindrome sub-string must be greater than or equal to 2. 
 *
 * Input
	N = 5
	str = "abaab"
	Output
	3
	Explanation:
	All palindrome substring are : "aba" , "aa" , "baab"
 */
public class AllPalindromicSubstrings {
	
	public static int findCount(String str) {
		
		//we'll be storing all the substrings in the 2d matrix
		//and we'll check them diagonally
		int n=str.length();
		boolean[][] dp = new boolean[n][n];
		
		int count=0;
		
		//gp represents gap, as we increase the gap we check each diagonal
		//each diagonal has gap+1 characters so we'll check accordingly
		for(int gp=1;gp<n;gp++) {
			//i will start from 0, as all the diagonals start from 1st row
			int i=0,j=gp;
			
			//j will continue to n-1 as all the diagonals end at the last column
			while(j<n) {
				
				//when gap is 0, then there is 1 character which is palindromic 
				//so we'll update the index to true
				if(gp==0) {
					dp[i][j]=true;
					//count++;
				}
				//when gap is 1, then two characters are there, thus check both indexes
				//if they are same then update to true
				else if(gp==1)
				{
					if(str.charAt(i)==str.charAt(j)) {
						dp[i][j]=true;
						count++;
					}
					else 
						dp[i][j]=false;
				}
				//if gap is more than 1, thus more than 2 characters, thus we need to check
				//whether the last two characters are same and the substring(i+1 to j-1) must be palindromic
				//since we are keeping the results in a 2d matrix then we can easily find whether 
				//their middle substring is palindromic or not
				else
				{
					if(str.charAt(i)==str.charAt(j) && dp[i+1][j-1]==true) {
						dp[i][j]=true;
						count++;
					}
					else
						dp[i][j]=false;
				}
				i++;
				j++;
			}
		}
		return count;
	}
	public static void main(String[] args) {
		System.out.println(findCount("aaaaa"));
	}

}
