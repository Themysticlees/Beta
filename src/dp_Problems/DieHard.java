package dp_Problems;

public class DieHard {
	
	/*
	 * The game is simple. You initially have ‘H’ amount of health and ‘A’ amount of armor. 
	 * At any instant you can live in any of the three places - fire, water and air. 
	 * After every unit time, you have to change your place of living. 
	 * For example if you are currently living at fire, you can either step into water or air.
	 * If you step into air, your health increases by 3 and your armor increases by 2
	 * If you step into water, your health decreases by 5 and your armor decreases by 10
	 * If you step into fire, your health decreases by 20 and your armor increases by 5
	 * If your health or armor becomes <=0, you will die instantly
	 * Find the maximum time you can survive.
	 * 
	 * Example:
		
		Sample Input:
		
		3
		2 10
		4 4
		20 8
		Sample Output:
		
		1
		1
		5

	 */
	
	public static int dieHard(int armor, int health) {
		//1 air-health+3 armor+2
		//2 water-health-5 armor-10
		//3 fire-health-20 armor+5
		
		//we'll store the values in the dp array so that we can reuse it in the future
		int[][] dp=new int[1001][1001];
		
		//initializing the values with -1
		for(int i=0;i<dp.length;i++)
			for(int j=0;j<dp[0].length;j++)
				dp[i][j]=-1;
		
		dp[0][0]=0;
		
		//now we can start from any place, thus we need to check for air, water and fire.
		//The function which will return the max time is our ans
		return Math.max(helper(armor+2,health+3,dp,1),
				Math.max(helper(armor-10,health-5,dp,2),helper(armor+5,health-20,dp,3)));
	}
	
	public static int helper(int a,int h,int[][]dp,int ch) {
		
		//if at any point the armor or health becomes 0
		if(a<=0 || h<=0)
			return 0;
		//if we have already calculated for this value, simply return
		if(dp[a][h]!=-1)
			return dp[a][h];
		
		//otherwise calculate, if we jump from air, then we can jump to water and fire
		//Thus if our choice is 1(air), then we can jump to 2 and 3
		//The following statements satisfies our conditions
		
		int x=0,y=0,z=0;
		if(ch!=1)
			x=helper(a+2,h+3,dp,1);
		if(ch!=2)
			y=helper(a-10,h-5,dp,2);
		if(ch!=3)
			z=helper(a+5,h-20,dp,3);
		
		//check the max time survived
		//we are adding 1 as we are calculating for the subans, now for the main ans we add 1 because we
		//jumped from it.
		int ans=Math.max(x, Math.max(y, z))+1;
		
		//store the value in the dp for future use and return
		dp[a][h]=ans;
		return ans;
	}
	
	public static void main(String[] args) {
		System.out.println(dieHard(8, 20));
	}
	
	//Long process
	/*
	 * public static int dieHard(int armor, int health) {
		//1 air-health+3 armor+2
		//2 water-health-5 armor-10
		//3 fire-health-20 armor+5
		
		int[][] dp=new int[1000][1000];
		
		for(int i=0;i<1000;i++)
			for(int j=0;j<1000;j++)
				dp[i][j]=-1;
		
		dp[0][0]=0;
		
		return helper(armor,health,dp,0);
	}
	
	public static int helper(int armor,int health,int[][] dp, int choice) {
		
		if(armor==0 || health==0)
			return 0;
		
		if(choice==0) {
			int a=0,w=0,f=0;
			
			if(armor+2>=0 && health+3>=0) 
				a=helper(armor+2,health+3,dp,1);
			if(armor-10>=0 && health-5>=0) 
				w=helper(armor-10,health-5,dp,2);
			
			if(armor+5>=0 && health-20>=0) 
				f=helper(armor+5,health-20,dp,3);
			
			return Math.max(a,Math.max(w,f));
		}
		
		//if we jump from air
		else if(choice==1) {
			
			//for water
			int subans=0;
			if(armor-10>=0 && health-5>=0) {
				
				if(dp[armor-10][health-5]!=-1)
					subans=dp[armor-10][health-5];
				else
					subans=helper(armor-10,health-5,dp,2);
			}
			
			
			int subans2=0;
			//for fire
			if(armor+5>=0 && health-20>=0) {
				if(dp[armor+5][health-20]!=-1)
					subans2=dp[armor+5][health-20];
				else
					subans2=helper(armor+5,health-20,dp,3);
			}
			
			int ans=Math.max(subans, subans2)+1;
			dp[armor][health]=ans;
			return ans;
		}
		
		//if we jump from water
		else if(choice==2) {
			
			//for air
			int subans=0;
			if(armor+2>=0 && health+3>=0) {
				
				if(dp[armor+2][health+3]!=-1)
					subans=dp[armor+2][health+3];
				else
					subans=helper(armor+2,health+3,dp,1);
			}
			
			
			int subans2=0;
			//for fire
			if(armor+5>=0 && health-20>=0) {
				if(dp[armor+5][health-20]!=-1)
					subans2=dp[armor+5][health-20];
				else
					subans2=helper(armor+5,health-20,dp,3);
			}
			
			int ans=Math.max(subans, subans2)+1;
			dp[armor][health]=ans;
			return ans;
		}
		
		//if we jump from fire
		else {
			
			//for air
			int subans=0;
			if(armor+2>=0 && health+3>=0) {
				
				if(dp[armor+2][health+3]!=-1)
					subans=dp[armor+2][health+3];
				else
					subans=helper(armor+2,health+3,dp,1);
			}
			
			
			int subans2=0;
			//for water
			if(armor-10>=0 && health-5>=0) {
				
				if(dp[armor-10][health-5]!=-1)
					subans2=dp[armor-10][health-5];
				else
					subans2=helper(armor-10,health-5,dp,2);
			}
			
			int ans=Math.max(subans, subans2)+1;
			dp[armor][health]=ans;
			return ans;
		}

	}
	 */

}
