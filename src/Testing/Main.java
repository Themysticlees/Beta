package Testing;
import java.util.*;


class Node {
	 
	int data;
	//Node left;
	//Node right;
	Node next;
	    
	Node(int d) {
	    data = d; 
	    //left=null;
	    //right=null;
	    next=null;
	}

}

class Pair{
	
	Node val;
	int level;
	public Pair(Node val, int level) {
		super();
		this.val = val;
		this.level = level;
	}
	
}

public class Main{
	
	public static void swap(int[] arr, int i, int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
	public static void printArray(int[] arr, int n) {
		
		for(int i=0;i<n;i++)
			System.out.println(arr[i]);
	}
	
	
	
	public static int[] maxHeap(int[] arr, int n) {
		
		//int[] max=new int[n];
		
		//max[0]=arr[0];
		
		for(int i=1;i<n;i++) {
			//max[i]=arr[i];
			
			int parent=i/2;
			
			if((i&1)==0)
				parent--;
			
			int temp=i;
			while(parent>=0 && arr[temp]>arr[parent]) {
				swap(arr,temp,parent);
				temp=parent;
				
				parent=temp/2;
				
				if((temp&1)==0)
					parent--;
			}
		}
		
		return arr;
	}
	
	static void  buildHeap(int arr[], int n)
    {
        // Your code here
        for(int i=n/2-1;i>=0;i--)
            heapify(arr,n,i);
    }
 
    //Heapify function to maintain heap property.
	static void  heapify(int arr[], int n, int i)
    {
		int largest=i;
		int lc=2*i+1;
		int rc=2*i+2;
		
		if(lc<n && arr[lc]>arr[largest])
			largest=lc;
		if(rc<n && arr[rc]>arr[largest])
			largest=rc;
		
		if(largest!=i) {
			swap(arr,largest,i);
			heapify(arr, n, largest);
		}
    }
    
    //Function to sort an array using Heap Sort.
    public static void heapSort(int arr[], int n)
    {
        //code here
        buildHeap(arr,n);
        
        for(int i=0;i<n;i++){
            swap(arr,0,n-i-1);
            heapify(arr, n-1-i, 0);
        }
    }

	public static void main(String[] args) {
    	
		/*
    	Node root=new Node(10);
		root.left=new Node(5);
		root.right=new Node(13);
		root.left.left=new Node(3);
		root.left.right=new Node(6);
		root.right.left=new Node(11);
		root.right.right=new Node(14);
		root.left.left.left=new Node(2);
		root.left.left.right=new Node(4);
		root.left.right.right=new Node(9);
		
		*/
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
				
				return o1[1]-o2[1];
			}
		};
		*/
		
		int[] arr = {4, 1, 3, 9, 7};
		
		heapSort(arr, arr.length);
		printArray(arr, arr.length);
	}
	
}


	
