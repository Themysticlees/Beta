package array_Problems;
import java.util.*;
public class TripletSum {
	
	 public static List<Integer> find3Numbers(int arr[], int n, int X) { 
		    
	       //sorting the array in order to use two pointer algo
	       Arrays.sort(arr);
	       
	       List<Integer> list=new ArrayList<>();
	       int first=-1,second=-1,third=-1;
	       
	       for(int i=0;i<n;i++){
	           //finding the diff of the required no. and current number
	           int diff=X-arr[i];
	           
	           //using two pointer find the elements which has a sum = diff
	           int j=i+1,k=n-1;
	           while(j<k){
	               if(arr[j]+arr[k]>diff)
	                    k--;
	                else if(arr[j]+arr[k]<diff)
	                    j++;
	                else{
	                	//if found store it in the respective elements and break
	                    second=j;
	                    third=k;
	                    break;
	                }
	           }
	           if(second>0 && third >0)
	           {
	        	   first=i;
	        	   break;
	           }
	           else
	        	   return list;
	       }
	       
	       list.add(arr[first]);
	       list.add(arr[second]);
	       list.add(arr[third]);
	       
	       return list;
	 }
	 
	 public static void main(String[] args) {
		
		 int arr[] = {1, 4, 45, 6, 10, 8};
		  System.out.println(find3Numbers(arr, arr.length, 15));
	}
}
