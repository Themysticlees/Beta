package greedy_Problems;
import java.util.*;

class Pair{
    
    double ratio;
    int weight;
    
    Pair(double ratio, int weight){
        this.ratio=ratio;
        this.weight=weight;
    }
}

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
/*
 * Given weights and values of N items, we need to put these items 
 * in a knapsack of capacity W to get the maximum total value in the knapsack.
 * Note: Unlike 0/1 knapsack, you are allowed to break the item.
 * 
 *  Input:
	N = 3, W = 50
	values[] = {60,100,120}
	weight[] = {10,20,30}
	Output:
	240.00
	Explanation:Total maximum value of item
	we can have is 240.00 from the given
	capacity of sack. 
 */

public class FractionalKnapsack {
	
	static double fractionalKnapsack(int W, Item arr[], int n) 
    {
        //For sorting them according to their value per weight ratio
        Comparator<Pair> com = new Comparator<Pair>(){
            
            @Override
            public int compare(Pair a, Pair b){
                if(b.ratio>a.ratio)
                    return 1;
                else if(a.ratio>b.ratio)
                    return -1;
                return 0;
            }
        };
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(com);
        
        //storing in a pq with the ratio and the weight
        for(int i=0;i<n;i++){
            double ratio=(double)arr[i].value/(double)arr[i].weight;
            pq.add(new Pair(ratio,arr[i].weight));
        }
        
        //sum for storing the final value
        //curr for storing the current weight
        double sum=0;
        double curr=0;
        
        //the loop will run until curr+new weight<W
        while(!pq.isEmpty() && curr+pq.peek().weight<W)
        {
        	//removing the top weight and adding the weight to curr
        	//and value to sum
            Pair temp=pq.remove();
            curr+=temp.weight;
            sum+=temp.weight*temp.ratio;
        }
        
        //if we still have elements left
        if(!pq.isEmpty()){
            Pair temp=pq.remove();
            //if W-curr is 0, then rem will be zero nothing will be added
            //if we still have some rem weight then we need to take that fractional value
            double rem=W-curr;
            sum+=temp.ratio*rem;
        }
        
        return sum;
        
    }
	
	public static void main(String[] args) {
		Item a=new Item(60, 10);
		Item b=new Item(100, 20);
		Item c=new Item(120, 30);
		//Item d=new Item(60, 10);
		
		Item[] arr= {a,b,c};
		System.out.println(fractionalKnapsack(50, arr, arr.length));
	}
	

}
