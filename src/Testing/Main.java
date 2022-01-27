package Testing;
import java.util.*;

class Main{
	public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        // code here
        Arrays.sort(arr);
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Set<ArrayList<Integer>> set= new HashSet<>();
        
        int n=arr.length;
        int x=0;
        
        for(int i=0;i<n;i++){
            int rem=k-arr[i];
            
            for(int j=i+1;j<n;j++){
                int trem=rem-arr[j];
                int low=j+1;
                int high=n-1;
                
                while(low<high){
                    if(arr[low]+arr[high]==trem) 
                    {
                    	ArrayList<Integer> temp = new ArrayList<Integer>();
                    	temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[low]);
                        temp.add(arr[high]);
                        
                        if(!set.contains(temp))
                        {
                        	set.add(temp);
                        	list.add(temp);
                        }
                        
                        low++;
                        high--;
                    }
                    else if(trem>arr[low]+arr[high])
                        low++;
                    else
                        high--;
                }
            }
        }
        return list;
    }
	public static void main(String[] args) {
		
		/*Scanner sc=new Scanner(System.in);
		//1 2 3 4 5 6 7
		
		int[] arr2=new int[27];
		
		for(int i=0;i<arr2.length;i++) {
			arr2[i]=sc.nextInt();
			
			
		}*/
		
		int[] arr= {10,2,3,3,5,7,8};
		
		System.out.println(new Main().fourSum(arr,23 ));
	}
}


