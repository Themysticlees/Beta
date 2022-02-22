package tree_Problems;

public class CheckTreeSame {
	
	public boolean isSameTree(Node p, Node q) {
        
		//if either of the nodes are null
		//then check if both are null the return true
		//otherwise return false because they will be different
        if(p==null || q==null)
        {
            if(p==null && q==null)
                return true;
            else
                return false;
        }
        
        //now check if the value of both the nodes are same and similarly check for the 
        //left and right subtee for both the trees. If all the functions return true then return true
        //we are using and operator, thus automatically if one return false, then it will return false.
        return (p.data==q.data) && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        
    }

}
