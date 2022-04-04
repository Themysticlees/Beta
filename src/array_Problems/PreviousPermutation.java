package array_Problems;

/*
 * Given a non-negative number N in the form of string. 
 * The task is to apply at most one swap operation on the number N so that the result is just 
 * a previous possible number.
 * Note:  Leading zeros are not allowed.
 * 
 * Input :
	S = "12435"
	Output: 
	12345
	Explanation:
	Although the number 12354 
	will be the largest smaller 
	number from 12435. But it is 
	not possible to make it using 
	only one swap. So swap 
	4 and 3 and get 12345.
 */
public class PreviousPermutation {
	
	//This is similar to Next Permutation. In Next Permuaton, we found a number which is greater than the previous
	//number, here we'll do the opposite
	//We'll find a number which is less than it's previous number.
	//Now the idea is to swap the previous number which a smaller number
	
	public static void swap(int[] arr, int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
	
    static String previousNumber(String S){
        // code here
        int n=S.length();
        
        int[] arr=new int[n];
        
        //converting into Integer array
        for(int i=0;i<n;i++){
            arr[i]=S.charAt(i)-'0';
        }
        //searching the index of such number
        int index=-1;
        for(int i=n-1;i>0;i--){
            if(arr[i]<arr[i-1])
            {
                index=i;
                break;
            }
        }
        
        //if no such number exits then the number must be sorted, in that case it is the shortest permutation
        if(index==-1)
            return "-1";
        
        //storing the index in max as we'll be comparing
        //We'll check for a number which is the greatest from index to n but it must be smaller than the 
        //previous number to index
        int max=index;
        for(int i=index+1;i<n;i++){
            if (arr[i]>arr[max] && arr[i]<arr[index-1])
                max=i;
        }
        
        //In this way, we'll find just the previous number.
        //Inorder to find the previous permutation, we need to swap the previous number with any small number
        //but that small number should be just small than the previous number
        swap(arr,index-1,max);
        
        //If we get a trailing zero at the start, then that number is not valid
        if(arr[0]==0)
            return "-1";
        String res="";
        for(int i=0;i<n;i++)
            res+=arr[i];
        return res;
    }

}
