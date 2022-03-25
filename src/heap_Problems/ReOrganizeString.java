package heap_Problems;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.
	Return any possible rearrangement of s or return "" if not possible.
	
	Example 1:

	Input: s = "aab"
	Output: "aba"
	Example 2:
	
	Input: s = "aaab"
	Output: ""
 */
public class ReOrganizeString {
	
	//We need to store the characters in a pqueue and sort them according there no.of occurence
	//Each time we'll remove two characters from the top and add them to the resultant string
	//and add them back to the queue with occurence decreased by 1
	//After such iterations, if only one character is left in the queue, we'll check it's occurence
	//if it is more than 1 then we cannot arrange in a such a way so that two same characters are not adjacent
	//Thus we'll return ""
	public static String reorganizeString(String s) {
	      
		//In order to calculate the occurrence of each character
        Map<Character,Integer> map=new HashMap<>();
        
        int n=s.length();
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            
            //calculate the occurrence of each character
            map.putIfAbsent(ch,0);
            
            map.put(ch,map.get(ch)+1);
        }
        
        //Using a custom comparator to sort the characters according to their occurrence
        Comparator<Character> com=new Comparator<>(){

			@Override
			public int compare(Character ch1, Character ch2) {
				// TODO Auto-generated method stub
				return map.get(ch2)-map.get(ch1);
			}
        };
        
        PriorityQueue<Character> queue=new PriorityQueue<>(com);
        
        //storing the values in queue
        for(Character ch:map.keySet())
        	queue.add(ch);
        String res="";
        
        //loop runs until size of queue is 1 or less
        while(queue.size()>1)
        {
        	//removing the top two characters and adding them to res
            char c1=queue.remove();
            char c2=queue.remove();
            res+=c1;
            res+=c2;
            
            //decreasing the occurrence by 1, if it is still more than 1
            //update that in the map and add it to the queue
            if(map.get(c1)-1 > 0) {
                map.put(c1,map.get(c1)-1);
                queue.add(c1);
            }
            
            //same with c2
            if(map.get(c2)-1 > 0) {
                map.put(c2,map.get(c2)-1);
                queue.add(c2);
            }
        }
        
        //if we only have 1 character remaining, check it's occurrence
        if(queue.size()==1)
        {
            char ch=queue.remove();
            //if more than 1 then re organizing is not possible
            if(map.get(ch)>1)
                return "";
            
            res+=ch;
        }
        return res;
        
    }

}
