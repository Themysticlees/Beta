package array_Problems;

/*
 * Problem link: https://practice.geeksforgeeks.org/problems/even-and-odd/1#
 * 
 * Given an array arr[] of size N containing equal number of odd and even numbers.
 * Arrange the numbers in such a way that all the even numbers get the even index 
 * and odd numbers get the odd index.
 * Note: There are multiple possible solutions, Print any one of them. 
 * Also, 0-based indexing is considered.
 * 
 *  Input:
	N = 6
	arr[] = {3, 6, 12, 1, 5, 8}
	Output:
	1
	Explanation:
	6 3 12 1 8 5 is a possible solution.
	The output will always be 1 if your
	rearrangement is correct.
 */
public class EvenOddRearange {
	
	//We'll maintain two pointers, one for odd index and the other for even index
	//if for both indexes the value mismatches then just swap them
	//otherwise if any of the indexes value matches then increment that pointer only
	static void reArrange(int[] arr, int n) {
        // code here
        
        
        int odd=1;
        int even=0;
            
        while(even<n && odd<n){
        	//if both indexes mistmatch just swap
            if(arr[odd]%2==0 && arr[even]%2!=0){
                int temp=arr[odd];
                arr[odd]=arr[even];
                arr[even]=temp;
                
                odd+=2;
                even+=2;
            }
            //if odd index holds the correct value, then increase the odd pointer 
            //as we don't need to swap it in future
            //similarly for even index do the same
            else if(arr[odd]%2!=0)
                odd+=2;
            else
                even+=2;
        }
    }
	
	public static void main(String[] args) {
		
		int arr[] = {3, 6, 12, 1, 5, 8};
		reArrange(arr, arr.length);
	}
};


