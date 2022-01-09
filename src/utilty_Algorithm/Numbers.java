package utilty_Algorithm;

public class Numbers {
	
	public static void swap(int[] arr, int i,int j)
	{
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	public static void reverse(int[] arr, int i, int n)
	{
		if(i<n)
		{
			swap(arr,i,n);
			i++;
			n--;
		}
	}

}
