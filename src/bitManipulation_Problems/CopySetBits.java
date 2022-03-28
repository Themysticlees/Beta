package bitManipulation_Problems;

/*
 *  Input  : x = 10, y = 13, l = 2, r = 3
	Output : x = 14
	Binary representation of 10 is 1010 and 
	that of y is 1101. There is one set bit
	in y at 3'rd position (in given range). 
	After we copy this bit to x, x becomes 1110
	which is binary representation of 14.
 */

//check which bits of y are 1 in the given range
//if you find any set bit, then change the bit at the index of x to 1
public class CopySetBits {
	
	public static int copy(int x, int y, int l, int r){
        //checking in the range
        for(int i=l;i<=r;i++){
            int temp=1;
            
            //left shifting temp to find out whether lth index of y is 1 or not
            temp=temp<<(i-1);
            
            //if we & y and temp, we should be getting either temp or 0
            //if the bit at y is 0, then 1&0 is 0 thus the whole will be zero as all other bits are 0
            if((y&temp)==temp)
            {
            	//if we get a set bit at that index
            	//then change the bit of x too
                x=x|temp;
            }
        }
        return x;
    }
	public static void main (String[] args) {
		
		
		System.out.println(copy(10,13,2,3));
	}

}
