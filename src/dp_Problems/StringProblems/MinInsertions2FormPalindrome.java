package dp_Problems.StringProblems;

/*
 * Given a string, find the minimum number of characters to be inserted to convert it to palindrome.
	For Example:
	ab: Number of insertions required is 1. bab or aba
	aa: Number of insertions required is 0. aa
	abcd: Number of insertions required is 3. dcbabcd
	
	Input:
	abcd
	Output:
	3
	Explanation:
	Here we can append 3 characters in the 
	beginning,and the resultant string will 
	be a palindrome ("dcbabcd").
 */

public class MinInsertions2FormPalindrome {
	
	//to find the number of characters needed to add to make a word palindrome, first we need to find the 
	//longest palindromic subsequence, now for the characters which belong of LPS, we dont need to think about them
	//the characters which donot form a LPS, we need to add the same amount of characters to make the entire string
	//a palindrome.
	//In a palindrome, every character appears twice except the middle one, thus we need to find those 
	//characters which donot form a LPS, and add the same amount of characters to make the string a palindrome
	int findLcs(String s1, String s2, int[][] arr){
        
        int m=arr.length;
        int n=arr[0].length;
        
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(s1.charAt(i)==s2.charAt(j))
                    arr[i][j]=1+arr[i-1][j-1];
                else
                    arr[i][j]=Math.max(arr[i][j-1],arr[i-1][j]);
            }
        }
        
        return arr[m-1][n-1];
    }
    
    String reverse(String s){
        String res="";
        
        for(int i=s.length()-1;i>=0;i--)
            res+=s.charAt(i);
        return res;
    }
    
    int findMinInsertions(String s1){
        // code here 
        
    	//Inorder to find the which characters donot form a LPS
    	//we can find the characters that form LPS and subtract it from the string length
    	
    	//finding the lps
        String s2=reverse(s1);
        s1=" "+s1;
        s2=" "+s2;
        int[][] arr=new int[s1.length()][s2.length()];
        
        //finally, subtracting the length of palindromic sequence from the string length
        //this will give us the number of non-palindromic characters and since we have add them again
        //we just return that
        return (s1.length()-1)-findLcs(s1,s2,arr);
        
    }

}
