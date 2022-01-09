package string_Problems;

public class ValidNum {
	
	public static int isNumber(final String A) {

        int n=A.length();
        
        //These two conditions are checked separetely because
        //upon converting into double they wont cause an exception
        if(A.charAt(n-1)=='.')
            return 0;
        
        if(n>2)
        {
            if(A.charAt(n-2)=='e')
                return 0;
        }
        
        //Rest of all the cases will generate exception
        //if exception is generated then we can be sure that
        //it is not a number (NaN) thus return 0
        try{
             Double num=Double.parseDouble(A);
             return 1;
        }
        catch(Exception e)
        {
            return 0;
        }
    }
	
	public static void main(String[] args) {
		
		String str="101";
		System.out.println(isNumber(str));
	}

}
