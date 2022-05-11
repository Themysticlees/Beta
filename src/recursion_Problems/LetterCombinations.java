package recursion_Problems;
import java.util.*;
/*
 * Letter Combinations of a Phone Number
 * Given a string containing digits from 2-9 inclusive, return all possible letter
 * combinations that the number could represent. Return the answer in any order.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 * 
 *  Input: digits = "23"
	Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

 */
public class LetterCombinations {
	
	List<String> list = new ArrayList<>();
    Map<Character,String> mp=new HashMap<>();
    
    public List<String> letterCombinations(String digits) {
        
        if(digits.length()==0)
            return list;
        
        //put all the letters according to the number
        mp.put('2',"abc");
        mp.put('3',"def");
        mp.put('4',"ghi");
        mp.put('5',"jkl");
        mp.put('6',"mno");
        mp.put('7',"pqrs");
        mp.put('8',"tuv");
        mp.put('9',"wxyz");
        
        
        
        helper(digits,"");
        return list;
        
    }
    
    public void helper(String digits, String res){
        
    	//if the length of digits become zero then we cant make any more combinations 
    	//thus store the formed string in res
        if(digits.length()==0){
            list.add(res);
            return;
        }
        
        //pick the starting character and extract it's letters
        char curr=digits.charAt(0);
        String temp=mp.get(curr);
        
        //now for each letter call helper but remove the first character of digits as we have
        //used it and add that letter in res
        for(int i=0;i<temp.length();i++){
            char ch=temp.charAt(i);
            helper(digits.substring(1),res+ch);
        }
    }

}
