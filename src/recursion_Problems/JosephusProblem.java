package recursion_Problems;

/*
 * Given the total number of persons n and a number k which indicates that k-1 persons are skipped 
 * and kth person is killed in circle in a fixed direction.
 * The task is to choose the safe place in the circle so that when you perform these operations 
 * starting from 1st place in the circle, you are the last one remaining and survive.
 * 
 *  Input:
	n = 5 k = 3
	Output: 4
	Explanation: There are 5 persons so 
	skipping 2 person i.e 3rd person will 
	be killed. Thus the safe position is 4.
 */
public class JosephusProblem {
	/*
	 * Every time, we eliminate a person, the count starts from the next person
	 * Thus it becomes the 0 (starting number), thus we'll keep doing this
	 * We can easily convert to the prev number by a formulae y=(x+k)%n
	 * 
	 * For better explanation: https://www.youtube.com/watch?v=dzYq5VEMZIg
	 */
	public int josephus(int n, int k)
    {
        //Your code here
        int ans=helper(n,k);
        //+1 if 1-based indexing
        return ans+1;
    }
    
    public int helper(int n, int k){
    	//When we have just 1 number remaining just return 0 (starting number)
        if(n==1)
            return 0;
        
        //This will return the person who will survive
        int x=helper(n-1,k);
        //convert it as we changed the number for the function calls
        int y=(x+k)%n;
        
        //and return it
        return y;
    }
    
}
