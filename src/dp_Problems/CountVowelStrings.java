package dp_Problems;
import java.util.*;
/*
 * Given an integer n, return the number of strings of length n that 
 * consist only of vowels (a, e, i, o, u) and are lexicographically sorted.
 * A string s is lexicographically sorted if for all valid i, s[i] is the same
 * as or comes before s[i+1] in the alphabet.
 * 
 *  Example 1:

	Input: n = 1
	Output: 5
	Explanation: The 5 sorted strings that consist of vowels only are ["a","e","i","o","u"].
	Example 2:
	
	Input: n = 2
	Output: 15
	Explanation: The 15 sorted strings that consist of vowels only are
	["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"].
	Note that "ea" is not a valid string since 'e' comes after 'a' in the alphabet.
 */
public class CountVowelStrings {
	
	/*
	 * Here we can observe a pattern to this problem.
		  a  e  i  o  u
    n=1   1  1  1  1  1  /a, e, i, o, u
    n=2   5  4  3  2  1  /a-> aa,ae,ai,ao,au | e-> ee,ei,eo,eu | i-> ii,io,iu | o-> oo,ou | u-> uu
    n=3   15 10 6  3  1
	
	If we observe from last there will be only 1 element which will start with u. 
	Every other element will have the count of previous count + next element count. As example
	in n=2, i will be previous i(1) + count of next element, o(2) -> 3
	in n=3, e will be previous e(4) + count of next element, i(6) -> 10
	 */
	public static int countVowelStrings(int n) {
        
        int[] dp = new int[5];
        Arrays.fill(dp,1);
        //since for n==1 we already have our ans
        n--;
        while(n-->0){
            
        	//for each char we are taking it's previous value, adding it up with the next char
        	//and storing it in it as it's current value
        	//we are starting the loop from 3, as u will have any 1 character for every n (uuuu....)
            for(int i=3;i>=0;i--)
                dp[i]+=dp[i+1];
        }
        //in the dp array,we have the no.of strings for each character
        //add them up 
        int sum=0;
        for(int i:dp)
            sum+=i;
        
        return sum;
    }
	
	public static void main(String[] args) {
		System.out.println(countVowelStrings(33));
	}

}
