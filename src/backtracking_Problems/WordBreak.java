package backtracking_Problems;

import java.util.ArrayList;

public class WordBreak {
	
	public static int wordBreak(String A, ArrayList<String> B )
    {
        //base condition
		//if the loop ends and the last word is also matched
		if(A=="")
			return 1;
		
		//for storing the temporary strings
		String res="";
		for(int i=0;i<A.length();i++) {
			//we'll add each character and check whether it is present 
			//in the List
			res=res+A.charAt(i);
			
			for(int j=0;j<B.size();j++) {
				//if it is present we'll check whether the outer loop ends 
				//i.e if the last word is also present (the previous words must be checked)
				//Thus no need to check more, return the base case
				if(res.equals(B.get(j)))
					if(i==A.length()-1)
						return wordBreak("", B);
					else {
						//if the word is found then check for the rest part of the string
						//if the rest of string is not found then the partition is not made
						//and we keep adding characters to the original word and 
						//check if it are present
						int check= wordBreak(A.substring(i+1), B);
						//if check is 0 i,e next word is not present then loops continues for the 
						//original word
						if(check==1)
							return 1;
					}
			}
		}
		//if the word is not found in the list return 0
		return 0;
    }
	
	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("i");
		list.add("like");
		list.add("sam");
		list.add("sung");
		list.add("samsung");
		
		String A = "ilikesamsung";
		
		//This function will return 1 if string can be segmented as 
		//"i like samsung" or "i like sam sung".
		System.out.println(wordBreak(A, list));
	}

}
