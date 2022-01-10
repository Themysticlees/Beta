package Testing;
import java.util.*;
import java.util.regex.Pattern;

public class Main {
	
	public static String convert(String A, int B) {

        List<ArrayList<Character>> list=new ArrayList<>();
        
        if(B==1)
        	return A;
        
        while(B-->0)
            list.add(new ArrayList<>());
        
        int x=0;
        boolean cond=true;
        for(int i=0;i<A.length();i++){

            char ch=A.charAt(i);

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


