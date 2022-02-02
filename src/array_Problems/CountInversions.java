package array_Problems;

public class CountInversions {
	
	//We have to find pairs where an element is bigger than any of the elements to it's right
	/*
	 *  Input: N = 5, arr[] = {2, 4, 1, 3, 5}
		Output: 3
		Explanation: The sequence 2, 4, 1, 3, 5 
		has three inversions (2, 1), (4, 1), (4, 3).
		
		i<j and arr[i]>arr[j]
	 */
	
	long inversionCount(long arr[], long N)
    {
        return MergeSort(arr, 0, (int)N-1);
        
    }
    //performing merge sort to find such pairs
	long Merge(long[] arr, int l,int mid,int h)
	{
		int i=l,j=mid+1;// starting index of both sides
		int m=mid,n=h;// ending index of both sides
		int k=0;
		
		long count=0;
		
		long[] res = new long[(h-l+1)];
		
		//we are merging two sorted arrays
		while(i<=m && j<=n)
		{
			if(arr[i]<=arr[j])
				res[k++]=arr[i++];
			else
			{
				//thus from the second array, if any element j is smaller than element i 
				//from the first array, then all the elements to 'i's right will be greater, since the array is sorted
				//i			j
				//2 4 5     1 3
				//here 1 is smaller than 2, thus it will be less than 4 and 5 and all the elements to
				//the right of 2 since the array is sorted.
				//thus we'll be adding the no.of elements to it's right including i 
				//that's how we'll get all the possible pairs
				count+=mid-i+1;
				res[k++]=arr[j++];
			}
		}
		
		for(;i<=m;i++)
			res[k++]=arr[i];
		
		for(;j<=n;j++)
			res[k++]=arr[j];
		
		for(int x=0;x<res.length;x++)
			arr[l++]=res[x];
			
		return count;
			
	}
	
	long MergeSort(long[] arr, int l, int h)
	{
	    long count=0;
		if(l<h)
		{
			int mid=(l+h)/2;
			count+=MergeSort(arr,l,mid);
			count+=MergeSort(arr,mid+1,h);
			count+=Merge(arr,l,mid,h);
			
		}
		return count;
	}
	
	public static void main(String[] args) {
		
		long[] arr={2, 4, 1, 3, 5};
		
		System.out.println(new CountInversions().inversionCount(arr, arr.length));
	}

}
