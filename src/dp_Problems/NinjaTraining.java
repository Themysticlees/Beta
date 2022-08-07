package dp_Problems;
import java.util.*;
/*
 * Ninja is planing this 'N' days-long training schedule. Each day, he can perform any one of these 
 * three activities. (Running, Fighting Practice or Learning New Moves). Each activity has some merit 
 * points on each day. As Ninja has to improve all his skills, he can't do the same activity in two 
 * consecutive days. Can you help Ninja find out the maximum merit points Ninja can earn?
 * You are given a 2D array of size N*3 'POINTS' with the points corresponding to each day and activity. 
 * Your task is to calculate the maximum number of merit points that Ninja can earn.
 * 
 *  Input:
 * 	3
	1 2 5 
	3 1 1
	3 3 3
	
	Output:
	11
	
	One of the answers can be:
	On the first day, Ninja will learn new moves and earn 5 merit points. 
	On the second day, Ninja will do running and earn 3 merit points. 
	On the third day, Ninja will do fighting and earn 3 merit points. 
	The total merit point is 11 which is the maximum. 
	Hence, the answer is 11.
 */
public class NinjaTraining {
	
	//Memoization
	public static int ninjaTraining1(int n, int points[][]) {

        // Write your code here..
        int[][] dp = new int[n][4];
        
         for(int[] i:dp)
            Arrays.fill(i,-1);
        
         return helper(n-1,points,dp,3);
	}
	
	//The idea is to try all possible ways
	//For every day, we'll keep a record of the previous day's task and according do the curr
	//day's task.
	public static int helper(int day, int[][] points, int[][] dp, int choice){
        
		//if we reach the last day, just calculate the max of the 2 new tasks and return
        if(day==0)
        {
            int max=0;
            for(int i=0;i<3;i++){
                if(i!=choice)
                    max=Math.max(max,points[day][i]);
            }
            return max;
        }
        
        //if we have already calculated for a particular day and particular task done
        //then just return the stored value
        if(dp[day][choice]!=-1)
            return dp[day][choice];
        
        //otherwise we need to calculate the max merit points he can earn
        int max=0;
        for(int i=0;i<3;i++){
        	//we'll iterate through the task
        	//if the curr task doesnt match with the prev day's task then just add it and call a
        	//recursive function which will do the same job
            if(i!=choice){
                int temp=points[day][i]+helper(day-1,points,dp,i);
                max=Math.max(max,temp);
            }
            //calculate the max merit points earned out of all tasks performed on that day
        }
        //store it in the dp and return
        return dp[day][choice]=max;
    }
	
	//Tabulation (without recursion)
	public static int ninjaTraining2(int n, int points[][]) {

        int[][] dp = new int[n][4];
        
        //First step write down the base case here
        //for the last day, if we have done the 1st job earlier, just store the max of the 2nd and 3rd task
        //similarly for all other tasks do the same
        //if we have done no tasks, then calculate max of all
        dp[0][0]=Math.max(points[0][1],points[0][2]);
        dp[0][1]=Math.max(points[0][0],points[0][2]);
        dp[0][2]=Math.max(points[0][1],points[0][0]);
        dp[0][3]=Math.max(points[0][1],Math.max(points[0][2],points[0][0]));
        
        //for each day from 1 to n (0th day is the base case, already calculated)
        for(int day=1;day<n;day++){
        	//we need to calculate for every prev task done
            for(int last=0;last<=3;last++){
            	//and for every new task to be done
                for(int task=0;task<=2;task++){
                	//now for every task which doesnt match the prev task
                	//calculate the max merit points that can be earned by using the prev day's value
                	//which has already been calculated
                    if(task!=last){
                        int temp=points[day][task]+dp[day-1][task];
                        dp[day][last]=Math.max(dp[day][last],temp);
                    }
                }
            }
        }
        
        return dp[n-1][3];
    }
	
	//We can further reduce the space complexity by taking variables instead of a 2D array
	//For calculating every day, we need to data of the previous day and for the next day calculation
	//The current day becomes the previous day so just need the prev day data
	//Thus we can use variables
	public static void main(String[] args) {
		
		int[][] arr= {{1,2,5},
					  {3,1,1},
					  {3,3,3}};
		
		System.out.println(ninjaTraining2(arr.length, arr));
	}
	
}

