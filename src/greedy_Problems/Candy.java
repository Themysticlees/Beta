package greedy_Problems;
import java.util.*;

/*
 * There are n children standing in a line. Each child is assigned a rating value given 
 * in the integer array ratings.
 * You are giving candies to these children subjected to the following requirements:
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * Return the minimum number of candies you need to have to distribute the candies to the children.
 * 
 *  Example 1:

	Input: ratings = [1,0,2]
	Output: 5
	Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
	Example 2:
	
	Input: ratings = [1,2,2]
	Output: 4
	Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
	The third child gets 1 candy because it satisfies the above two conditions.
 */
public class Candy {
	
	//Use a priority queue to store the children acc to their ratings 
	//now greedily select the child with least rating and check it's neighbours
	//and assign the candies accordingly
	public int candy(int[] rating) {
        
        int n=rating.length;
        
        if(n==1)
            return 1;
        
        int[] candies=new int[n];
        
        Arrays.fill(candies,1);
        
        PriorityQueue<Child> pq = new PriorityQueue<>(new Comparator<Child>(){
            //sorting according to their ratings
            public int compare(Child a, Child b){
                return a.rating-b.rating;
            }
        });
        
        
        for(int i=0;i<n;i++){
            pq.add(new Child(i,rating[i]));
        }
        
        while(!pq.isEmpty()){
        	//taking out a child with least rating
            Child curr=pq.remove();
            
            int i=curr.index;
            int r=curr.rating;
            
            //now performing the checks
            if(i==0){
                if(rating[i+1]<rating[i])
                    candies[i]=candies[i+1]+1;
            }
            else if(i==n-1){
                if(rating[i-1]<rating[i])
                    candies[i]=candies[i-1]+1;
            }
            
            else{
                //if rating is more than both the neighbors then find the max candies of the both 
            	//the neighbours and add 1
            	//otherwise check separately and add the candies
                if(rating[i]>rating[i-1] && rating[i]>rating[i+1]){
                    
                    candies[i]=Math.max(candies[i-1],candies[i+1])+1;
                }
                else if(rating[i]>rating[i-1])
                    candies[i]=candies[i-1]+1;
                
                else if(rating[i]>rating[i+1])
                    candies[i]=candies[i+1]+1;
            }
        }
        
        int sum=0;
        //find the total sum of the candies required
        for(int i=0;i<n;i++)
            sum+=candies[i];
        
        return sum;
    }
	
	public static void main(String[] args) {
		
		int[] arr= {1,0,2};
		System.out.println(new Candy().candy(arr));
	}
}

class Child{
    int index;
    int rating;
    
    Child(int index, int rating){
        this.index=index;
        this.rating=rating;
    }

}
