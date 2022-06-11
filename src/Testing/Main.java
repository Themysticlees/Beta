package Testing;
import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Node {
	 
	int data;
//	Node left;
//	Node right;
	Node next;
	//char ch;
	    
	Node(int d) {
	    data = d; 
//	    left=null;
//	    right=null;
	    next=null;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", next=" + next + "]";
	}
	
}

class Pair{
    
	long weight;
    long profit;
    double ratio;
    
    Pair(long wt, long pr, double ratio){
        this.weight=wt;
        this.profit=pr;
        this.ratio=ratio;
    }

	@Override
	public String toString() {
		return "Pair [weight=" + weight + ", profit=" + profit + ", ratio=" + ratio + "]";
	}
	
}

public class Main{
	
	public static void swap(int[] arr, int i, int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	public static void printArray(int[] arr) {
		
		int n=arr.length;
		System.out.print("[");
		for(int i=0;i<n-1;i++)
			System.out.print(arr[i]+" ,");
		
		System.out.println(arr[n-1]+"]");
	}
	
	static boolean patternMatch(String A, String B) {
		
		int n=B.length();
		long hashcode=0;
		for(int i=0;i<n;i++) {
			int ch=B.charAt(i)-'a'+1;
			hashcode+=ch*(int)Math.pow(26, n-i-1);
		}
		
		long check=0;
		int i=0;
		for(i=0;i<n;i++) {
			int ch=A.charAt(i)-'a'+1;
			check+=ch*(int)Math.pow(26, n-i-1);
		}
		
		int j=0;
		while(i<A.length()) {
			
			int ch=A.charAt(j)-'a'+1;
			j++;
			check=(check-ch*(int)Math.pow(26, n-1))*26;
			check=check+((int)A.charAt(i)-'a'+1);
			i++;
			if(check==hashcode && B.equals(A.substring(j, i)))
				return true;
			
		}
		
		return false;
	}
	
//-------------------------------------------------------------------------------------------------------//
	
	
	public long countSubarrays(int[] nums, long k) {
        
        int n=nums.length;
        
        int[] prefix=new int[n];
        
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            prefix[i]=sum;
        }
        
        int start=0,end=0;
        int count=0;
        int sum1=0;
        while(start<=end && end<n){
            
            sum1+=nums[end];
            
            // for(int i=start;i<=end;i++){
            //     sum1+nums[i];
            // }
            
            long ans=sum1*(end-start+1);
            
            while(ans>=k){
                sum1-=nums[start++];
                ans=sum1*(end-start+1);
            }
            
            if(ans<k){
                count+=end-start+1;
                end++;
            }
            
            
            
        }
        return count;
        
    }

//-------------------------------------------------------------------------------------------------------//
	public static void main(String[] args) {
    		
		Scanner sc=new Scanner(System.in);
		
//    	Node root=new Node(1);
//		root.left=new Node(2);
//		root.right=new Node(9);
//		root.left.left=new Node(4);
//		root.left.right=new Node(6);
//		root.right.left=new Node(5);
//		root.right.right=new Node(7);
//		root.left.left.left=new Node(8);
//		root.left.left.right=new Node(19);
// 		root.left.right.right=new Node(9);
		
		
		//root.right.right.right=new Node(5);
		//root.right.right.right.right=new Node(6);
		//root.left.right.left=new Node(6);
		//root.right.right.left=new Node(13);
		
		//int[] pre= {10,5,3,2,4,6,9,13,11,14};
		//int[] in = {2,3,4,5,6,9,10,11,13,14};
		
		//int[][] arr= {{1,3},{8,10},{2,6},{15,18}};
		
		/*Comparator<int[]> com=new Comparator<int[]>() {
			
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				
			}
		};
		
		
		int[] arr = new int[20];
		
		System.out.println("Enter:");
		for(int i=0;i<arr.length;i++) {
			arr[i]=sc.nextInt();
		}
		*/
		
		Main ob = new Main();
		
		int[]arr= {9,5,3,8,4,7,2,7,4,5,4,9,1,4,8,10,8,10,4,7};
		ob.countSubarrays(arr, 4);
		

	}
	
}


	
