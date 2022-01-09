package utilty_Algorithm;

public class Patterns {
	
	public static void main(String[] args) {
		MainPattern ob = new MainPattern();
		ob.Pattern1(5);
	}
}

class MainPattern{
	
	public void Pattern1(int n) {
		
		for(int i=1;i<=n;i++) 
		{
			
			for(int j=1;j<=n-i;j++)
				System.out.print(" ");
			
			for(int k=1;k<=i;k++)
			{
				System.out.print("*");
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	public void pyramidPattern(int n) 
    {  
        for (int i=0; i<n; i++) //outer loop for number of rows(n) { for (int j=n-i; j>1; j--) //inner loop for spaces
            { 
                System.out.print(" "); //print space
            
            for (int j=0; j<=i; j++ ) //inner loop for number of columns
            { 
                System.out.print("* "); //print star
            } 
  
            System.out.println(); //ending line after each row
        } 
    } 

}