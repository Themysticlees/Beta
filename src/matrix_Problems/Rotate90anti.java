package matrix_Problems;

public class Rotate90anti {
	
	static void rotate(int matrix[][]) 
    {
        /*
         * 1 2 3  	3 6 9
         * 4 5 6  =	2 5 8
         * 7 8 9	1 4 7
         */
		
		//first transpose the matrix
        int n=matrix.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        
        int i=0;
        int k=n-1;
        
        //then swap the first and last rows until
        //you reach the middle
        while(i<k){
            for(int j=0;j<n;j++)
            {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[k][j];
                matrix[k][j]=temp;
            }
            i++;
            k--;
        }
    }
		
	
	public static void main(String[] args) {
		
		int[][] matrix= {{1,2,3},{4,5,6},{7,8,9}};
		
		rotate(matrix);
	}

}
