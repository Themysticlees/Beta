package array_Problems;

import java.util.*;

public class ArrayRotation {
	
	public static int[] rotation(int[] arr, int c)
	{
		List<Integer> list = new LinkedList<>();
		
		for(int i=0;i<arr.length;i++)
			list.add(arr[i]);
		
		while(--c>=0)
		{
			int temp=list.get(arr.length-1);
			list.add(0, temp);
		}
		
		for(int i=0;i<arr.length;i++)
			arr[i]=list.get(i);
		
		return arr;
		
	}

	public static void main(String[] args) {
		
		int[] A={9, 8, 7, 6, 4, 2, 1, 3};
		int c=3;
		
		A=rotation(A,c);
		
		for(int i=0;i<A.length;i++)
			System.out.print(A[i]+" ");

	}

}
