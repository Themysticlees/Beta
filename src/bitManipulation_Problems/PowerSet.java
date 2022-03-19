package bitManipulation_Problems;
import java.util.*;
//Similar to subsets, print all the subsequence of a string in lexicographically order
//We write down the truth table for n numbers (n=size of string)
/*
 *	There will be total 2^n combinations
 * 
 *  2 1 0 (for each index, we check which bit is 1, if it is 1, we'll pick the character in that index of the string s)
 *  ------
 *  0 0 0 = no bit is 1 = []
 *  0 0 1 = index 0 has 1 bit = [a]
 *  0 1 0 = index 1 has 1 bit = [b]
 *  0 1 1 = index 0 and 1 has 1 bit = [ab]
 *  1 0 0
 *  1 0 1
 *  1 1 0
 *  1 1 1
 */
public class PowerSet {
	
	public List<String> AllPossibleStrings(String s)
    {
        
        int n=s.length();
        //calculating no.of combinations
        int num=(1<<n);
        List<String> list =new ArrayList<>();
        
        //for every number from 0 - 2^n-1 we will check,
        for(int i=0;i<num;i++){
            String temp="";
            //check which bits are 1
            for(int j=0;j<n;j++){
            	//left shift 1 by the index and perform and operation, if the ans is not zero, then
            	//we have a set bit at that index
                if((i&(1<<j))!=0)
                    temp+=s.charAt(j);
            }
            list.add(temp);
        }
        //sorting for lexographical order
        Collections.sort(list);
        
        list=list.subList(1,list.size());
        return list;
    }

}
