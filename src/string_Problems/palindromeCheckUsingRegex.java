package string_Problems;

import java.util.regex.Pattern;

public class palindromeCheckUsingRegex {
	
	public static int Palindrome(String str) {
		StringBuffer buff = new StringBuffer();
		str=str.toLowerCase();
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			//using Regex to check the particular character
			if(Pattern.matches("[A-Za-z0-9]", Character.toString(ch)))
				buff.append(ch);
		}
		
		return buff.toString().equals(buff.reverse().toString())?1:0;
	}
	
	public static void main(String[] args) {
		String str ="aba";
		
		System.out.println(Palindrome(str));
	}

}
