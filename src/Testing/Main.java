package Testing;
import java.util.*;


class Main{
	public boolean findPair(int arr[], int size, int n)
    {
        //code here.
        int i=0;
        int j=0;
        
        Arrays.sort(arr);
        
        while(i<size && j<size)
        {
            if(arr[j]-arr[i]==n && i!=j)
            	return true;
            else if(n>arr[j]-arr[i])
            	j++;
            else
            	i++;
        }
        return false;
    }
	public static void main(String[] args) {
		
		//1 2 3 4 5 6 7
		int[] arr= {5, 20, 3, 2 ,5, 80};
		
		System.out.println(new Main().findPair(arr, arr.length,17));
	}
}


