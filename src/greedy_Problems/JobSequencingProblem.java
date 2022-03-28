package greedy_Problems;
import java.util.*;

class Job{
	int id,profit,deadline;
	Job(int id,int profit,int deadline){
		this.id=id;
		this.profit=profit;
		this.deadline=deadline;
	}
}
/*
 * Given a set of N jobs where each jobi has a deadline and profit associated with it.
	Each job takes 1 unit of time to complete and only one job can be scheduled at a time.
	 We earn the profit associated with job if and only if the job is completed by its deadline.
	
	Find the number of jobs done and the maximum profit.
	
	Note: Jobs will be given in the form (Jobid, Deadline, Profit) associated with that Job.
 */
public class JobSequencingProblem {
	
	//We will sort the jobs according to their profits
	//Now we'll perform each job in their deadline
	//Suppose  job1 has a deadline of 2 and job2 has deadline of 1
	//Thus we'll perform job2 in 1st day and job2 in 2nd day
	static int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        //Comparator for sorting
        Comparator<Job> com=new Comparator<Job>() {
			
			@Override
			public int compare(Job o1, Job o2) {
				// TODO Auto-generated method stub
				
				//if(o1.deadline==o2.deadline)
				    return o2.profit-o1.profit;
				
				//return o1.deadline-o2.deadline; 
			}
		};
		
		Arrays.sort(arr,com);
		//To keep a track of the day used
		Set<Integer> set = new HashSet<>();
		
		int max=0,job=0;
		for(int i=0;i<n;i++){
		    
		    int temp=arr[i].deadline;
		    //we'll check if we have done any other job in the temp day
		    //if we have we'll check for a previous day
		    //For example job1 and job2 may have same deadline i.e 2
		    //Thus we'll perform any job on day 1 and the other on day 2
		    //This loop will search for a day which is possible
		    while(temp>=1 && set.contains(temp)){
		        temp--;
		    }
		    
		    //if no day was found, temp would have become less than 1
		    //otherwise the day which is possible will be added in the set and we'll add the profit 
		    //and increase our job count
		    if(temp>=1 && !set.contains(temp)){
		        set.add(temp);
		        max+=arr[i].profit;
		        job++;
		    }
		}
		
		int[] res=new int[2];
		res[0]=job;
		res[1]=max;
		
		return res;
    }
	
	public static void main(String[] args) {
		
		Job o1=new Job(1, 2, 100);
		Job o2=new Job(2, 1, 19);
		Job o3=new Job(3, 2, 27);
		Job o4=new Job(4, 1, 25);
		Job o5=new Job(5, 1, 15);
		
		Job[] arr= {o1,o2,o3,o4,o5};
		
		JobScheduling(arr,arr.length);
		
	}

}
