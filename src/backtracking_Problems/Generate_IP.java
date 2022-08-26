package backtracking_Problems;
import java.util.*;
/*
 * Given a string S containing only digits, Your task is to complete the function genIp() which 
 * returns a vector containing all possible combinations of valid IPv4 IP addresses and takes only 
 * a string S as its only argument.
 * Note: Order doesn't matter. A valid IP address must be in the form of A.B.C.D, where A, B, C, 
 * and D are numbers from 0-255. The numbers cannot be 0 prefixed unless they are 0.
 * 
 * For string 11211 the IP address possible are 
	1.1.2.11
	1.1.21.1
	1.12.1.1
	11.2.1.1


 */
public class Generate_IP {
	/*
	 * So we need to generate all the possible valid IPs.
	 * Since we need to put three dots and divide the string into 4 parts, we need 3 loops
	 */
	public ArrayList<String> genIp(String s) {
        // code here
        int n=s.length();
        ArrayList<String> ans=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    //After getting the indexes of the dots, generate the Ip string
                    String str=generate(s,i,j,k);
                    
                    if(str.length()>1)
                        ans.add(str);
                }
            }
        }
        
        return ans;
    }
    
    
    public String generate(String s, int i, int j, int k){
        
    	/*
    	 * There should be four parts of the IP and since we have got 3 points
    	 * (0,i), (i+1,j), (j+1,k), (k+1,n)
    	 * These should the the four parts of the IP
    	 * 
    	 * After generating the parts check whether they are valid or not:
    	 * They should lie between 0-255
    	 * There shouldnt be any trailing zeros at the front
    	 * 
    	 * If all the cases satisfies, return it as a form of IP otherwise return empty string
    	 */
        String s1=s.substring(0,i+1);
        String s2=s.substring(i+1,j+1);
        String s3=s.substring(j+1,k+1);
        String s4=s.substring(k+1);
        
        
        if(check(s1) && check(s2) && check(s3) && check(s4))
            return s1+"."+s2+"."+s3+"."+s4;
        return "";
    }
    
    public boolean check(String s){
    	/*
 		 * After generating the parts check whether they are valid or not:
    	 * They should lie between 0-255
    	 * There shouldn't be any trailing zeros at the front
    	 * 
    	 */
        int n=s.length();
        if(n<=0 || n>3)
            return false;
        if(s.charAt(0)=='0' && n>1)
            return false;
            
        int num=Integer.parseInt(s);
        if(num<0 || num>255)
            return false;
            
        return true;
    }

}
