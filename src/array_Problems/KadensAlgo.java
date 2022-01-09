package array_Problems;

public class KadensAlgo {
	//Find the largest continuos subarray
	static int maxArray(int[] arr)
	{
		int curr=0;
		int max=0;
		
		for(int i=0;i<arr.length;i++)
		{
			//current sum
			curr=curr+arr[i];
			
			if(curr>max)
				max=curr;
			
			//if current sum is less than 0, then it cannot be max sub array
			if(curr<0)
				curr=0;
		}
		
		return max;
	}
	public static void main(String[] args) {
		
		int[] arr= {-4,2,6,0,-10,5,9};
		
		System.out.println(maxArray(arr));
		

	}

}
