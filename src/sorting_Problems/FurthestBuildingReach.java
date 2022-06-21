package sorting_Problems;
import java.util.*;
/*
 * You are given an integer array heights representing the heights of buildings, some bricks, and some ladders.
 * You start your journey from building 0 and move to the next building by possibly using bricks or ladders.
 * While moving from building i to building i+1 (0-indexed),
 * If the current building's height is greater than or equal to the next building's height, 
 * you do not need a ladder or bricks.
 * If the current building's height is less than the next building's height, 
 * you can either use one ladder or (h[i+1] - h[i]) bricks.
 * Return the furthest building index (0-indexed) you can reach if you use the 
 * given ladders and bricks optimally.
 * 
 *  Input: heights = [4,2,7,6,9,14,12], bricks = 5, ladders = 1
	Output: 4
	Explanation: Starting at building 0, you can follow these steps:
	- Go to building 1 without using ladders nor bricks since 4 >= 2.
	- Go to building 2 using 5 bricks. You must use either bricks or ladders because 2 < 7.
	- Go to building 3 without using ladders nor bricks since 7 >= 6.
	- Go to building 4 using your only ladder. You must use either bricks or ladders because 6 < 9.
	It is impossible to go beyond building 4 because you do not have any more bricks or ladders.
 */
public class FurthestBuildingReach {
	//Use a priority queue to store all the jumps made to reach from 1 building to the other
	//The idea is to use a ladder for bigger jumps and bricks for smaller
	//Start the jumps by using bricks, store the jumps in a max heap
	//Now as soon as the no.of bricks become negative, then remove the largest jump from the pq 
	//and replace it with a ladder, add that jump to the no.of bricks
	public int furthestBuilding(int[] heights, int bricks, int ladders) {
        
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0;i<heights.length-1;i++){
            //if the height of the next building is less, then no need to jump
            if(heights[i+1]<=heights[i])
                continue;
            
            //calculate the jump and store it in pq
            int jump=heights[i+1]-heights[i];
            pq.add(jump);
            
            //use the bricks for the jump
            bricks-=jump;
            
            //if bricks become negative then check
            //whether we have ladders, if not then we cannot make a jump so the farthest building
            //reached is i
            
            if(bricks<0){
                if(ladders<=0)
                    return i;
                
                //if we have ladders, simply remove the largest jump and swap it with a ladder
                bricks+=pq.remove();
                
                ladders--;
            }
        }
        
        //if we reach to the last building, the loop will end , thus print the array size-1 (since it is 
        //0 indexed)
        return heights.length-1;
    }

}