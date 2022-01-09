package array_Problems;

public class BuySellStocks {

	public static void main(String[] args) {
		
		int[] arr= {7,1,5,3,6,4};
		System.out.println(findMax(arr));

	}

	 public static int findMax(int[] arr)
	 {
		int n=arr.length;
		//auxilary array for storing the max price the share can be sold for, from the current index
		int[] aux=new int[n];
		
		int max=0;
		// from the current index check on the right side for the highest price
		for(int i=n-1;i>=0;i--)
		{
			if(arr[i]>max)
			{
				aux[i]=arr[i];
				max=arr[i];
			}
			else
				aux[i]=max;
		}
		
		max=0;
		//compare the profit for all the days and store the highest profit in max
		for(int i=0;i<n;i++)
		{
			if((aux[i]-arr[i])>max)
				max=aux[i]-arr[i];
		}
		
		return max;
	 }

}
