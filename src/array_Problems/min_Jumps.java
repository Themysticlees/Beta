package array_Problems;

public class min_Jumps {
	
	static int minJumps(int[] arr){
        // your code here
        
		//since we are starting from the first element then the max reach is the value of 
		//the first element
        int maxReach=arr[0];
        //since we have to make atleast jump
		int jump=1;
		//as no.of steps we can jump is the value of the element in that index
		int steps=arr[0];   
		
		//corner cases
		if(arr.length==1)
			return 0;
		if(arr[0]==0)
			return -1;
		
		
		int n=arr.length;
		
		for(int i=1;i<n;i++)
		{
			//if we reach the last element no need check anything
			//simply return
		    if(i==n-1)
		        return jump;
		    
		    //Basically we need to jump to an index which has the highest value i.e reach
			
		    //store the max reach from a particular element
		    //arr[i]+i means arr[i] steps plus all steps behind it since we are jumping to 
		    //our desired index
			maxReach=Math.max(maxReach,(arr[i]+i));
			
			//decrease the steps as we move forward
			steps--;
			
			//if steps=0 i.e we have checked all the elements within the max reach of our initial element
			//now we have to jump
			if(steps==0)
			{
				jump++;
				//if we jump to a zero then the maxreach will not increase,
				if(i>=maxReach)
				    return -1;
				//update steps to the current element which we jumped to
				steps=maxReach-i;
			}
		}
		return jump;
    }
	
	public static void main(String[] args) {
		
		int[] arr={0,1,1,1};
		System.out.println(minJumps(arr));
	}


}
