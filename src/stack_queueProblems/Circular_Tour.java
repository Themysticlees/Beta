package stack_queueProblems;

/*
     Suppose there is a circle. There are N petrol pumps on that circle. You will be given two sets of data.
	1. The amount of petrol that every petrol pump has.
	2. Distance from that petrol pump to the next petrol pump.
	Find a starting point where the truck can start to get through the complete circle without 
	exhausting its petrol in between.
	Note :  Assume for 1 litre petrol, the truck can go 1 unit of distance.
 */
public class Circular_Tour {
	
	//We can use a queue to store the indexes of the petrol pumps
	//we need to calculate the amount of petrol left after moving, if that no. is -ve then then we'll empty the queue
	//and start from the next index
	int tour(int petrol[], int distance[])
    {
	// Your code here	
	       
	   //Queue<Integer> queue=new LinkedList<>();
	   //In Case of queue, you can just maintain a pointer, since we'll just store the starting index
		//front will -1 indicating the queue is empty
	   int front=-1;
	   int res=0;
	   for(int i=0;i<petrol.length;i++){
	       //calculate amount of petrol left
		   res+=petrol[i]-distance[i];
	       
		   //if the amount is -ve, empty the queue and initialize res with 0
	       if(res<0){
	           res=0;
	           front=-1;
	       }
	       //if queue is empty, then store the starting index
	       else if(front==-1)
	       {
	           front=i;
	       }
	   }
	   
	   //if we couldn't get a starting point of the journey, then return -1
	   if(front==-1)
	    return -1;
	    
	   //we may not be starting from the 0th index, thus we need to check the validity from index 0 to the index
	   //before front
	    for(int i=0;i<front;i++){
	        res+=petrol[i]-distance[i];
	        //if anywhere the res becomes -ve then return -1
	        if(res<0)
	            return -1;
	    }
	    
	    //if everything goes nicely, return front which has the starting index of the journey
	    return front;
    }

}
