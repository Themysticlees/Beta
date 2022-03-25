package array_Problems;

/*
 * problem link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * 
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a 
 * different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. 
 * If you cannot achieve any profit, return 0.

 	Input: prices = [7,1,5,3,6,4]
	Output: 5
	Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
	Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 */
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
		// search from the current index check on the right side for the highest price
		for(int i=n-1;i>=0;i--)
		{
			//max will store the higest price till the current index
			//if we get anything greater than max, update max
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
