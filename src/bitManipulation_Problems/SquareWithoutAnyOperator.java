package bitManipulation_Problems;

public class SquareWithoutAnyOperator {
	
	/*
	 * square(n) = 0 if n == 0
	  if n is even 
	     square(n) = 4*square(n/2) 
	  if n is odd
	     square(n) = 4*square(floor(n/2)) + 4*floor(n/2) + 1 
	
	Examples
	  square(6) = 4*square(3)
	  square(3) = 4*(square(1)) + 4*1 + 1 = 9
	  square(7) = 4*square(3) + 4*3 + 1 = 4*9 + 4*3 + 1 = 49
	 */
	public static int power(int n){
        if(n==0)
            return 0;
        
        //if n is negative, convert it to positive
        if(n<0)
            n=0-n;
            
        if(n==1)
            return 1;
         
        //if n is even then perform the following formulae
        if((n&1)==0)
        {
        	// square(n) = 4*square(n/2) 
            return power(n>>1)<<2;
        }
        // square(n) = 4*square(floor(n/2)) + 4*floor(n/2) + 1 
        else
            return (power(n>>1)<<2) + ((n>>1)<<2) + 1;
        
    }
	public static void main (String[] args) {
		System.out.println(power(5));
	}

}
