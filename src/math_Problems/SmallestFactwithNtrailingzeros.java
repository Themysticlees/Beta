package math_Problems;

public class SmallestFactwithNtrailingzeros {

	int findNum(int n)
    {
        //the numbers which can be an answer will be between this range
        int low=1,high=5*n;
        
        while(low<high){
            int mid=(low+high)/2;
            //checking the mid number if it has the same amount of zeros
            //if yes, then we check for a smaller no.
            //if the trailing zeros are more, then also we check for a smaller no.
            if(trailzero(mid)>=n)
                high=mid;
            else
                low=mid+1;
        }
        return high;
    }
    
    int trailzero(int num){
        
        //we have to check how many times the multiples of 5 exits in the number
        //num/5, num/5*5, num/5*5*5, we check until the value becomes 0.
        int count=0;
        while(num>0) {
                count += num / 5;
                num /= 5;
            }
        return count;
    }
    
    public static void main(String[] args) {
		
    	System.out.println(new SmallestFactwithNtrailingzeros().findNum(2));
	}
}
