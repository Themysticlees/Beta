package utilty_Algorithm;

public class TrailingZerosinFactorial {

	int trailing_zeros(int n)
	{
		int res=0;
		for(int i=5;i<=n;i=i*5)
			res=res+n/i;
		return res;
	}
}
