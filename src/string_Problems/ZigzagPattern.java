package string_Problems;

import java.util.ArrayList;
import java.util.List;

/*
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
 * (you may want to display this pattern in a fixed font for better legibility)

		P.......A........H.......N
		..A..P....L....S....I...I....G
		....Y.........I........R
		And then read line by line: PAHNAPLSIIGYIR
 */
public class ZigzagPattern {
	
	public static String convert(String A, int B) {

        List<ArrayList<Character>> list=new ArrayList<>();
        
        //if no.of rows are 1, no zig zag pattern can be formed thus return string
        if(B==1)
        	return A;
        
        //we will be creating B no.of  array lists and will be storing accordingly
        while(B-->0)
            list.add(new ArrayList<>());
        
        int x=0; // for inserting value in the particular arraylist
        boolean cond=true; // to increase or decrease pointer
        for(int i=0;i<A.length();i++){

            char ch=A.charAt(i);
            
            //if the pointer reaches the end then we decrease the pointer until
            //the pointer reaches 0, again we increase and repeat the same steps
            if(x==0)
                cond=true;
            else if(x==list.size()-1)
                cond=false;

            list.get(x).add(ch);

            if(cond)
                x++;
            else
                x--;
        }
        
        //store the elements of each row in a string
        String res="";
        for(ArrayList i:list){
            for(Object j:i)
                res+=j;
        }
        return res;
    }
		
	
	public static void main(String[] args) {
		
		String str="kHAlbLzY8Dr4zR0eeLwvoRFg9r23Y3hEujEqdio0ctLh4jZ1izwLh70R7SAkFsXlZ8UlghCL95yezo5hBxQJ1Td6qFb3jpFrMj8pdvP6M6k7IaXkq21XhpmGNwl7tBe86eZasMW2BGhnqF6gPb1YjCTexgCurS";
		
		System.out.println(convert(str, 1));
	}

}
