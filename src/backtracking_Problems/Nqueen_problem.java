package backtracking_Problems;

public class Nqueen_problem {
	
	public static boolean Nqueen(int[][] board, int row,int n) {
		
		//base condn
		//if row is equal to n i.e all the queens have been placed
		//thus return true
		if(row==n)
			return true;
		
		//take the row and check for each of it's column
		for(int col=0;col<n;col++) {
			//if it is safe to place then place the queen
			if(isSafe(board, row, col,n)) {
				board[row][col]=1;
				
				//recursive call the function with row+1
				//as we need to place the next queen in the next row
				//if this func returns true i.e it has found a suitable index for
				//the next queen
				//If it returns false i.e it hasnt found an index thus we need to backtrack
				if(Nqueen(board,row+1,n))
					return true;
				
				//change the current queens position and continue the loop
				board[row][col]=0;
			}
		}
		return false;
		
	}
	
    public static boolean isSafe(int[][] board, int row, int col,int n) {
		
    	//This checks whether there is any other queen in the coln
    	for(int i=0;i<=row;i++)
    		if(board[i][col]==1)
    			return false;
    	
    	//this checks whether there is any other queen in the left upper diagonal
    	int i=row,j=col;
    	while(i>=0 && j>=0) {
    		if(board[i][j]==1)
    			return false;
    		i--;
    		j--;
    	}
    	
    	//this checks whether there is any other queen in the right upper diagonal
    	i=row;j=col;
    	while(i>=0 && j<n) {
    		if(board[i][j]==1)
    			return false;
    		i--;
    		j++;
    	}
    	
    	//we are not checking the below rows because they are empty
    	//if all the conditions passes then return true
    	//this means this index is a safe one
		return true;
	}

	public static void main(String[] args) {
		
		int n=6;
		int board[][] = new int[n][n];
		
		//initialize the 2d array with zeros
		for(int i=0;i<board.length;i++) 
			for(int j=0;j<board[0].length;j++)
				board[i][j]=0;
		
		//if the fn returns false there is no soln
		if (Nqueen(board, 0 , n) == false) {
			System.out.print("Solution does not exist");
		}
		else
		{//else print the 2d array
			for(int i=0;i<board.length;i++) {
				for(int j=0;j<board[0].length;j++)
					System.out.print(board[i][j]+"  ");
				System.out.println();
			}
		}	
	}
}
