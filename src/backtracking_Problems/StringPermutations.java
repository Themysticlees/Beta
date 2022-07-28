package backtracking_Problems;

import java.util.*;
import java.util.Collections;
import java.util.List;
/*
 * Find all permutations of a String/array
 * For visual understanding, go to this website : https://www.techiedelight.com/generate-permutations-string-java-recursive-iterative/
 */
public class StringPermutations {
	
	public static void swap(char[] arr, int i, int j) {
		char temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	//Brute Force, we use an extra space (a Set)
	/*
	 * The idea is to use every element in every index, so we'll check for every index if a particular
	 * element is used or not in the permutation so far created, for this we'll use a set to keep track
	 */
	public static void permutations( String str, String temp, List<String> ans,Set<Character> set, int n) {
	// TODO Auto-generated method stub
		
		//if we have included all the elements just add the String and return
		if(set.size()==n){
			ans.add(temp);
			return;
		}
		
		//iterate through every element and check whether it exists in the Set ( i,e in the permutation )
		//if no, add it to the set and temp string and then call the function for the next indexes
		
		for(int j=0;j<n;j++) {
			char ch=str.charAt(j);
			if(!set.contains(ch)) {
				set.add(ch);
				permutations(str,temp+ch,ans,set,n);
				
				//after the function is completed, remove the element from set, as we will place every element in
				//that index so we need to remove the prev element inserted
				set.remove(ch);
			}
		}
	}
	
	
	//Optimal Approach, reducing space complexity
	/*
	 * In this approach we wont be using set but swapping mechanism,
	 * The idea is same, place every element in every index, so swap every element with the starting index
	 * In this way we can put every element in 0th, then 1st, 2nd and so on.
	 */
	public static void permutations(String str, int i,List<String> ans, int n) {
		//if we reach the end of the string, add the so formed string
		if(i>=n){
			ans.add(str);
			return;
		}
		//swap elements from the begining index to the end of the string
		//every element will be swapped to that position thus creating a new permutation
		for(int j=i;j<n;j++) {
			//for swapping convert it to array
			char[] arr=str.toCharArray();
			swap(arr, i, j);
			//after swapping again convert it to string
			str=String.copyValueOf(arr);
			//call the function for the next index
			permutations(str,i+1,ans,n);
		}
	}
	
	public static void main(String[] args) {
		
		String str="123";
		//char[] arr=str.toCharArray();
		
		ArrayList<String> list = new ArrayList<String>();
		Set<Character> set = new HashSet<>();
		
		//permutations(str, 0, list,str.length());
		permutations(str,"", list, set, str.length());
		Collections.sort(list);
		
		System.out.println(list);
		System.out.println("No.of permutations : "+list.size());
		
	}

}
