package stack_queueProblems;

//A matrix has been given of n people
//where in each row, if any index is 1, suppose arr[i][j] is 1 then i knows j
//a celebrity is a person who knows no one but everyone knows him
//so you have to find such person who is a celebrity

public class CelebrityProblem {

	//There is a n2 approach for this but in this approach
	//we will assume 0th person is the celebrity ie. c=0 so we'll check if 0 knows 1
	//if he knows, then certainly hes not a celebrity, thus we'll assume c=1 and check for the same
	int celebrity(int M[][], int n)
    {
    	// code here 
    	int c=0;
    	
    	for(int i=1;i<n;i++)
    	{
    	    if(M[c][i]==1)
    	        c=i;
    	}
    	
    	//To be sure that c is the celebrity
    	//we'll loop once more to check whether is there any person who doesnt know c
    	//and if c knows any ith person
    	
    	for(int i=0;i<n;i++){
    	    
    	    if(i!=c && (M[c][i]==1 || M[i][c]==0))
    	        return -1;
    	}
    	return c;
    }
	
}
