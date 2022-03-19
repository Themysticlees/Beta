package bitManipulation_Problems;
/*
 * Given two integers dividend and divisor. 
 * Find the quotient after dividing dividend by divisor without using multiplication, 
 * division and mod operator.
 * 
 * 
 * The idea is to increase the divisor by it untill it becomes more than the dividend
 */
public class DividingWithoutOperator {
	
	public static long divide(long a, long b)
    {
        //code here 
		//if any one of the number is -ve then the final ans will be -ve
        boolean sign=true;
        if(a>0 && b<0 || a<0 && b>0)
            sign=false;
        
            
        a=Math.abs(a);
        b=Math.abs(b);
        
        //still, if the dividend is less than 0, then return 0
        if(a<b)
            return 0;
        
        long t=0;
        long q=0;
        
        //for example: 43 / 8 = 5
        //so if we multiply by 8*5 then we get 40 which is just less than 43
        //now we need to represent this 5, we can easily represent anything using the power of 2
        //5 = 2^2 + 2^0
        //Since a binary rep of an integer has 32 bits thus we'll start from 31
        //and we'll check for each case.
        for(int i=31;i>=0;i--){
            
            if(t+(b<<i)<=a){
            	//this is multiplying the divisor by the ith power of 2
            	//when i=2, the condition will satisfy, we'll move inside the loop and store the number in t
            	//and quotient in q. We'll check again since the quoteint cannot always be directly generated 
            	//from the powers of 2.
            	//t will already be 32 and we need to find the remaining, for i=1, it wont satisfy
            	//for i=0, the total will be 32+8*1=40, thus we'll add 1 to q and the new quoteint to t
                t+=b<<i;
                q+=1<<i;
            }
        }
        
        if(sign)
            return q;
        return -q;
    }

}
