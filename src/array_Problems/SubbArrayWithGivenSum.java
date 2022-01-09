package array_Problems;
import java.util.*;

public class SubbArrayWithGivenSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] arr2= {135, 101, 170, 125, 79, 159, 163, 65, 106, 146, 82, 28, 162, 92, 196, 143, 28, 37, 192, 5, 103, 154, 93, 183, 22, 117, 119, 96, 48, 127, 172, 139, 70, 113, 68, 100, 36, 95, 104, 12, 123, 134};
		int[] arr= {2,54,30,21,7,42,12};
		int[] arr2= {1,2,3,7,9};
		int sum=9;
		subArray(arr2,arr2.length,sum);
	}
	
	/*
	static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        // Your code here
        ArrayDeque<Integer> qu=new ArrayDeque<>();
        ArrayList<Integer> list=new ArrayList<>();
        ArrayList<Integer> list1=new ArrayList<>();
        
        list1.add(-1);
        int sum=0;
        for(int i=0;i<n;i++){
        	if(sum<s) {
        		sum+=arr[i];
        		qu.offer(i);
        	}
        	else
        		i--;
            
            if(sum>s)
            {
                int temp=arr[qu.poll()];
                sum=sum-temp;
            }
            if(sum==s)
            {
                list.add(qu.peekFirst()+1);
                list.add(qu.peekLast()+1);
                break;
            }
        }
        if(list.isEmpty())
        	return list1;
        return list;
        
    }*/
	
	public static void subArray(int[] arr, int n, int sum) {
		
		Map<Integer,Integer> map=new HashMap<>();
		
		int currsum=0;
		int start=0;
		int end=-1;
		
		for(int i=0;i<n;i++) {
			
			currsum+=arr[i];
			
			map.put(currsum, i);
			
			if(map.containsKey(currsum-sum))
			{
				start=map.get(currsum-sum)+1;
				end=i;
				break;
			}
			if(map.containsKey(sum))
			{
				start=0;
				end=i;
				break;
			}
		}
		
		if(end==-1)
			System.out.println("Nothing found");
		else
			System.out.println(start+" "+end);
		
		
	}
}


