package bitManipulation_Problems;

/*
 * Given an array A containing 2*N+2 positive numbers, out of which 2*N numbers exist in pairs whereas 
 * the other two number occur exactly once and are distinct. Find the other two numbers.
 * 
 * Input: 
	N = 2
	arr[] = {1, 2, 3, 2, 1, 4}
	Output:
	3 4 
	Explanation:
	3 and 4 occur exactly once.
	
	
	If we have to find a single non-repeating no., then we can easily xor all the numbers
	because a xor a = 0 and a xor 0 = a. So if we xor two same number it basically cancels out them.
 */
public class TwoNonRepeating {
	//But in this case, we need to find 2 non repeating no.s
	//First we'll xor all the numbers so we'll be left with a^b (a and b being the unique no.s)
	public int[] singleNumber(int[] nums)
    {
        // Code here
        int xor=0;
        for(int i=0;i<nums.length;i++){
            xor^=nums[i];
        }
        
        //finding out the set bit from left, if we find a set bit then that means int the xor of a and b
        //that particular bit is different, thus we'll find all the numbers with 0 bit in that index and 1 bit in that index
        //there'll be two sets, in which in one set there will be either a or b
        //just xor all the numbers again, and we'll be left with the number which is not present in the set
        int bit=xor&~(xor-1);
        int a=0,b=0;
        for(int i=0;i<nums.length;i++){
        	//checking if the particular no. has the bit in that position, if yes xor it with a or xor it with b
            if((nums[i] & bit)==bit)
                a^=nums[i];
            else
                b^=nums[i];
        }
        
        int[] arr=new int[2];
        
        //the number which is present in a will cancel out and we'll be left with the other number
        arr[0]=xor^a;
        arr[1]=arr[0]^xor;
        
        //for ascending order
        //below is the code for swaping without using 3rd variable
        if(arr[0]>arr[1])
        {
            arr[0]=arr[0]^arr[1];
            arr[1]=arr[0]^arr[1];
            arr[0]=arr[0]^arr[1];
        }
        return arr;
    }

}
