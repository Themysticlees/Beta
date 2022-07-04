package bitManipulation_Problems;
/*
 * Given two integers A and B, the task is to find an integer X such that (X XOR A) 
 * is minimum possible and the count of set bit in X is equal to the count of set bits in B.
 * 
 *  Input: 
	A = 3, B = 5
	Output: 3
	Explanation:
	Binary(A) = Binary(3) = 011
	Binary(B) = Binary(5) = 101
	The XOR will be minimum when x = 3
	i.e. (3 XOR 3) = 0 and the number
	of set bits in 3 is equal
	to the number of set bits in 5.
 */
public class MinXxorA {

	public static int minVal(int a, int b) {
        // code here
        
		//count the set bits
        int bitsA=Integer.bitCount(a);
        int bitsB=Integer.bitCount(b);
        
        //if the bits are equal then no need to change
        if(bitsA==bitsB)
            return a;
            
        //if the bits of A are more, then just decrease the set bits from LSB of A until they are equal
        if(bitsA>bitsB){
            
            while(bitsA>bitsB){
                a=a&(a-1);
                bitsA--;
            }
        }
        //similarly if the bits of A are less
        else{
            while(bitsB>bitsA){
                a=a|(a+1);
                bitsA++;
            }
        }
        
        return a;
        
    }
}
