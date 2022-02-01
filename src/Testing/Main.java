package Testing;
import java.util.*;


class Main{
	
	static void sortBySetBitCount(Integer arr[], int n)
    { 
        // Your code goes here
		
		Comparator<Integer> com=new Comparator<Integer>() {
			
			@Override
			public int compare(Integer i, Integer j) {
				
				String str=Integer.toBinaryString(i);
				String str2=Integer.toBinaryString(j);
				
				if(count1s(str2)==count1s(str))
					return 0;
				else if(count1s(str)>count1s(str2))
					return -1;
				else
					return 1;	
			}
		};
		
		Arrays.sort(arr,com);
        
    }
	
	static int count1s(String str) {
		
		int count=0;
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			if(ch=='1')
				count++;
		}
		return count;
		
	}
    
    public static void main(String[] args) {
		
    	Integer arr[] = {1,2,3,4,5,6};
    	sortBySetBitCount(arr, arr.length);
    	
    	for(Integer i:arr)
    		System.out.print(i+" ");
    	
    	System.out.println(Integer.bitCount(10));
	}
	
}

	
