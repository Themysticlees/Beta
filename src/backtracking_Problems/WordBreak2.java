package backtracking_Problems;

import java.util.ArrayList;
import java.util.List;

//Refer wordBreak first before coming here
/*
  	Input: s = "catsanddog", n = 5 
	dict = {"cats", "cat", "and", "sand", "dog"}
	Output: (cats and dog)(cat sand dog)
 */
public class WordBreak2 {
	
	//Similar to word break, however in this case we have to
	//return all the possible ways to break the string
	
	
	static List<String> wordBreak2(int n, List<String> B, String A)
    {
		//we'll storing the sentences in this list
		ArrayList<String> list = new ArrayList<String>();
		boolean bol= wordcheck(B, list, A, "");
		return list;
    }
	
	static boolean wordcheck(List<String> B, List<String> res, String A, String temp2) {
        // code here
		if(A=="") {
			//when we finish checking  the last word, 
			//we add the sentence to the list
			//we return false as we want to check for more possible strings
			res.add(temp2);
			return false;
		}
		
		String temp="";
		for(int i=0;i<A.length();i++) {
			temp+=A.charAt(i);
			
			for(int j=0;j<B.size();j++) {
				if(temp.equals(B.get(j)))
					if(i==A.length()-1) {
						//in temp2 we keep the sentence formed until now
						return wordcheck(B,res,"",temp2+temp);
					}
					else {
						if(wordcheck(B,res,A.substring(i+1),temp2+temp+" "))
								return true;	
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
