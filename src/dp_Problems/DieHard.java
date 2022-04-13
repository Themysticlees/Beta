package dp_Problems;

public class DieHard {
	
	public static int dieHard(int armor, int health) {
		//1 air-health+3 armor+2
		//2 water-health-5 armor-10
		//3 fire-health-20 armor+5
		
		int[][] dp=new int[1001][1001];
		
		for(int i=0;i<dp.length;i++)
			for(int j=0;j<dp[0].length;j++)
				dp[i][j]=-1;
		
		dp[0][0]=0;
		
		return Math.max(helper(armor+2,health+3,dp,1),
				Math.max(helper(armor-10,health-5,dp,2),helper(armor+5,health-20,dp,3)));
	}
	
	public static int helper(int a,int h,int[][]dp,int ch) {
		
		if(a<=0 || h<=0)
			return 0;
		
		if(dp[a][h]!=-1)
			return dp[a][h];
		
		int x=0,y=0,z=0;
		if(ch!=1)
			x=1+helper(a+2,h+3,dp,1);
		if(ch!=2)
			y=1+helper(a-10,h-5,dp,2);
		if(ch!=3)
			z=1+helper(a+5,h-20,dp,3);
		
		int ans=Math.max(x, Math.max(y, z));
		dp[a][h]=ans;
		return ans;
	}
	
	public static void main(String[] args) {
		System.out.println(dieHard(8, 20));
	}

}
