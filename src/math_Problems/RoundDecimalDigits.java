package math_Problems;

public class RoundDecimalDigits {
	
	public static void main(String[] args) {
		
		double profit=88.656688;
		//This will round upto n places (10^n), here n=3
		 profit = Math.round(profit * 1000.0) / 1000.0;
		 System.out.println(profit);
	}

}
