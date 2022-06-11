package recursion_Problems;

public class TowerOfHanoi {
	
	/*
	 * Algo:
	 * Given any number of rings, they can be transferred from box 1 to box 3 using box 2 
	 * using the following steps.
		Step 1: Transfer first N-1 plates from box 1 to box 2 using box 3.(recursive call)
		Step 2: Transfer the remaining plate from box 1 to box 3.
		Step 3: Transfer the first N-1 plates from box 2 to box 3 using box 1.(recursive call)
	 */
	public static void towerOfHanoi(int n, int a, int b, int c){

		if(n>0){
			towerOfHanoi(n-1,a,c,b);
			System.out.println("Move the disc from "+a+" to "+c);
			towerOfHanoi(n-1,b,a,c);
		}
	}
	
	public static void main(String[] args) {
		
		int n=3;
		towerOfHanoi(n, 1, 2, 3);
	}

}
