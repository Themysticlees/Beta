package graph_Problems;
import java.util.*;
public class MinStepsKnight {
	/*
	 * Given a square chessboard, the initial position of Knight and position of a target. 
	 * Find out the minimum steps a Knight will take to reach the target position.
	 * Note:
	 * The initial and the target position coordinates of Knight have been given 
	 * according to 1-base indexing.
	 * 
	 *  Input:
		
		N=6
		knightPos[ ] = {4, 5}
		targetPos[ ] = {1, 1}
		Output:
		3
		
		Knight takes 3 step to reach from 
		(4, 5) to (1, 1):
		(4, 5) -> (5, 3) -> (3, 2) -> (1, 1).
	 */

	public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        //We'll be using BFS to store all the chances and maintain a visited array
		//to store the  no.of steps taken to reach that index
        Queue<int[]> queue = new LinkedList<>();
        
        //if the target index is the initial index
        if(KnightPos[0]==TargetPos[0] && KnightPos[1]==TargetPos[1])
            return 0;
            
        int[][] visited=new int[N+1][N+1];
        
        visited[KnightPos[0]][KnightPos[1]]=0;
        queue.add(KnightPos);
        
        while(!queue.isEmpty()){
            int[] temp=queue.poll();
            
            //current column and row
            int col=temp[0];
            int row=temp[1];
            
            //checking for all the chances that are possible
            //for uppermost row chances
            if(col-1>=1 && row+2<=N && visited[col-1][row+2]==0){
                //adding 1 with the current steps and store it in the new index  
                visited[col-1][row+2]=1+visited[col][row];
                queue.add(new int[]{col-1,row+2});
            }
            
            if(col+1<=N && row+2<=N && visited[col+1][row+2]==0){
                
                visited[col+1][row+2]=1+visited[col][row];
                queue.add(new int[]{col+1,row+2});
            }
                
            //for upper row chances
            if(col-2>=1 && row+1<=N && visited[col-2][row+1]==0){
                
                visited[col-2][row+1]=1+visited[col][row];
                queue.add(new int[]{col-2,row+1});
            }
            
            if(col+2<=N && row+1<=N && visited[col+2][row+1]==0){
                
                visited[col+2][row+1]=1+visited[col][row];
                queue.add(new int[]{col+2,row+1});
            }
                
            //for lower row chances
            if(col-2>=1 && row-1>=1 && visited[col-2][row-1]==0){
                
                visited[col-2][row-1]=1+visited[col][row];
                queue.add(new int[]{col-2,row-1});
            }
            
            if(col+2<=N && row-1>=1 && visited[col+2][row-1]==0){
                
                visited[col+2][row-1]=1+visited[col][row];
                queue.add(new int[]{col+2,row-1});
            }
                
            //for lowest row chances
            if(col-1>=1 && row-2>=1 && visited[col-1][row-2]==0){
                
                visited[col-1][row-2]=1+visited[col][row];
                
                queue.add(new int[]{col-1,row-2});
            }
            
            if(col+1<=N && row-2>=1 && visited[col+1][row-2]==0){
               
                visited[col+1][row-2]=1+visited[col][row];
                queue.add(new int[]{col+1,row-2});
            }
        }
        
        //if the knight was able to reach this index, then it must contain the steps required 
        //if not, then it will return 0
        return visited[TargetPos[0]][TargetPos[1]];
    }
}
