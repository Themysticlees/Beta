package Testing;
import java.util.*;
import java.util.regex.Pattern;

public class Main {
	
	public static int solve(String a) {
		
		int j = a.length() - 1;
	    int i = 0;
	    int flg = 0;
	    
	    while(i<j){
	        
	        if(a.charAt(i) != a.charAt(j)) {
	            if(flg == 0){
	                if(a.charAt(i) == a.charAt(j-1)) {
	                    j--;
	                } else if (a.charAt(i+1) == a.charAt(j)) {
	                    i++;
	                }
	                else
	                	break;
	               	 flg = 1;
	                
	            } else{
	                break;
	            }
	        }
	        i++;j--;
	    }
	    if(i<j)
	        return 0;
	    return 1;
	}
		
	
	public static void main(String[] args) {
		
		System.out.println(solve("phmjjmap"));
	}

}
