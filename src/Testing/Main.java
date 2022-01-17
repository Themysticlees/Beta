package Testing;
import java.util.*;
import java.util.regex.Pattern;

import searching_Problems.BinarySearch;

public class Main {
	
	
	static List<String> wordBreak2(int n, List<String> B, String A)
    {
		ArrayList<String> list = new ArrayList<String>();
		boolean bol= wordcheck(B, list, A, "");
		return list;
    }
	
	static boolean wordcheck(List<String> B, List<String> res, String A, String temp2) {
        // code here
		if(A=="") {
			res.add(temp2);
			return false;
		}
		
		String temp="";
		for(int i=0;i<A.length();i++) {
			temp+=A.charAt(i);
			
			for(int j=0;j<B.size();j++) {
				if(temp.equals(B.get(j)))
					if(i==A.length()-1) {
						//temp2;
						return wordcheck(B,res,"",temp2+temp);
					}
					else {
						if(wordcheck(B,res,A.substring(i+1),temp2+temp+" "))
						{
							//temp2+=res+" ";
								return true;
						}
						
				}
			}
		}
		
		return false;
    }
    
	
	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("i");
		list.add("like");
		list.add("likes");
		list.add("am");
		list.add("sam");
		list.add("sung");
		list.add("samsung");
		
		String A = "ilikesamsung";
		System.out.println(wordBreak2(list.size(),list,A));
	}
}


