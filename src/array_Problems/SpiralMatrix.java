package array_Problems;

import java.util.ArrayList;

public class SpiralMatrix {
	
	public static ArrayList<Integer> spiralMatrix(int matrix[][], int r,int c) 
    {
		//we are taking 4 points which are indicating four corners in a matrix
		/*
		 *				  		left	  right
		 int matrix[][] = top	{{1, 2, 3, 4},
		            	  		{5, 6, 7, 8},
		            	  		{9, 10, 11, 12},
		            	  down	{13, 14, 15,16}};
		 */
		int left=0,top=0;
		int right=c-1;
		int down=r-1;
		
		/*
		 	case1: when direction=0 then it will move from left to right
		 	case2:when direction=1 then it will move from top to down
		 	case3:when direction=2 then it will move from right to left
		 	case4:when direction=3 then it will move from down to top
		 
		*/
		int direction=0;
		
		ArrayList<Integer> list = new ArrayList<>();
		
		//matrix[row][coloum]
		while(left<=right && top<=down) {
			
			if(direction==0)
			{//move from left to right keeping top(row) as constant 
				for(int i=left;i<=right;i++){
					list.add(matrix[top][i]);
				}
				top++;//because that particular row is done
			}
			
			else if(direction==1)
			{//move from top to down keeping right(coloum) as constant 
				for(int i=top;i<=down;i++) {
					list.add(matrix[i][right]);
				}
				right--;//because that particular coloum is done
			}
			else if(direction==2)
			{//move from right to left keeping down(row) as constant
				for(int i=right;i>=left;i--) {
					list.add(matrix[down][i]);
				}
				down--;//because that particular row is done
			}
			else
			{//move from down to top keeping left(coloum) as constant 
				for(int i=down;i>=top;i--)
					list.add(matrix[i][left]);
				left++;//because that particular coloum is done
			}
			
			//at the end increase dir by 1, when it reaches 4 we'll go back to case 1 
			//thus mod it by 4 so ans will be 0.
			direction=(direction+1)%4;
		}
		
		return list; 
        
    }  
	
	public static void main(String[] args) {
		
		int matrix[][] = {{1, 2, 3, 4},
		            	  {5, 6, 7, 8},
		            	  {9, 10, 11, 12},
		            	  {13, 14, 15,16}};
		
		System.out.println(spiralMatrix(matrix, matrix.length, matrix[0].length));
	}

}
