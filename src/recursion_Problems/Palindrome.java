package recursion_Problems;

//Find the Nth number from the palindromic series
public class Palindrome {
	
	public static boolean isPalindrome(String str, int i) {
		//Since we are check the first and the last character
		//Then the second and the second last... Thus i will go upto n/2
		//Upto that, if we get a match for all the characters then simply return true
		if(i>=str.length()/2)
			return true;
		
		//if we don't get a match, return false
		if(str.charAt(i)!=str.charAt(str.length()-i-1))
			return false;
		
		//otherwise make a func call for the next index and return it's output
		return isPalindrome(str, i+1);
	}
	
	public static void main(String[] args) {
		
		System.out.println(isPalindrome("MADSM", 0));
	}

}
