package greedy_Problems;

import java.util.Stack;
/*
 * Gergovia consists of one street, and every inhabitant of the city is a wine salesman. 
 * Everyone buys wine from other inhabitants of the city. Every day each inhabitant decides 
 * how much wine he wants to buy or sell. Interestingly, demand and supply is always the same, 
 * so that each inhabitant gets what he wants.
 * There is one problem, however: Transporting wine from one house to another results in work. 
 * Since all wines are equally good, the inhabitants of Gergovia don't care which persons they 
 * are doing trade with, they are only interested in selling or buying a specific amount of wine.
 * In this problem you are asked to reconstruct the trading during one day in Gergovia. 
 * For simplicity we will assume that the houses are built along a straight line with equal distance
 *  between adjacent houses. Transporting one bottle of wine from one house to an adjacent house 
 *  results in one unit of work.
 *  
 *  If ai >= 0, it means that the inhabitant living in the ith house wants to buy ai bottles of wine. 
 *  If ai < 0, he wants to sell -ai bottles of wine.
 *  You may assume that the numbers ai sum up to 0.
 *  
 *  Input:
	5
	5 -4 1 -3 1
	6
	-1000 -1000 -1000 1000 1000 1000
	0
	
	Output:
	9
	9000
 */

class Pair2{
	int index;
	int val;
	public Pair2(int val, int index) {
		super();
		this.index = index;
		this.val = val;
	}
	@Override
	public String toString() {
		return "[index=" + index + ", val=" + val + "]";
	}
	
	
}

public class Gergovia {
	//The idea is that, a buyer will buy wine from the nearest seller
	//and the seller will sell wine to the nearest buyer 
	
	public static long gergovia(int[]arr, int n) {
		
		Stack<Pair2> pos=new Stack<>();
		Stack<Pair2> neg=new Stack<>();
		
		//Storing the buyers and sellers in two stacks along with their index
		for(int i=n-1;i>=0;i--) {
			if(arr[i]>0)
				pos.add(new Pair2(arr[i],i));
			else
				neg.add(new Pair2(arr[i],i));
		}
		
		int time=0;
		while(!pos.isEmpty() && !neg.isEmpty()) {
			//getting the last entered buyer and seller
			//and they must be the nearest to each other
			Pair2 buy=pos.peek();
			Pair2 sell=neg.peek();
			
			//calculating the diff
			int diff=buy.val+sell.val;
			
			//if dif is more than 0, then the seller has sold all the wine but buyer hasnt bought all
			if(diff>0)
			{
				time+=Math.abs(buy.index-sell.index)*(buy.val-diff);
				//thus updating the buyers value with the remaining wine bottles he needs to buy
				//and seller with 0
				buy.val=diff;
				sell.val=0;
			}
			else
			{
				//if diff is less or equal to 0, that means buyer has bought all the wine and seller is 
				//still left to sell
				time+=Math.abs(buy.index-sell.index)*buy.val;
				buy.val=0;
				sell.val=diff;
			}
			
			//if the buyer is done buying remove it from the stack
			//if the seller is done selling remove it from the stack
			if(buy.val==0)
				pos.pop();
			if(sell.val==0)
				neg.pop();
		}
		return time;
	}
	
	public static void main(String[] args) {
		
		int[] arr= {5,-4,1,-3,1};
		System.out.println(gergovia(arr, arr.length));
	}
}


