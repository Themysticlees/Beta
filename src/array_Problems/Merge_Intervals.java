package array_Problems;
import java.util.*;

public class Merge_Intervals {
	
	public static void merge(int[][] intervals)
	{
		//storing upper and lower limit of first interval
		int temp1=intervals[0][0];
		int temp2=intervals[0][1];
		
		List<List<Integer>> list = new ArrayList<>();
		
		int x=0;
		for(int i=0;i<intervals.length;i++)
		{
			//if upper limit is more than the lower limit of 
			//the next interval then it can be merged
			if(temp2>=intervals[i][0])
			{
				temp2=intervals[i][1];
				
				//if upper limit is bigger than the upper limit 
				// of next interval 
				if(temp1>=intervals[i][0])
					temp1=intervals[i][0];
			}
			
			//if they cannot be merged 
			else
			{
				list.add(new ArrayList<>());
				list.get(x).add(temp1);
				list.get(x).add(temp2);
				x++;
				
				temp1=intervals[i][0];
				temp2=intervals[i][1];
			}
			
			// if we reach the last interval, there's no point
			// of checking for more
			if(i==intervals.length-1)
			{
				list.add(new ArrayList<>());
				list.get(x).add(temp1);
				list.get(x).add(temp2);
				x++;
			}
		}
		
		System.out.println(list);
		
	}

	public static void main(String[] args) {
		
		//if not sorted first sort them
		Comparator<int[]> com=new Comparator<int[]>() {
			
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				
				return o1[0]-o2[0];
			}
		};
		
		int[][] arr= {{1,3},{2,6},{8,10},{15,18}};
		//int[][] arr2= {{1,4},{0,5}};
		
		Arrays.sort(arr,com);
		merge(arr);
		
	}

}
