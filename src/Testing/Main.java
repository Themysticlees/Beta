package Testing;
import java.util.*;


class Main{
	
	static long inversionCount(long arr[], long N)
    {
        new Main().MergeSort(arr, 0, (int)N-1);
        return inv;
    }
    
	static long inv=0;
    
	void Merge(long[] arr, int l,int mid,int h)
	{
		int i=l,j=mid+1;// starting index of both sides
		int m=mid,n=h;// ending index of both sides
		int k=0;
		
		long[] res = new long[(h-l+1)];
		
		while(i<=m && j<=n)
		{
			if(arr[i]<=arr[j])
				res[k++]=arr[i++];
			else
			{
				inv+=mid-i+1;
				res[k++]=arr[j++];
			}
		}
		
		for(;i<=m;i++)
			res[k++]=arr[i];
		
		for(;j<=n;j++)
			res[k++]=arr[j];
		
		for(int x=0;x<res.length;x++)
			arr[l++]=res[x];
			
	}
	
	void MergeSort(long[] arr, int l, int h)
	{
		if(l<h)
		{
			int mid=(l+h)/2;
			MergeSort(arr,l,mid);
			MergeSort(arr,mid+1,h);
			Merge(arr,l,mid,h);
			
		}
		
	}
    
    public static void main(String[] args) {
    	
    	long arr[] = {2,4,3,3,1};
    	
    	System.out.println(inversionCount(arr, arr.length));
	}
	
}

	
