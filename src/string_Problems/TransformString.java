package string_Problems;
import java.util.*;

/*
 * Given two strings A and B. Find the minimum number of steps required to 
 * transform string A into string B. The only allowed operation for the transformation is 
 * selecting a character from string A and inserting it in the beginning of string A.
 * 
 *  Input:
	A = "abd"
	B = "bad"
	Output: 1
	Explanation: The conversion can take place in
	1 operation: Pick 'b' and place it at the front.
 */
public class TransformString {

	//Since the only operation we can do is taking a character and placing it in the begining.
	int transform (String A, String B)
    {
        // code here
        if(A.length()!=B.length())
            return -1;
        Set<Character> set = new HashSet<>();
        
        //for checking if both the string have the same characters
        //if not, then it is not possible transforming them
        for(int i=0;i<A.length();i++){
            if(set.contains(A.charAt(i)))
                set.remove(A.charAt(i));
            else
                set.add(A.charAt(i));
                
            if(set.contains(B.charAt(i)))
                set.remove(B.charAt(i));
            else
                set.add(B.charAt(i));
        }
        
        
        if(set.size()!=0)
            return -1;
        
        int i=A.length()-1;
        int j=B.length()-1;
        int count=0;
        
        //starting our iteration from the end
        while(i>=0 && j>=0){
        	//if both the characters are same, just decrement both the counters
            if(A.charAt(i)==B.charAt(j))
            {
                i--;
                j--;
            }
            //if they are unequal decrement the first counter 
            //which means we are placing that character in the begining thus decreasing the counter
            else
            {
                count++;
                i--;
            }
        }
        return count;
    }

}
