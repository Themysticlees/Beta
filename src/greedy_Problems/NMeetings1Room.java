package greedy_Problems;
import java.util.*;
/*
 * There is one meeting room in a firm. There are N meetings in the form of (start[i], end[i]) 
 * where start[i] is start time of meeting i and end[i] is finish time of meeting i.
	What is the maximum number of meetings that can be accommodated in the meeting room when 
	only one meeting can be held in the meeting room at a particular time?
	Note: Start time of one chosen meeting can't be equal to the end time of the other chosen meeting.
	
	Input:
	N = 6
	start[] = {1,3,0,5,8,5}
	end[] =  {2,4,6,7,9,9}
	Output: 
	4
	Explanation:
	Maximum four meetings can be held with
	given start and end timings.
	The meetings are - (1, 2),(3, 4), (5,7) and (8,9)
 */
public class NMeetings1Room {
	
	//The Greedy approach should be:-
	//Since there is only one room, we need to sort the meetings according to their ending time
	//So that max meetings can be scheduled
	
	public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        int[][] time = new int[n][2];
		
		for(int i=0;i<n;i++) {
			time[i][0]=start[i];
			time[i][1]=end[i];
		}
		
		//To sort the meetings according to their end time
		Comparator<int[]> com=new Comparator<int[]>() {
			
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				
				return o1[1]-o2[1];
			}
		};
		
		Arrays.sort(time,com);
		//i denotes the starting times and j denotes the ending time of the current meeting
        int i=1,j=0;
        
        int count=1;
        while(i<n){
            
        	//checking if the starting time of the next meeting is more than the 
        	//ending time of the current meeting
            if(time[i][0]>time[j][1]){
            	//if yes, increase count and initialize j with i as we'll be comparing the current
            	//meeting end time with others
            	//increase i to move to the next meeting
                count++;
                j=i;
                i++;
            }
            //if starting is less, just increase i (starting time of next meeting)
            else
                i++;
        }
        return count;
    }

}
