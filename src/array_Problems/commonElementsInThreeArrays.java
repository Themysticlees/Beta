package array_Problems;
import java.util.*;

public class commonElementsInThreeArrays {
	
	static ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3) 
    {
        int i = 0, j = 0, k = 0;
        ArrayList<Integer> res = new ArrayList<Integer>();
        int last = Integer.MIN_VALUE; // it stores the min integer value 

        while (i < n1 && j < n2 && k < n3)
        {
            if (A[i] == B[j] && A[i] == C[k] && A[i] != last) 
            {
            	//if all the elements are same store it
                res.add (A[i]);
                last = A[i]; // storing the last common element to prevent duplicate entry
                i++;
                j++;
                k++;
            }
            //since the arrays are in a sorted order, incremenet only the index of the array which is 
            // pointing at the smallest value
            else if
            	(Math.min (A[i], Math.min(B[j], C[k])) == A[i]) i++;
            	//if index at array A has the minumum value, incremenet only index of A
            else if // check the same for array B
            (Math.min (A[i], Math.min(B[j], C[k])) == B[j]) j++;
            else k++; // and array C
        }
        return res;
    }
	
	public static void main(String[] args) {
		
		int [] A = {1, 5, 10, 20, 40, 80};
		int [] B = {6, 7, 20, 80, 100};
		int[] C = {3, 4, 15, 20, 30, 70, 80, 120};
		
		ArrayList<Integer> list = commonElements(A, B, C, A.length, B.length, C.length);
		System.out.println(list);
	}

}
