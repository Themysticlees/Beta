package backtracking_Problems;

import java.util.ArrayList;
import java.util.Collections;

public class StringPermutations {
	
	public static void swap(char[] arr, int i, int j) {
		char temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	public static void permutations(String str, int i, int n, ArrayList<String> list) {
		
		//base cond
		//if begining index reaches the last index then 
		//no more permutations are left. Add the string to the list and return
		if(i==n-1)
		{
			//String str=String.copyValueOf(arr);
			list.add(str);
			return;
		}
		
		//convert to character array
		char[] arr=str.toCharArray();
		
		//beg= begining index which we need to swap
		//i = current index
		int beg=i;
		for(;i<n;i++) {
			//swap the current element with beg
			swap(arr,i,beg);
			str=String.copyValueOf(arr);
			//increase the begining index by 1 and do a recursive call
			permutations(str,beg+1,n,list);
		}
		
	}
	
	public static void main(String[] args) {
		
		String str="abbcb";
		//char[] arr=str.toCharArray();
		
		ArrayList<String> list = new ArrayList<String>();
		
		permutations(str, 0, str.length(), list);
		Collections.sort(list);
		System.out.println(list);
		System.out.println("No.of permutations : "+list.size());
		
	}

}
