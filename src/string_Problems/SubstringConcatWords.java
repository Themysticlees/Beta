package string_Problems;
import java.util.*;

/*
 * You are given a string s and an array of strings words of the same length. 
 * Return all starting indices of substring(s) in s that is a concatenation of each word in words 
 * exactly once, in any order, and without any intervening characters.
 * You can return the answer in any order.
 * 
 * Input: s = "barfoothefoobarman", words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
 * The output order does not matter, returning [9,0] is fine too.
 */
public class SubstringConcatWords {
	/*
	 * The idea is to check for substrings which contains all the words in the given array
	 * The sequence of words can be in any order but they must contain exactly once.
	 */
	public List<Integer> findSubstring(String s, String[] words) {
        
		//We'll using Map to store the words and their occurrence 
        Map<String,Integer> map = new HashMap<>();
        
        for(int i=0;i<words.length;i++){
        	String str=words[i];
            map.putIfAbsent(str, 0);
            map.put(str, map.get(str)+1);
        }
        
        //since the length of the words are same, then calculate the substring length (n)
        int sl=s.length();
        int maxL=words[0].length();
        int n=maxL*words.length;
            
        List<Integer> ans = new ArrayList<>();
        
        //using Sliding Window concept to check each substring
        for(int i=0;i<=sl-n;i++){
        	//creating a temp map as we'll be removing each word as we get it 
        	//from the substring. 
        	Map<String,Integer> temp = new HashMap<>(map);
            
            int j=i;
            for(;j<i+n;j+=maxL)
            {
            	//extracting each substring and checking if it is present in the temp map
                String str=s.substring(j,j+maxL);
                if(!temp.containsKey(str))
                    break;
                //if yes reduce the occurence and if occurence becomes 0, remove it
                temp.put(str, temp.get(str)-1);
                if(temp.get(str)==0)
                	temp.remove(str);
            }
            //if we get the entire word array then add the index to the ans	
            if(j==i+n)
                ans.add(i);
        }
        
        return ans;
    }
}
