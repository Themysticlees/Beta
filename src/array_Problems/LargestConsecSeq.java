package array_Problems;

import java.util.*;

public class LargestConsecSeq {
	//Find the longest sequence of numbers in an array
	//They need not to be in order
	static int findLongestConseqSubseq(int arr[], int N)
	{
	   // add your code here
	   
	   Set<Integer> set=new TreeSet<>();
	   
	   for(int i:arr)
	        set.add(i);
	    
	    int count=1;
	    int max=0;
	    for(int i:set){
	        
	        if(set.contains(i+1))
	            count++;
	        else
	            count=1;
	            
	        max=Math.max(max,count);  
	        
	    }
	    return max;
	}
	
	public static void main(String[] args) {
		
		int[] a={2,6,1,9,4,5,3};
		
		System.out.println(findLongestConseqSubseq(a, a.length));
	}

}
