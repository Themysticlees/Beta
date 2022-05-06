package graph_Problems;
import java.util.*;
	
/*
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a 
 * sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
 * Every adjacent pair of words differs by a single letter.
 * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 * sk == endWord
 * Given two words, beginWord and endWord, and a dictionary wordList, return the number of words 
 * in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
 * 
 *  Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
	Output: 5
	Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", 
	which is 5 words long.
 */
public class WordLadder {
	
	public static boolean valid(String a, String b){
        int count=0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i))
                count++;
        }
        
        if(count==1)
            return true;
        return false;
    }
    
	//Since we have to find the shortest route, thus use BFS
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Integer> queue=new LinkedList<>();
		
        //if the endword doesnt exist, then return 0 
		if(!wordList.contains(endWord))
			return 0;
		//otherwise add the begin word to the list as it is not there
		wordList.add(0, beginWord);
		
		//for marking the visited nodes
		boolean[] visited=new boolean[wordList.size()];
		//for calculating the distance from the beginword 
		int[] distance=new int[wordList.size()];
		
		
		queue.add(0);
		
		
		while(!queue.isEmpty()) {
			//Get the top element index and compare it with all the words in the list
			int curr=queue.poll();
			
			for(int i=1;i<wordList.size();i++) {
				//if the word is not visited and it is valid(both the words differ by just 1 character) 
				if(visited[i]==false && valid(wordList.get(curr),wordList.get(i))) {
					
					//mark that index visited and update it's distance by adding 1 to it's parents distance
					//here curr is the parent and i is the child
					
					visited[i]=true;
					distance[i]=1+distance[curr];
					
					//if we already get the end word then just return the distance of the endword
					//+1 because we need to consider the begin word as well
					if(wordList.get(i).equals(endWord))
					{
						return distance[i]+1;
					}
					
					//if not found, then add that word to the queue and repeat the process untill 
					//we find the end word
					queue.add(i);
				}
			}
		}
		return 0;
    }
    
    public static void main(String[] args) {
    	
    	String[] arr={"hot","dot","dog","lot","log","kog"};
		
		List<String> words=new LinkedList<>();
		for(String i:arr)
			words.add(i);
		System.out.println(ladderLength("hit", "lot", words));
	}
}
