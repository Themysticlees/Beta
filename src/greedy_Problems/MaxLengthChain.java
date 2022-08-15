package greedy_Problems;
import java.util.*;
/*
 * You are given N pairs of numbers. In every pair, the first number is always smaller than the 
 * second number. A pair (c, d) can follow another pair (a, b) if b < c. Chain of pairs can be formed 
 * in this fashion. You have to find the longest chain which can be formed from the given set of pairs. 
 * 
 *  Input:
	N = 5
	P[] = {5  24 , 39 60 , 15 28 , 27 40 , 50 90}
	Output: 3
	Explanation: The given pairs are { {5, 24}, {39, 60},
	{15, 28}, {27, 40}, {50, 90} },the longest chain that
	can be formed is of length 3, and the chain is
	{{5, 24}, {27, 40}, {50, 90}}
 */
public class MaxLengthChain {
	/*
	 * The idea is to make a chain of the pair, such that second parameter of the first pair is smaller
	 * than the first parameter of the second pair
	 * 
	 * The first step is to sort them according to the second parameter, thus the first Pair will 
	 * have the least value second parameter. Thus it will always be a part of the chain. Now keeping 
	 * the first Pair, we start checking for  other Pairs.
	 */
	static int maxChainLength(Pair3 arr[], int n)
    {
       // your code here
        Arrays.sort(arr,new CompareBySecond());
        
        //second paramater of the first Pair
        int end=arr[0].y;
        int maxlength=1;
        
        for(int i=1;i<n;i++){
            //compare the end value with the first parameter of the second Pair
        	//If the condition satisfies, change the end value and increase the maxlength
            if(arr[i].x>end){
                end=arr[i].y;
                maxlength++;
            }
        }
        
        return maxlength;
    }
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int n=5;
		
		Pair3[] arr=new Pair3[n];
		
		for(int i=0;i<n;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			
			Pair3 temp=new Pair3(a, b);
			arr[i]=temp;
		}
		
		System.out.println(maxChainLength(arr, n));
	}
}

class Pair3{
	int x;
	int y;
	public Pair3(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

class CompareBySecond implements Comparator<Pair3>
{
   public int compare(Pair3 a, Pair3 b)
    {
        return a.y - b.y;
    }
}
