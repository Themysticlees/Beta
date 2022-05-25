package searching_Problems;
/*
 * Given an array Arr[] of size N. For every element in the array, 
 * the task is to find the index of the farthest element in the array to the right 
 * which is smaller than the current element. If no such number exists then print -1.
 * Note: 0 based indexing.
 * 
 *  Input: 
	N=5
	Arr[] = {3, 1, 5, 2, 4}
	Output: 
	3 -1 4 -1 -1
	Explanation:
	Arr[3] is the farthest smallest element
	to the right of Arr[0].
	Arr[4] is the farthest smallest element
	to the right of Arr[2].
	And for the rest of the elements, there is
	no smaller element to their right.
 */
public class FarthestSmallestNumber {
	
	// we need to find the smallest number at the right which is the farthest from the current number
	// first we'll make a suffix array (store the min number from every index)
	// reason for doing this as we need to search the element and binary search on applies on sorted order
	static int[] farNumber(int n, int arr[])
	{    
	    int[] suffix = new int[n];
	    
	    int min=arr[n-1];
	    for(int i=n-1;i>=0;i--){
	        min=Math.min(arr[i],min);
	        suffix[i]=min;
	    }
	    
	    //Since the suffix array is always sorted we can implement Binary Search on that
	    int[] ans=new int[n];
        
        for(int x=0;x<n;x++){
        	//taking out the current element
            int curr=arr[x];
            int i=x+1;
            int j=n-1;
            
            //for storing the index of the farthest smallest number
            int index=-1;
            
            while(i<=j){
                
                int mid=(i+j)/2;
                //if the middle number is smaller than the current then we'll search in the right
                //portion of the array as we need to find the farthest number
                //we'll also store the index of the number
                if(suffix[mid]<curr){
                    index=mid;
                    i=mid+1;
                }
                //otherwise, search in the first half
                else{
                    j=mid-1;
                }
                
            }
            
            //store the index in the answer array
            ans[x]=index;
        }
        
        return ans;
	}
	
	public static void main(String[] args) {
		
	}

}
