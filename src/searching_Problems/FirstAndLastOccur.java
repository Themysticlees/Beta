package searching_Problems;

public class FirstAndLastOccur {
	
	//Binary search O(logn)
	public static void find(long arr[], int n, int x)
    {
		
        long low=0,high=n-1;
        long left=-1,right=-1;
        
        //standard Binary Search algo
        while(low<=high){
            
            long mid=low+(high-low)/2;
            
            if(arr[(int)mid] == (int)x)
            {
            	//if the arr[mid] matches then we check the left of the array of the first occurence
                left=mid-1;right=mid+1;
                while(left>=low && arr[(int)left] == (int)x)
                    left--;
                
                //since it will get decremented before condition checking fails 
                left++;
                
                //and check the right of the array for last occurence
                while(right<=high && arr[(int)right] == (int)x)
                    right++;
                
                //since right gets incremented before condition checking fails
                right--;
                //we must have found out the first and last occurence
                //if there was no such case the left and right will both contain mid index
                //and thus we dont need to search any more, thus brea from the loop.
                break;
                
            }
            
            //normal conditions of Binary Search
            if(x<arr[(int)mid]){
                high=mid-1;
            }
            else if(x>arr[(int)mid]){
                low=mid+1;
            }
        }
        
        System.out.println("First index : "+left+" , Last index : "+right);
    }
	
	public static void main(String[] args) {
		
		long arr[] = { 1, 3, 5, 5, 5, 5, 67, 123, 125 };
		
		find(arr, arr.length, 5);
		
	}

}
