package string_Problems;
import java.util.*;
/*
 * The count-and-say sequence is the sequence of integers beginning as follows: 
	1, 11, 21, 1211, 111221, ...
	1 is read off as one 1 or 11. 11 is read off as two 1s or 21.
	21 is read off as one 2, then one 1 or 1211.
 */
public class Count_Say {
	
	public String countAndSay(int n) {
		//we initially start from 1
        String s="1";
        //as we have already calculated for n=1
        n--;
        while(n-->0)
        {
        	//calculate the pairs for the current string
            List<Pair> p=createPairs(s);
            //store the newly formed string into s
            //and the loop continues until n becomes 0
            s=createString(p);
        }
       
        return s;
    }
   
	/*
	 * This function will create pairs of the count and the number.
	 */
    public List<Pair> createPairs(String s){
       
        List<Pair> list = new ArrayList<>();
       
        //Extract the first number and set count to 1
        int prev=s.charAt(0)-'0';
        int count=1;
        for(int i=1;i<s.length();i++){
            int ch = s.charAt(i)-'0';
            //if the next number matches with the prev number
            //then simply increase count
            if(ch==prev)
                count++;
            else
            	//otherwise, add the count and the prev number
            	//set prev to the current number and count to 1
            {
                list.add(new Pair(prev,count));
                prev=ch;
                count=1;
            }
        }
       
        //add the last number and count
        list.add(new Pair(prev,count));
       
        return list;
    }
   
    /*
     * This number will convert the list of pairs to a string
     */
    public String createString(List<Pair> list){
       
        String ans="";
       
        for(Pair p:list){
            ans+=p.b;
            ans+=p.a;
        }
       
        return ans;
    }
	public static void main(String[] args) {
		
		System.out.println(new Count_Say().countAndSay(3));
	}


}


class Pair{
    
	 int a;
	    int b;
	   
	    Pair(int a,int b){
	        this.a=a;
	        this.b=b;
	    }

		@Override
		public String toString() {
			return "Pair [a=" + a + ", b=" + b + "]";
		}
	   
}
