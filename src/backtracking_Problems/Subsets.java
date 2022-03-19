package backtracking_Problems;
import java.util.*;
/*
 * Input : str = "abc"
	Output: a ab abc ac b bc c
	Explanation : There are 7 substrings that 
	can be formed from abc.
 */

//The idea is to include a character and not include it.
public class Subsets {
	
	public List<String> AllPossibleStrings(String s)
    {
        // Code here
        find(s,"",0,s.length());
        
        //sorting the array to get the lexo order
        Collections.sort(list);
        
        //since an empty String is present at the 1st index, thus removing it
        list=list.subList(1,list.size());
            return list;
    }
    List<String> list=new ArrayList<>();
    
    public void find(String A, String temp, int i, int n){
        
        if(i==n)
            list.add(temp);
            
        else{
            char ch=A.charAt(i);
            
            find(A,temp,i+1,n);
            find(A,temp+ch,i+1,n);
        }
        
    }

}
