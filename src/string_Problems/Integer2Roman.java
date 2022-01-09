package string_Problems;

import java.util.HashMap;
import java.util.Map;

//Not completed
public class Integer2Roman {
	
	private static String Int2Roman(int num) {
		// TODO Auto-generated method stub
		int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romanLiterals = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        
        Map<Integer,String> map = new HashMap<>();
        for(int i=0;i<values.length;i++){
            map.put(values[i],romanLiterals[i]);
        }
        
        String res="";
        int copy=num;
        int r=1;
        //999
        //CMXCIX
        while(num>0) {
        	int d=num%10;
        	d=d*r;
        	res=map.get(d)+res;
        	
        	r=r*10;
        	num=num/10;
        }
        return res;
	}
	
	public static void main(String[] args) {
		
		int num=600;
		System.out.println(Int2Roman(num));
	}
}
