package array_Problems;

public class minSortRotated {
	
	//find min in a rotated sorted array
	static int findMin(int arr[], int n)
    {
        if(arr.length==0)
            return 0;
        if(arr.length==1)
            return arr[0];
        
        // 2 3 4 5 1
        int left=0;
        int right=n-1;
        while(left<right){
            
        	//finding the mid index
            int mid=left+(right-left)/2;
            
            //if mid element is less than it's previous element then it is the min element
            // as the array is sorted.
            if(arr[mid]<arr[mid-1] && mid>0)
                return arr[mid];
            //check for the side in which sorting is not correct
            //if the leftmost element is less than mid element then left portion is sorted
            //then delete the left portion and search within the right portion
            else if(arr[mid]>=arr[left] && arr[mid]>arr[right] )
                left=mid+1;
            //if the rightmost element is more than mid element then right portion is sorted and
            // thus perform same operation
            else
                right=mid-1;
        }
        //if the array is sorted then at last only one element will be left thus return that,
        //left,right,mid doesnt matter
        return arr[left];
    }
	
	//find a number in a rotated sorted array
	
	static int findNum(int[] arr, int n, int search) {
		
		 if(arr.length==0)
	            return 0;
	     if(arr.length==1)
	            return arr[0];
	        
	     int left=0;
	     int right=n-1;
	     // 2 3 4 5 1
	     // 4 5 1 2 3
	     while(left<right) {
	    	 
	    	 int mid=left+(right-left)/2;
	    	 
	    	 if(arr[mid]==search)
	    		 return mid;
	    	 
	    	 if(arr[mid]>arr[left] && (search<=arr[left] && search >arr[mid]))
	    		 left=mid+1;
	    	 
	    	 
	     }
		return right;
		
	}
	
	public static void main(String[] args) {
		
		int[] arr= { 2, 3, 4, 5, 1};
		System.out.println(findMin(arr, arr.length));
		
	}

}
