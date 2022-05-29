package bitManipulation_Problems;
/*
 * Given a string array words, return the maximum value of length(word[i]) * length(word[j])
 * where the two words do not share common letters. If no such two words exist, return 0.
 * 
 *  Input: words = ["abcw","baz","foo","bar","xtfn","abcdef"]
	Output: 16
	Explanation: The two words can be "abcw", "xtfn".
 */
public class MaxProductWordLengths {
	
	public int maxProduct(String[] words) {
        
        int n=words.length;
        
        int[] binary = new int[n];
        
        //we are creating a 26 bit Integer for each word
        //each digit represent a character from the word
        for(int i=0;i<n;i++){
            for(char ch:words[i].toCharArray()){
                //for each character we are generating a 26 bit integer
                //by left shifting 1
                //and then doing an OR operation to merge them
                binary[i]=binary[i]|(1<<(ch-'a'));
            }
        }
        
        int ans=0;
        
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if((binary[i]&binary[j]) == 0){
                    //for checking two words
                    //perform and operation, if they have different letters
                    //then it will result 0 
                    int len=words[i].length()*words[j].length();
                    ans=Math.max(ans,len);
                }
            }
        }
        
        return ans;
    }

}
