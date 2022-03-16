package bitManipulation_Problems;

/*
 * You are given a number N. Find the total count of set bits for all numbers from 1 to N(both inclusive).
 * Input: N = 6
	Output: 9
	
	Explanation:
	For numbers from 1 to 6.
	For 0: 0 0 0 = 0 set bits //for program purpose
	For 1: 0 0 1 = 1 set bits
	For 2: 0 1 0 = 1 set bits
	For 3: 0 1 1 = 2 set bits
	-------------------------
	For 4: 1 0 0 = 1 set bits
	For 5: 1 0 1 = 2 set bits
	For 6: 1 1 0 = 2 set bits
	
	Therefore, the total set bits is 9.
	
	first thing you have to find, the power of 2 which is just less than n, in this example it is 2^2 (2^x)
	Thus our no.of bits are 4. We can easily calculate the no.of bits of the first 4 numbers (0-3).
	
	We can see a pattern, in the ones place, there are 2 set bits out 4 bits, in tens place there are 
	2 set bits out of 4 bits and in the hundreds there are none.
	
	thus we can say no.of set bits for the first 4 numbers are : 4/2 + 4/2 = 4/2 * 2 = 2^2/2 * 2 = 2^(x-1)*x
	for the remaining no.os you can the see the msb is 1 for all the numbers, thus we can take those msb bits
	rem set bits = n-2^x+1
	
	After this the numbers become :
	1 0 0	 0 0
	1 0 1 => 0 1
	1 1 0	 1 0
	
	So now we have to calculate the no.of set bits from 0 - 2 so n becomes 2
	Thus do a recursive call and return the final ans
	
	
 */
public class CountTotalSetBits {
	
	public static int countSetBits(int n){
	   
        return helper(n);
    }
    
    public static int helper( int n){
        
    	//if n becomes zero, return 0
        if(n==0)
            return 0;
        
        int bits=0;
        //calculate the power of 2 less than n
        //left shifting 1 by an increasing no. basically gives us all the powers of 2
        while((1<<bits)<=n)
            bits++;
        
        //because it got increased
        bits--;
        
        //now perform the operation
        //calculate set bits for 0-2^x-1 then add rest msb bits then do a recursive call for the number left
        int sum=(1<<bits-1)*bits+(n-(1<<bits)+1)
                        +helper(n-(1<<bits));
        return sum;
    }

}
