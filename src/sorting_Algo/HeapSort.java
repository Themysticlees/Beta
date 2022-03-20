package sorting_Algo;

public class HeapSort {
	
	//Utility function
	void swap(int[] arr, int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        
    }
	
	//This will create a max heap using heapify function
	//We start the creation from n/2-1 node, as from n/2 the leaf nodes start which doesnt need to heapified
    void buildHeap(int arr[], int n)
    {
        // Your code here
        for(int i=n/2-1;i>=0;i--)
            heapify(arr,n,i);
    }
 
    //Heapify function to maintain heap property.
    //This function will basically check the children nodes, if any of them is greater than the parent
    //then swap them and call the heapify function for the swapped child
    //This is top-bottom approach
    void heapify(int arr[], int n, int i)
    {
		int largest=i;
		int lc=2*i+1;
		int rc=2*i+2;
		
		//checking if they lie in the bounds and if they are bigger than the parent node which is i
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
    public void heapSort(int arr[], int n)
    {
        //First we'll create the max heap
        buildHeap(arr,n);
        
        //the idea is to remove the top element and swap it with the last element
        //and then we'll call heapify function for 0th index from 0-n-i
        //so each time a less greater number gets swapped thus we'll get a sorted order at the end.
        for(int i=0;i<n;i++){
            swap(arr,0,n-i-1);
            heapify(arr, n-1-i, 0);
        }
    }
}
