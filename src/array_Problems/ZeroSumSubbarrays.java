package array_Problems;
import java.util.*;

public class ZeroSumSubbarrays {
	
	public static long findSubarray(long[] arr ,int n) 
    {
        //we'll store the current sum in the map
		//if the sum exists increase counter in the map and store the updated counter in the result
        Map<Long,Long> map = new HashMap<>();
        
        //storing 0 to check if any sum is 0
        map.put(0l,0l);
        long count=0;
        long sum=0;
        for(int i=0;i<n;i++)
        {
        	//storing the current sum
            sum+=arr[i];
            if(map.containsKey(sum)){
                map.put(sum,map.get(sum)+1);
                count=count+map.get(sum);
            }
            else
                map.put(sum,0l);
        }
        return count;
        
    }
	
	public static void main(String[] args) {
		
		long arr[] = {6,-1,-3,4,-2,2,4,6,-12,-7};
		System.out.println(findSubarray(arr, arr.length));
		
	}

}
