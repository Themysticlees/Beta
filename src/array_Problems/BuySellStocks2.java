package array_Problems;
import java.util.*;

/*
 * problem link : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * 
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 * On each day, you may decide to buy and/or sell the stock. 
 * You can only hold at most one share of the stock at any time. 
 * However, you can buy it then immediately sell it on the same day.
 * Find and return the maximum profit you can achieve.
 * 
 * Input: prices = [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Total profit is 4 + 3 = 7.
 */
public class BuySellStocks2 {
	
	static ArrayList<ArrayList<Integer> > stockBuySell(int A[], int n) {
        // code here
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        
        int min_index=0; // index for buying the share
        int max_index=0; // index for selling the share
        
        int i=1;
        while(i<n){
        	//checking if the current value is greater than previous value
            if(A[i]>A[i-1])
            {
                ArrayList<Integer> temp = new ArrayList<>();
                //if yes store previous value as starting index (index for buying the share)
                min_index=i-1;
                //keep checking to find the best day to sell i.e index with the largest value
                while(i<n && A[i]>A[i-1])
                    i++;
                //store it as the ending index
                max_index=i-1;
                
                //after finding both the days store it.
                temp.add(min_index);
                temp.add(max_index);
                
                //add the data into the list
                list.add(temp);
            }
            else
                i++;
        }
        return list;
    }
	
	//First find a day where the cost of the stock is less than the next day
	//if found that will be the buying index
	//now find a index where the cost of the stock is more than the next day
	//that will be the selling index
	//calculate profit and do the same operations for the rem of the array
	public int maxProfit(int[] prices) {
        
        int sell=prices[0];
        int buy=prices[0];
        int totalp=0;
        
        int i=0;
        
        while(i<prices.length-1)
        {
            while(i<prices.length-1 && prices[i]>=prices[i+1])
                i++;
            
            buy=prices[i];
            
            while(i<prices.length-1 && prices[i]<=prices[i+1])
                i++;
            
            sell=prices[i];
            
            totalp+=sell-buy;
        }
        
        
        return totalp;
        
    }
	
	public static void main(String[] args) {
		
		int A[] = {4,2,2,2,4};
		ArrayList<ArrayList<Integer>> list = stockBuySell(A, A.length);
		System.out.println(list);
	}

}
