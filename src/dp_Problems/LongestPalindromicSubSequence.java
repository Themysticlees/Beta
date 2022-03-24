package dp_Problems;

/*
 * Given a string s, find the longest palindromic subsequence's length in s.

	A subsequence is a sequence that can be derived from another sequence by 
	deleting some or no elements without changing the order of the remaining elements.
	
	Similar to LCS (Longest Common SubSequence), you have the find the longest palindromic subsequence
	The characters may not be contiguous but needs to be in the same sequence or order
	
	Input: s = "bbbab"
	Output: 4
	Explanation: One possible longest palindromic subsequence is "bbbb".
 */

//A Palindrome a word or number which remains same if reversed
//If we reverse the string and find the lcs of the original and the reversed string, we must be getting 
//the longest palindromic subsequence, since the characters which are in a palindromic sequence will remain 
//the same even if they are reversed but all the other characters' positions  will change
//Thus taking the LCS of the two strings must give the LPS
public class LongestPalindromicSubSequence {
	
	public static String reverse(String s) {
		String res="";
        
        for(int i=s.length()-1;i>=0;i--)
            res+=s.charAt(i);
        return res;
	}
	
	public static int LPS(String s1) {
		
		String s2=reverse(s1);
		
		//calling the LCS function to find the common subsequence
		//since the strings are reverse of each other, the lcs must be palindromic as well
		return LongestCommonSubsequence.LCSDP(s1, s2);
	}
	
	public static void main(String[] args) {
		
		System.out.println(LPS("bbbab"));
	}
	

}
