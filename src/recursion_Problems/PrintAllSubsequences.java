package recursion_Problems;
import java.util.*;

public class PrintAllSubsequences {
	
	//Print all the subsequences of a given array
	static int count=0;
	public static void subsequence(int i, List<Integer> ans, int n, int[] arr) {
		
		//When we reach the last index, just print the formed subsequence and return
		//and also increase count for the no.of subsequence check
		if(i>=n)
		{
			System.out.println(ans);
			count++;
			return;
		}
		
		//The way we get all the subsequences is by taking it once and not taking it the other time
		//In this way we can generate all the possible combinations
		//First we include the element and proceed to the next index
		ans.add(arr[i]);
		subsequence(i+1, ans, n, arr);
		
		//Then we remove the element i.e not take it and proceed to the next index
		ans.remove(ans.size()-1);
		subsequence(i+1, ans, n, arr);
	}
	
	//Print all the subsequences whose sum is equal to target
	public static void subsequenceK(int i, List<Integer> ans, int n, int[] arr, int sum, int target) {
		
		if(i==n)
		{
			if(sum==target)
				System.out.println(ans);
			return;
		}
		
		ans.add(arr[i]);
		sum+=arr[i];
		subsequenceK(i+1, ans, n, arr, sum, target);
		
		sum-=arr[i];
		ans.remove(ans.size()-1);
		subsequenceK(i+1, ans, n, arr, sum, target);
	}
	
	public static void main(String[] args) {
		
		int[] arr= {3,1,2,4,0};
		
		List<Integer> list = new LinkedList<>();
		
//		subsequence(0,list , arr.length, arr);
//		System.out.println("Total subsequences = "+count);
		
		subsequenceK(0, list, arr.length, arr, 0, 5);
	}

}
