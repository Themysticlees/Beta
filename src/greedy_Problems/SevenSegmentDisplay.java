package greedy_Problems;

public class SevenSegmentDisplay {
	
	//You have a given number of size N
	//Find the number of segments in that number
	//and try to find the smallest numbers of the same number of segments of size N
	
	/*
	 * N = 6
		S = "234567"
		Output:
		000011
		Explanation:
		234567 has a total of 28 segments and
		we can rearrange them to form 000011
		which has 28 segments too. 000011 is the
		smallest possible number which can be
		formed on rearrangement.
	 */
	static String sevenSegments(String S, int N) {
        // code here
        
		//the number of segments in each digit
        int[] arr={6,2,5,5,4,5,6,3,7,5};
        
        int seg=0;
        
        //find the number of segments
        for(int i=0;i<N;i++)
            seg+=arr[S.charAt(i)-'0'];
        
        String res="";
        
        //now, if there is 1 digit remaining, then number of segments will lie from 2 to 7 
        //(as 2 is the min segs and 7 is the max)
        //similarly, if there are 2 digits remaining, then no.of segments will lie from 2*2 to 7*2
        //Thus we have to check everytime
        for(int i=N-1;i>=0;i--){
            
            for(int j=0;j<10;j++){
                //so we add j i.e 0, and check the rem segs, if they are valid, we proceed for the remaining digits
            	//if invalid, we increase j to 1 and check again
            	//since we are going from less to big, thus finally we get the smallest number with equal segments
                int rem=seg-arr[j];
                
                if(rem>=2*i && rem<=7*i)
                {
                    res=res+j;
                    seg=rem;
                    break;
                    
                }
            }
        }
        return res;
    }
	
	public static void main(String[] args) {
		
		String s="234567";
		System.out.println(sevenSegments(s, s.length()));
	}

}
