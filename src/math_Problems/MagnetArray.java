package math_Problems;

/* Problem link : https://practice.geeksforgeeks.org/problems/magnet-array-problem3743/1#
 * Given N Magnets which are placed linearly, with each magnet to be considered as of point object.
 * Each magnet suffers force from its left sided magnets such that they repel it to the right 
 * and vice versa. All forces are repulsive. The force being equal to the 
 * distance (1/d , d being the distance). Now given the positions of the magnets, 
 * the task to find all the points along the linear line where net force is ZERO.
 * And that forces are inversely proportional to the distance, thus there lies an 
 * equilibrium point between every two magnetic points. Thus there will be 
 * total of N-1 equllibrium points. You have to find those N-1 points.
 * Note: Array M[] is sorted and distance have to be calculated with precision of 2 decimal places. 
 * 
 *  So I will explain the equilibrium concept for the second example:
	[0, 10, 20, 30]
	    ^
	We will find the equilibrium for 1st place i. e. between 0 and 10:
	
	low = 0, high = 10, Mid = 5;
	So calculate the left forces and right forces at point 5.
	left forces = 1/(5 - 0) => (0.25)
	Right forces = 1/(10-5) + 1/(20 - 5) + 1/(20-5) => (0.306)
	Clearly, left forces < right forces:
	
	So, we move left
	
	
	Now, low = 0, high = 5, Mid = 2.5;
	So calculate the left forces and right forces at point 2.5.
	left forces = 1/(2.5 - 0) => (0.4)
	Right forces = 1/(10-2.5) + 1/(20 - 2.5) + 1/(20-2.5) => (0.22)
	Clearly, left forces > right forces:
	
	So, we Move Right
	
	Now, low = 2.5, high = 5, Mid = 3.75;
	So calculate the left forces and right forces at point 3.75.
	left forces = 1/(3.75 - 0) => (0.26)
	Right forces = 1/(10-3.75) + 1/(20 - 3.75) + 1/(20-3.75) => (0.25)
	Clearly, left forces > right forces:
	
	So, we Move Right
	 Follow this till we get 
	Right forces == Left forces.
	and calculate the same for all the equilibrium points.
 */
public class MagnetArray {
	
	public void nullPoints(int n, double arr[], double getAnswer[])
    {
        // Your code goes here 
        
        for(int i=0;i<n-1;i++){
        	//calculating the equilibrium point
            double low=arr[i],high=arr[i+1];
   
            while(low<=high){
                double mid=(low+high)/2;
                
                //left forces
                double left=0.0;
                for(int f=i;f>=0;f--){
                    left+=1/(mid-arr[f]);
                }
                
                //right forces
                double right=0.0;
                for(int f=i+1;f<n;f++){
                    right+=1/(arr[f]-mid);
                }
                
                //if the forces are equal
                if(Math.abs(left-right)<0.000001){
                    getAnswer[i]=mid;
                    break;
                }
                
                //if left force is more, then increase left pointer since force is inversely prop to distance
                //thus if we increase distance force reduces
                else if(left>right){
                    low=mid;
                }
                else{
                    high=mid;
                }
            }
        }
        
    }

}
