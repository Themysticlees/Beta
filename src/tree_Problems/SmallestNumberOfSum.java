package tree_Problems;
/*
 * The task is to find the smallest number with given sum of digits as S and number of digits as D. 
 * Input:
	S = 20
	D = 3
	Output:
	299
	Explanation:
	299 is the smallest number
	possible with sum = 20
	and total digits = 3.
 */
public class SmallestNumberOfSum {
	
	//So the idea is to subtract 9 if the number is greater than 9 and add it to the final string
	//If the number is less than 9 then add (num-1) to the string and subtract it by (num-1)
	//We keep this 1 for the first digit
	static String smallestNumber(int S, int D){
        // code here
        
        String res="";
        //we traverse for the number of digits
        while(D-->1){
            if(S>9){
                S-=9;
                res=9+res;
            }
            else{
                int temp=S-1;
                S-=temp;
                res=temp+res;
            }
        }
        //if for the last digit, the number is more than 9, then it is not valid
        if(S>9)
            return "-1";
        
        //otherwise add the first digit
        res=S+res;
        return res;
    }

}
