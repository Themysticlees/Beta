package searching_Problems;

//Binary Search
public class SearchRotatedSorted {
	
	public int search(int[] arr, int target) 
	{   
	    int low=0;
	    int high=arr.length-1;
	    
	    while(low<=high){
	        int mid=low+(high-low)/2;
	        
	        if(arr[mid]==target)
	            return mid;
	        
	        //if the left part of the array is sorted
	        if(arr[low]<=arr[mid]) {
	        	//if the target lies between the left part then search the left part 
	        	//otherwise search the right part
	        	if(target>=arr[low] && target<=arr[mid])
	        		high=mid-1;
	        	else
	        		low=mid+1;
	        }
	        else
	        {
	        	//if the right part of the array is sorted then check if the target
	        	//lies between, if yes then check the right part otherwise search the left part.
	        	if(target>=arr[mid] && target<=arr[high])
	        		low=mid+1;
	        	else
	        		high=mid-1;
	        }
	    }
	    return -1;
	    
	}
	public static void main(String[] args) {
		
		//1 2 3 4 5 6 7
		int[] arr= {3,1};
		
		System.out.println(new SearchRotatedSorted().search(arr, 1));
	}

}
