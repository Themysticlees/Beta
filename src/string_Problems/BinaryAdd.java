package string_Problems;

public class BinaryAdd {
	
	public static String addBinary(String A, String B) {

        String res="";

        int i=A.length()-1;
        int j=B.length()-1;

        int carry=0;
        while(i>=0 && j>=0){

            char ch=A.charAt(i);
            char ch2=B.charAt(j);

            if(ch=='0' && ch2=='0')
            {
                if(carry==1)
                    res='1'+res;
                else
                    res='0'+res;
                carry=0;
            }

            else if((ch=='0' && ch2=='1') || (ch=='1' && ch2=='0'))
            {
                if(carry==1)
                {
                    res='0'+res;
                    carry=1;
                }
                else{
                    res='1'+res;
                    carry=0;
                }
            }
            
            else if(ch=='1' && ch2=='1')
            {
                if(carry==1)
                {
                    res='1'+res;
                    carry=1;
                }
                else{
                    res='0'+res;
                    carry=1;
                }
            }

            i--;
            j--;    
            
        }

        while(i>=0){
            char ch=A.charAt(i);

            if(carry==1)
            {
                if(ch=='1'){
                    res='0'+res;
                    carry=1;
                }
                else{
                    res='1'+res;
                    carry=0;
                }
            }
            else
                res=ch+res;
            i--;
        }
        while(j>=0){
            char ch=B.charAt(j);

            if(carry==1)
            {
                if(ch=='1'){
                    res='0'+res;
                    carry=1;
                }
                else{
                    res='1'+res;
                    carry=0;
                }
            }
            else
                res=ch+res;
            j--;
        }
        if(carry==1)
        	res='1'+res;
        return res;
	}
	
	//less code
	public static String binaryAdd(String a, String b) {
		
		if(a.length()<b.length()) {
			int diff=b.length()-a.length();
			while(diff-->0)
				a='0'+a;
		}
		
		else
		{
			int diff=a.length()-b.length();
			while(diff-->0)
				b='0'+b;
		}
		
		//System.out.println("string "+a);
		
		int carry=0;
		String res="";
		
		for(int i=a.length()-1;i>=0;i--) {
			char ch=a.charAt(i);
            char ch2=b.charAt(i);
            
            int a1=(int)ch -48;
            int b1=(int)ch2 -48;
            
            System.out.println(a1+" "+b1);
            
            
            int sum=(a1+b1+carry)%2;
            carry=(a1+b1+carry)/2;
            
            res=Integer.toString(sum)+res;
		}
		return res;
	}
		
	
	public static void main(String[] args) {
		
		String A=   "1010110111001101101000";
		String B="1000011011000000111100110";
		
		System.out.println(binaryAdd(A, B));
	}

}
