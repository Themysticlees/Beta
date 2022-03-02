package string_Problems;

//You have to check whether a String is palindrome or not,
//if not, check if it can be converted by removing just one character. If yes return true otherwise false.
public class PalinCheckRem1 {
	
	public static int solve(String a) {
		
		int j = a.length() - 1;
	    int i = 0;
	    //for noting the removals
	    int flg = 0;
	    
	    while(i<j){
	        
	    	//if the characters are different
	        if(a.charAt(i) != a.charAt(j)) {
	        	//and there are no removals yet
	            if(flg == 0){
	            	//check whether it is similar to the previous
	            	//or next element
	            	//if yes move the pointer and set flg=1 
	            	//which indicates 1 removal is req
	                if(a.charAt(i) == a.charAt(j-1)) {
	                    j--;
	                    flg = 1;
	                } else if (a.charAt(i+1) == a.charAt(j)) {
	                    i++;
	                    flg = 1;
	                }
	                //if either of the conditions doesnt satisfy
	                //that means more than one removal is req
	                else
	                	break;
	            } 
	            //if removals is already 1
	            else{
	                break;
	            }
	        }
	        //move the pointers
	        i++;j--;
	    }
	    //if i is still less than j i.e the loop must have been
	    //exited in between since there were more than 1 removals
	    if(i<j)
	        return 0;
	    return 1;
	}
		
	
	public static void main(String[] args) {
		
		System.out.println(solve("pmjjmp"));
	}

}
