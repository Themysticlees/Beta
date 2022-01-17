package array_Problems;

public class TrappingRainwater {
	
	static long trappingWater(int arr[], int n) { 
        // Your code here
        
		//left array to store the wall with the max height on it's left
        int[] left = new int[n];
		//right array to store the wall with the max height on it's right
        int[] right = new int[n];
        
        //The reason we are finding that because the water will be trapped within two big walls
        //thus calculating this for every index will help calculate how much water
        //can be trapped at that index
        
        int max=0;
        for(int i=0;i<n;i++){
        	//we are storing the leftmost wall with the highest height
        	//from the current index
            if(arr[i]>max)
            {
                left[i]=arr[i];
                max=arr[i];
            }
            else
                left[i]=max;
        }
        
        max=0;
        //we are storing the rightmost wall with the highest height
    	//from the current index
        for(int i=n-1;i>=0;i--){
            if(arr[i]>max)
            {
                right[i]=arr[i];
                max=arr[i];
            }
            else
                right[i]=max;
        }
        long sum=0;
        //Now for every index we are checking how much water can be stored
        for(int i=0;i<n;i++){
            //The amount of water trapped between two biggest walls will be equal
        	//to the height of the second highest wall
        	//thus height of the second highest wall - height of current index wall
        	//will give us the amount of water for that index
            sum+=Math.min(left[i],right[i])-arr[i];
        }
        return sum;
    }
	
	public static void main(String[] args) {
		
		int arr[] = {3,0,0,2,0,4};
		System.out.println(trappingWater(arr, arr.length));
	}

}
