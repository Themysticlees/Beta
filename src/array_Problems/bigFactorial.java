package array_Problems;
import java.math.BigInteger;
import java.util.*;

//Calculate the factorial of a big number with the help of big number
public class bigFactorial {
	
	static ArrayList<Integer> factorial(int N, int M){
        //code here
        ArrayList<Integer>al=new ArrayList<>();
        //java.math.BigInteger fact =  java.math.BigInteger.valueOf(1);
        BigInteger fact2 =BigInteger.valueOf(1);
        for (int i = 1; i <= N; i++)
            fact2 = fact2.multiply(BigInteger.valueOf(i));
        
//        BigInteger fact =BigInteger.valueOf(1);
//        for (int i = 1; i <= M; i++)
//            fact = fact.multiply(BigInteger.valueOf(i));
//       
//        fact2=fact.divide(fact2);
        String in=String.valueOf(fact2);
   
    for(int i=0;i<in.length();i++){
       int number=Integer.parseInt(String.valueOf(in.charAt(i)));
       al.add(number);
    	}
    return al;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n=5950814;
		 ArrayList<Integer>al = factorial(n ,5950814);
		 System.out.println(al);

	}

}
