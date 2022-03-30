package greedy_Problems;
import java.util.*;
/*
 * You are given a string s of lower case english alphabets. 
 * You can choose any two characters in the string and replace all the occurences of the first character 
 * with the second character and replace all the occurences of the second character with the first character.
 * Your aim is to find the lexicographically smallest string that can be obtained by doing this operation 
 * at most once.
 * 
 *  Input:
	A = "ccad"
	Output: "aacd"
	Explanation:
	In ccad, we choose a and c and after 
	doing the replacement operation once we get, 
	aacd and this is the lexicographically
	smallest string possible. 
 */
public class ChooseSwap {
	
	//We'll keep the characters in a sorted order in a tree
	//we'll check with each character with the top element of the tree
	//if the top element is less than the particular character we'll swap all it's occurrences
	String chooseandswap(String A){
        
		//to store the characters in a sorted manner
        TreeSet<Character> set = new TreeSet<>();
        
        for(int i=0;i<A.length();i++)
            set.add(A.charAt(i));
            
        char[] arr=A.toCharArray();
        
        for(int i=0;i<A.length();i++)
        {
        	//we remove the particular character from the set as we wont be comparing to itself
            set.remove(arr[i]);
            
            //if set becomes empty no need to check anymore
            if(set.isEmpty())
                break;
            
            //pick the top character from the set
            char ch=set.iterator().next();
            
            //if the top character is less than the current character then swap
            if(ch<arr[i])
            {
                char ch2=arr[i];
                //swap all it's occurences
                for(int j=0;j<A.length();j++)
                {
                    if(arr[j]==ch)
                        arr[j]=ch2;
                    else if(arr[j]==ch2)
                        arr[j]=ch;
                }
                //since we have performed one operation
                break;
            }
        }
        
        A = String.valueOf(arr);
        return A;
    }

}
