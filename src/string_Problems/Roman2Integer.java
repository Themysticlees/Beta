package string_Problems;
import java.util.*;
public class Roman2Integer {
	
	public static int romanToInt(String str) {
		
		//storing the corresponding values of the roman literals
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romanLiterals = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        
        //using map to assign each roman literal to its value
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<values.length;i++){
            map.put(romanLiterals[i],values[i]);
        }

        int res=0;
        
        //we are iterating from the end of the string
        for(int i=str.length()-1;i>=0;i--){
            
            char ch=str.charAt(i);
            String temp=Character.toString(ch);
            
            //for ignoring the last character which has no right element to compare with
            if(i<str.length()-1)
            {
            	//checking for special case such as IV, IX
            	//if the current char is smaller than its right element then 
            	//subtract it from the res
                if(map.get(temp)<map.get(Character.toString(str.charAt(i+1))))
                    res=res-map.get(temp);
                //else add the value to the result
                else
                    res+=map.get(temp);
            }
            else
                res+=map.get(temp);
        }
        return res;       
    }
	
	public static void main(String[] args) {
		String str ="CMXCIX";
		//first X:10 will be fetched, since it is the last character no special check, res=10
		//then I:1 will be fetched, it is smaller than its right element thus subtract res=10-1=9
		//then C:100 will be fetched, it is bigger than its right, thus add, res=100+9=109
		//then X:10 will be fetched, since it is smaller than its right element thus subtract, res=109-10=99
		//then M:1000 will be fetched, it is bigger than its right, thus add, res=99+1000=1099
		//then C:100 will be fetched, it is smaller than its right element thus subtract, res=1099-100=999
		//res=999

		System.out.println(romanToInt(str));
	}

}
