package array_Problems;
import java.math.BigInteger;
import java.util.*;

public class bigFactorial {
	
	static ArrayList<Integer> factorial(int N){
        //code here
        ArrayList<Integer>al=new ArrayList<>();
        //java.math.BigInteger fact =  java.math.BigInteger.valueOf(1);
        BigInteger fact2 =BigInteger.valueOf(1);
        for (int i = 1; i <= N; i++)
            fact2 = fact2.multiply(BigInteger.valueOf(i));
       
        String in=String.valueOf(fact2);
   
    for(int i=0;i<in.length();i++){
       int number=Integer.parseInt(String.valueOf(in.charAt(i)));
       al.add(number);
    	}
    return al;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n=51;
		 ArrayList<Integer>al = factorial(n);
		 System.out.println(al);

	}

}
