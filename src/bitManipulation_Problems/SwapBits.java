package bitManipulation_Problems;

/*
 * Given a number X and two positions (from right side) in binary representation of x,
 * write a program that swaps N bits at given two positions and returns the result.
 *  
 *  Input:
	X = 47
	P1 = 1
	P2 = 5
	N = 3
	Output: 227
	Explanation:
	The 3 bits starting from the second bit 
	(from the right side) are swapped with 3 bits
	starting from 6th position (from the right side)
 */
public class SwapBits {
	
	//We will use the property of xor
	/*
	 * We will extract the two windows of n size and find xor between them
	 * T=A^B (A and B being the two windows)
	 * Now we'll xor with the particular windows of the original number with T
	 * As we know A^B^A=B thus T=A^B so when we xor the B window with T we will replace that with A
	 * Similarly for B
	 */
	static int swapBits(int x, int p1, int p2, int n)
    {
        //First we shift the the two windows to the end
		//performing & operation with 1<<n-1 so that all the bits except the n bits will turn zero
		//When we subtract 1 from any power of 2, all the n bits from the right becomes 1 and others become 0.
		//We got both the windows 
        int A=(x>>p1)&((1<<n)-1);
        int B=(x>>p2)&((1<<n)-1);
        
        //Calculate a xor of them
        int T=A^B;
        
        //Now xor T again with x but shift T to the position of the 1st window and then to the 2nd window
        //This will swap the both windows
        //This soln can also be applied to swap a bit, instead of extracting a window we only extract a bit
        //rest operation is sames
        x=x^(T<<p1);
        x=x^(T<<p2);
        
        return x;
    }
	
	public static void main(String[] args) {
		
		System.out.println(swapBits(47, 1, 5, 3));
	}

}
