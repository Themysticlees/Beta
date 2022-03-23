package sorting_Problems;
import java.util.*;
/*
 * In every window find the max
 * Input:
	N = 9, K = 3
	arr[] = 1 2 3 1 4 5 2 3 6
	Output: 
	3 3 4 5 5 5 6 
	Explanation: 
	1st contiguous subarray = {1 2 3} Max = 3
	2nd contiguous subarray = {2 3 1} Max = 3
	3rd contiguous subarray = {3 1 4} Max = 4
	4th contiguous subarray = {1 4 5} Max = 5
	5th contiguous subarray = {4 5 2} Max = 5
	6th contiguous subarray = {5 2 3} Max = 5
	7th contiguous subarray = {2 3 6} Max = 6
 */
public class SlidingWindowMaximum {
	
    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
    	
    	//In this deque we'll only store the usefull elements
    	Deque<Integer> Qi = new LinkedList<Integer>();
    	 
        /* Process first k (or first window)
        elements of array */
        int i;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (i = 0; i < k; i++)
        {
            // For every element, the previous
            // smaller elements are useless so
            // remove them from Qi
            while (!Qi.isEmpty() && arr[i] >=arr[Qi.peekLast()])
                 // Remove from rear
                Qi.removeLast();
 
            // Add new element at rear of queue
            Qi.addLast(i);
        }
 
        // Process rest of the elements,
        // i.e., from arr[k] to arr[n-1]
        for (i=k; i < n; i++)
        {
            // The element at the front of the
            // queue is the largest element of
            // previous window, so store it
            list.add(arr[Qi.peekFirst()]);
 
            // Remove the elements which
            // are out of this window
            while ((!Qi.isEmpty()) && Qi.peekFirst() == i - k)
                Qi.removeFirst();
 
            // Remove all elements smaller
            // than the currently
            // being added element (remove
            // useless elements)
            while ((!Qi.isEmpty()) && arr[i] >=
                              arr[Qi.peekLast()])
                Qi.removeLast();
 
            // Add current element at the rear of Qi
            Qi.addLast(i);
        }
 
        // store the maximum element of last window
        //System.out.print(arr[Qi.peek()]);
        list.add(arr[Qi.peekFirst()]);
        return list;
    }
    
    public static void main(String[] args) {
		
    	int arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6};
    	System.out.println(max_of_subarrays(arr, arr.length, 3));
	}

}
