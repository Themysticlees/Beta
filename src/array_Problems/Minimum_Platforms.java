package array_Problems;

import java.util.Arrays;

public class Minimum_Platforms {
	
	static int findPlatform(int arr[], int dep[], int n)
    {
		//sort the arrays because we dont need to note which train is leaving
		//we are just interested about if a train is leaving or not. Thus sort the array
		Arrays.sort(arr);
		Arrays.sort(dep);
		
		//i is initialized by 1 because we are comparing the arrival of 2nd train with the departure
		//of 1st train
		int i=1,j=0;
		//atleast 1 platform will be needed
		//curr denotes no.of platforms occupied at a moment
		//max denotes max no.of platforms needed.
		int curr=1,max=1;
		
		while(i<n && j<n){
			
			//if departure time of the earlier train is less i.e the train has left
			//thus decrease curr and increase j as we will comparing the departure time 
			//of the next train
			if(arr[i]>dep[j]) {
				j++;
				curr--;
			}
			//else new platform is required for the incoming train, increase curr and i
			else
			{
				curr++;
				i++;
			}
			
			//store the platforms needed at the moment in max
			max=Math.max(max, curr);
		}
		return max;
		
    }
	
	public static void main(String[] args) {
		
		int arr[] = {900, 940, 950, 1100, 1500, 1800};
		int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
		
		System.out.println(findPlatform(arr, dep, arr.length));
		
	}

}
