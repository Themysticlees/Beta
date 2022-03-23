package heap_Problems;
import java.util.*;
/*
 * Given an array Arr of N positive integers, 
 * find K largest elements from the array.  
 * The output elements should be printed in decreasing order.
 * 
 *  Input:
	N = 5, K = 2
	Arr[] = {12, 5, 787, 1, 23}
	Output: 787 23
	Explanation: 1st largest element in the
	array is 787 and second largest is 23.
 */
public class KLargestElements {
	
	int[] kLargest(int[] arr, int n, int k) {
        // code here
        //We'll use a priority queue so that elements are in a increasing sorted order
		//we'll check the top element as it is the minimum in the queue
		//if a particular element is greater than the top element then replace it
		//at the end we'll have the 3 largest elements in the queue
        Queue<Integer> queue = new PriorityQueue<>();
        
        //firstly adding the first three elements
        for(int i=0;i<k;i++)
            queue.add(arr[i]);
            
        //then comparing and swaping
        for(int i=k;i<n;i++){
            
            if(arr[i]>queue.peek()){
                queue.poll();
                queue.add(arr[i]);
            }
        }
        
        int[] res=new int[k];
        for(int i=k-1;i>=0;i--){
            res[i]=queue.poll();
        }
        return res;
    }

}
