package string_Problems;
/*
 * The count-and-say sequence is the sequence of integers beginning as follows: 
	1, 11, 21, 1211, 111221, ...
	1 is read off as one 1 or 11. 11 is read off as two 1s or 21.
	21 is read off as one 2, then one 1 or 1211.
 */
public class Count_Say {
	
	public static String countAndSay(int A) {

        String str="1";
        
        while(--A>0){
        	//we take the first the character of the string
        	//for comparing
            char c=str.charAt(0);
            //count is 0 because we'll be comparing the first 
            //character with itself
            int count=0;
            String res="";

            for(int i=0;i<str.length();i++){
                char ch=str.charAt(i);
                //we are storing the previous element in c
                //if the prev element is equal to the curr element
                //then increase count
                if(ch==c)
                    count++;
                else
                {
                	//if not then store previous count in the string
                	//i.e if there were three 1s then store "31"
                    res=res+Integer.toString(count)+c;
                    //update c to the current element
                    //and count to 1
                    c=ch;
                    count=1;
                }
            }
            //when the loop ends add the last character count to the 
            //string too
            res=res+Integer.toString(count)+c;
            //then re initialize str with res and repeat the steps
            str=res;
        }
        return str;
    }

	public static void main(String[] args) {
		
		System.out.println(countAndSay(3));
	}


}
