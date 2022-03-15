package stack_queueProblems;
import java.util.*;
/*
 * Given a grid of dimension nxm where each cell in the grid can have values 0, 1 or 2 which 
 * has the following meaning:
	0 : Empty cell
	1 : Cells have fresh oranges
	2 : Cells have rotten oranges
	
	We have to determine what is the minimum time required to rot all oranges. 
	A rotten orange at index [i,j] can rot other fresh orange at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] 
	(up, down, left and right) in unit time. 
 
    Input: grid = {{0,1,2},{0,1,2},{2,1,1}}
	Output: 1
	Explanation: The grid is-
	0 1 2
	0 1 2
	2 1 1
	Oranges at positions (0,2), (1,2), (2,0)
	will rot oranges at (0,1), (1,1), (2,2) and 
	(2,1) in unit time.
 */
public class RottenOranges {
	
	//Put all the indexes of the rotten oranges in the queue and then add a null to separate this list
	//pop one index at a time, do a bfs, rot all the adjacent oranges and add them in the queue
	public static int orangesRotting(int[][] matrix)
    {
        // Code here
        int n=matrix.length;
        int m=matrix[0].length;
        Queue<List<Integer>> queue= new LinkedList<>();
		
        //keep a count on the no.of fresh oranges
		int fresh=0;
		
		//Putting all the rotten oranges in queue
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++) {
				
				if(matrix[i][j]==2)
				{
					List<Integer> list = new LinkedList<>();
					
					list.add(i);
					list.add(j);
					
					queue.offer(list);
				}
				else if(matrix[i][j]==1)
					fresh++;
					
			}
		}
		//adding this to separate the list from other elements
		queue.offer(null);
		
		//this counts the time required to rot all the oranges
		//for a single list in the queue, it takes 1 time
		int turns=0;
		while(!queue.isEmpty()) {
			
			//until we reach the end of the list
			while(queue.peek()!=null) {
			
			//take the index of the rotten orange
			int i=queue.peek().get(0);
			int j=queue.peek().get(1);
			queue.poll();
			
			//check for all it's adjacent positions, if there is a fresh orange
			//rot it, add it's index to the queue and decrease fresh
			if(i-1>=0 && matrix[i-1][j]==1)
			{
				matrix[i-1][j]=2;
				List<Integer> list = new LinkedList<>();
				
				list.add(i-1);
				list.add(j);
				
				fresh--;
				queue.offer(list);
			}
					
			if(i+1<n && matrix[i+1][j]==1)
			{
				matrix[i+1][j]=2;
				List<Integer> list = new LinkedList<>();
				
				list.add(i+1);
				list.add(j);
				
				fresh--;
				
				queue.offer(list);
			}
			
			if(j-1>=0 && matrix[i][j-1]==1)
			{
				matrix[i][j-1]=2;
				List<Integer> list = new LinkedList<>();
				
				list.add(i);
				list.add(j-1);
				
				fresh--;
				
				queue.offer(list);
			}
					
			if(j+1<m && matrix[i][j+1]==1)
			{
				matrix[i][j+1]=2;
				List<Integer> list = new LinkedList<>();
				
				list.add(i);
				list.add(j+1);
				
				fresh--;
				
				queue.offer(list);
			}		
			
			
					
			}
			//After 1 single list is completed
			//poll the null element
			queue.poll();
			
			//if the queue is empty then put a null, which will again act as a separator or delimiter 
			//and increase turn
			if(!queue.isEmpty())
			{
				queue.offer(null);
				turns++;
			}
			
			//if there are no fresh oranges, then no need to check again
			//return turns
			if(fresh==0)
				return turns;
		}
		
		//if the queue becomes empty and we still have fresh oranges,
		//then we cannot rot them and there is no way
		//thus return -1 otherwise return turns
		if(fresh==0)
			return turns;
		return -1;
    }
	
	public static void main(String[] args) {
		
		int[][] arr= {{1, 2, 0 ,2, 2},{2, 1, 2, 1, 2},{1, 2, 2, 1, 2},
				{2, 1, 1, 2, 2},{2 ,1 ,2, 1, 1},{0, 1, 1, 0, 1}};
		System.out.println(orangesRotting(arr));
	}

}
