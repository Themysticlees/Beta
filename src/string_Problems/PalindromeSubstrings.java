package string_Problems;

/*
 * Given a string s, return the number of palindromic substrings in it.
 * A string is a palindrome when it reads the same backward as forward.
 * A substring is a contiguous sequence of characters within the string.
 * 
 *  Input: s = "aaa"
	Output: 6
	Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 */
public class PalindromeSubstrings {
	
	public int countSubstrings(String s) {
        
        //odd palindromes
        int n=s.length();
        int count=0;
        
        //we'll take two pointers and expand them and check for palindrome
        //if the left and right characters of a palindrome is same then the new string is also palindrome
        //we'll use this concept to check for palindrome
        for(int i=0;i<n;i++){
            
        	
            int start=i;
            int end=i+1;
            count++;
            
            //if the characters are same increase counter
            while(start>=0 && end<n && s.charAt(start)==s.charAt(end))
            {
                count++;
                start--;
                end++;
            }
        
        //even palindromes
        
            start=i-1;
            end=i+1;
            
            while(start>=0 && end<n && s.charAt(start)==s.charAt(end))
            {
                count++;
                start--;
                end++;
            }
            
        }
        return count;
        
    }

}
