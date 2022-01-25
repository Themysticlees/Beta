package searching_Problems;

public class MinCapacityDdays {
	
static int leastWeightCapacity(int[] arr, int N, int D) {
        
		//We are calculating the max of the array and the sum of it
		//As the min weight will lie between these two numbers
		
		int max=arr[0];
		int sum=0;
		for(int i=0;i<N;i++) {
			if(arr[i]>max)
				max=arr[i];
			sum+=arr[i];
		}
		
		//since the min weight will lie between max and sum
		int low=max,high=sum;
		
		//We are using a Binary search approach to find out which weight is suitable
		while(low<high) {
			
			int mid=low+(high-low)/2;
			//after calculating mid, we are passing it in a function which basically tells
			//whether the no.of days calculated are less than equal to D or more
			//if less or equal then we can reduce the min weight of the boat inorder to increase the days
			//thus we'll search in the first portion of the array
			//if more than, we need to increase min weight of the boat inorder to decrease the days 
			//thus we'll search the second portion of the array since they are sorted.
			if(validWeight(mid,arr,D))
				high=mid;
			else
				low=mid+1;
		}
		//finally returning high because if the function valid.. returned true, we are storing that in high
		return high;
    }
	
	static boolean validWeight(int weight, int[] arr, int D) {
		
		//initially taking days as 1 and temp is to calculate the max weight the boat can withstand
		int days=1;
		int total=0;
		for(int i=0;i<arr.length;i++) {
			
			//if the current weight plus the prev total is less or equal to weight i.e weight of the boat
			//then update temp
			if(total+arr[i]<=weight)
				total+=arr[i];
			else
			{
				//if the total exceeds the weight then increment day and initialize temp by arr[i]
				//it is the first weight for the next day
				days++;
				total=arr[i];
			}	
		}
		//then we'll check if the days calculated is less or equal to D
		return (days<=D);
	}
	
	public static void main(String[] args) {
		
		int[] arr= {1,2,6,5,3};
		System.out.println(leastWeightCapacity(arr, arr.length, 3));
	}

}
