package Testing;
import java.util.*;

class Main{
	
	public static int FindMaxSum(int arr[], int n)
    {
        // Your code here
        int sum=0,sum2=0;
        for(int i=0;i<n;i+=2){
            sum+=arr[i];
        }
        
        for(int i=1;i<n;i+=2){
            sum2+=arr[i];
        }
        
        if(sum>sum2)
            return sum;
        return sum2;
    }
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int[] arr=new int[649];
		
		for(int i=0;i<arr.length;i++)
			arr[i]=sc.nextInt();
		
		System.out.println(FindMaxSum(arr, arr.length));
	}
	
}


