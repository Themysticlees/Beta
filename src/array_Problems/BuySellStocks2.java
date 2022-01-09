package array_Problems;
import java.util.*;

public class BuySellStocks2 {
	
	static ArrayList<ArrayList<Integer> > stockBuySell(int A[], int n) {
        // code here
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        
        int min_index=0; // index for buying the share
        int max_index=0; // index for selling the share
        
        int i=1;
        while(i<n){
        	//checking if the current value is greater than previous value
            if(A[i]>A[i-1])
            {
                ArrayList<Integer> temp = new ArrayList<>();
                //if yes store previous value as starting index (index for buying the share)
                min_index=i-1;
                //keep checking to find the best day to sell i.e index with the largest value
                while(i<n && A[i]>A[i-1])
                    i++;
                //store it as the ending index
                max_index=i-1;
                
                //after finding both the days store it.
                temp.add(min_index);
                temp.add(max_index);
                
                //add the data into the list
                list.add(temp);
            }
            else
                i++;
        }
        return list;
    }
	
	public static void main(String[] args) {
		
		int A[] = {4,2,2,2,4};
		ArrayList<ArrayList<Integer>> list = stockBuySell(A, A.length);
		System.out.println(list);
	}

}
