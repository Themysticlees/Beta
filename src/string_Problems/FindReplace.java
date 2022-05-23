package string_Problems;
/*
 * Given a string S on which you need to perform Q replace operations.
 * Each replacement operation has 3 parameters: a starting index i, a source word x and a target word y.
 * The rule is that if x starts at position i in the original string S, then we will replace that 
 * occurrence of x with y. If not, we do nothing.
 * Note: All these operations occur simultaneously. It's guaranteed that there won't be any overlap
 * in replacement: for example, S = "abc", indexes = [0,1], sources = ["ab", "bc"] is not a
 * valid test case.
 */
public class FindReplace {
	
	//We have to check the indexes and the original string, if the given substrings start from the 
	//specified index then replace that substring with the target string
	static String findAndReplace(String s, int q, int[] index, String[] sources,
            String[] targets) {
		// code here

		int n=s.length();
		//for keeping a count in the operations array
		int k=0;
		String ans="";
		
		for(int i=0;i<n;i++){
		
			//if k is within array limit and index specified matches with i
			if(k<q && i==index[k]){
				//calculating the length of the specified string
				int newlen=sources[k].length();
				
				//now extracting the substring from the original string to match with 
				//the given substring. Exract by passing substring method from i to the length of the 
				//specified string, since both the strings must be same thus they must have same length
				String tempOriginal = s.substring(i,i+newlen);
				
				//if both the strings are equal then add the string to the ans
				//increase i by the length of the old string as we need to check for those indexes
				if(tempOriginal.equals(sources[k])){
					ans+=targets[k];
					i+=newlen-1;
				}
				//if they donot match just add the character of the old string
				else
					ans+=s.charAt(i);
				k++;
			}
			//	otherwise just add the character in the new string
			else
				ans+=s.charAt(i);
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		
		String S = "gforks";
		int Q = 2;
		int index[] = {0, 4};
		String sources[] = {"g", "ss"};
		String targets[] = {"geeks", "geeks"};
		
		System.out.println(findAndReplace(S, Q, index, sources, targets));
	}

}
