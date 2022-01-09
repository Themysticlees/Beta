package array_Problems;

import java.util.*;

public class FindAllPalindromes {
	
	public static void main(String[] args) {
		
		String s="abcbcfabcbadfgpllpgfabcddce";
		
		Set<String> set = new HashSet<>();
		
		int n=s.length();
		int reslength=0;
		String res="";
		
		for(int i=0;i<n;i++) {
			// Odd palindromes since it has a left and right element we start with the center
			int start=i-1,end=i+1;
			
			while((start>=0 && end<n) && s.charAt(start)==s.charAt(end))
			{
				/*if((end-start+1) > reslength)
				{
					reslength=end-start+1;
					res=s.substring(start,end+1);
				}*/
				set.add(s.substring(start,end+1));
				start--;
				end++;
			}
			
			//Even palidromes since it has either left or right we have to take two pointers
			start=i;
			end=i+1;
			
			while((start>=0 && end<n) && s.charAt(start)==s.charAt(end))
			{
				/*if((end-start+1) > reslength)
				{
					reslength=end-start+1;
					res=s.substring(start,end+1);
				}*/
				set.add(s.substring(start,end+1));
				start--;
				end++;
			}
		}
		
		System.out.println(set);
	}

}
