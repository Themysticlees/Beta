package string_Problems;

public class SubstrwithVowelsandCons {
	
	public static  int solve(String str) {

        int vow=0,con=0;
        
        //calculate the no.of vowels and consonants first
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')
                vow++;
            else
                con++;
        }
        
        int ans=0;
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')
            {	
            	//for each vowel encountered add all the consonants as it will 
            	//make substrings with all the consonants
                ans=ans+con;
                //decrease vowels count by 1 as this vowel is used
                vow--;
            }
            else{
            	//similarly add all the vowels encountered and decrease 
            	//consonant count by 1 as it is used
                ans=ans+vow;
                con--;
            }
            
        }
        return ans%1000000007;
        
    }
	
	public static void main(String[] args) {
		
		String str="aba";
		
		System.out.println(solve(str));
		
	}

}
