package backtracking_Problems;

import java.util.ArrayList;
import java.util.Arrays;

public class PalinPartitionString {
	
static ArrayList<ArrayList<String>> list = new ArrayList<>();
    
    static ArrayList<ArrayList<String>> allPalindromicPerms(String S) {
        // code here
        
        findPairs(S,"");
        return list;
        
    }
    static boolean findPairs(String s,  String res){
        
    	//base case i.e if when we reach the last word
        if(s==""){
            String[] strSplit = res.split(" ");
  
            list.add(new ArrayList<String>(
            Arrays.asList(strSplit)));
            return false;
        }
            
        int n=s.length();
        String temp="";
        for(int i=0;i<n;i++){
        	//store each character in the string
        	//and check if it is palindrome
            temp+=s.charAt(i);
            boolean cond=true;
            int in=0;
            int j=temp.length()-1;
            
            while(in<j)
            {
                if(temp.charAt(in)!=temp.charAt(j))
                {
                    cond=false;
                	break;
                }
                in++;
                j--;
            }
            
            //if it is a palindrome, make a partition and check 
            //for the remaining string
            if(cond)
            {
                if(i==n-1)
                {
                    return findPairs("",res+temp);
                }
                //if the rem string is not partitioned properly
                //then the current partition is not made
                //and we keep on checking
                else if(findPairs(s.substring(i+1),res+temp+" "))
                     return true;
            }
            
        }
        return false;
    }
    
    static boolean isPalindrome(String str){
        
        int i=0;
        int j=str.length()-1;
        
        while(i<j)
        {
            if(str.charAt(i)!=str.charAt(j))
                return false;
        }
        return true;
    }
    
	
	public static void main(String[] args) {
		
		String str="ababa";
		System.out.println(allPalindromicPerms(str));
	}

}
