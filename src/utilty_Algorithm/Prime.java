package utilty_Algorithm;

import java.util.Arrays;

public class Prime {
	
	static boolean isPrime(int n)
	{
		for(int i=2;i*i<=n;i++)
		{
			if(n%i==0)
				return false;
		}
		return true;
	}
	
	//sieve of eratosthenes
	static boolean[] PrimeRange(int n)
	{
		boolean[] isPrime=new boolean[n+1];
		Arrays.fill(isPrime, true);
		
		isPrime[0]=false;
		isPrime[1]=false;
		
		for(int i=2;i*i<=n;i++)
		{
			for(int j=2*i;j<=n;j=j+i)
				isPrime[j]=false;
		}
		
		return isPrime;
	}

}
