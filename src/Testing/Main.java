package Testing;
import java.util.*;
import java.util.regex.Pattern;

public class Main {
	
	public static int power(String A) {
        
        int last=A.charAt(A.length()-1)-'0';
        int first=A.charAt(0)-'0';
        if(last%2!=0)
            return 0;
        if(A.equals("2"))
            return 1;

        int rem=0;
		String div="";
		for(int i=0;i<A.length();i++) {
			int ch=A.charAt(i)-'0';
			
			ch=rem*10+ch;
			if(ch<2) {
				rem=rem*10+ch;
				continue;
			}
				
			
			div=div+(ch/2);
			rem=ch%2;
			
		}
        return power(div);
    }
	
	public static void main(String[] args) {
		
		System.out.println(power("147573952589676412928"));
	}
	
}


