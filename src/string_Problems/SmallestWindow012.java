package string_Problems;

//Find the smallest window which contains 0,1 and 2
public class SmallestWindow012 {
	
	public static int smallWindow(String str) {
		//for calculating the smallest window
		int ans=999999;
		
		//three variables for getting the indexes of 0,1 and 2 respectively
		int l0=-1,l1=-1,l2=-1;
		
		for(int i=0;i<str.length();i++) {
			
			char ch=str.charAt(i);
			
			//if we find 0,1 or 2 we insert them to their variables
			if(ch=='0')
				l0=i;
			else if(ch=='1')
				l1=i;
			else
				l2=i;
			
			//once all the variables are filled, then we check for the window size
			//we find which has the max index and the min index, if we subtract them and add 1 we get the size
			//There will be many such combinations, thus we store it in ans and take the min of all
			if(l0!=-1 && l1!=-1 && l2!=-1)
			{
				int max=Math.max(l0, Math.max(l1, l2));
				int min=Math.min(l0, Math.min(l1, l2));
				
				ans=Math.min(max-min+1, ans);
			}
		}
		//if any of the numbers are not found then return -1
		if(l0==-1 || l1==-1 || l2==-1)
			return -1;
		return ans;
	}
	
	public static void main(String[] args) {
		
		System.out.println(smallWindow("12111"));
	}

}
