package bst_Problems;

public class DeleteNodeBST {

//Delete a node from a BST
//There are two steps
//	1. find the node
// 	2. delete the node
//  3. assign the left child parent node to the left child of key node
//	4. find the largest node from the left branch of key node 
//	5. assign the right child of the largest node to the right child of the key node

public Node deleteNode(Node root, int key) {
		
        if (root == null) {
            return null;
        }
        
        //if we have to delete the root node
        if (root.data == key) {
        	//helper func will connect the nodes and return the node which 
        	//will link to left of the parent node
        	
        	//since we have to delete the root, thus we return the resulting node directly as 
        	//there is no parent node
            return helper(root);
        }
        //for reference purpose
        Node dummy = root;
        
        //find the node if it is present
        while (root != null) {
            if (root.data > key) {
            	//if the node is found as the left child, then call the helper func
            	//the helper func will return the resultant node after deleteing and connecting
            	//after returning, connect to parent node as it's left child
                if (root.left != null && root.left.data == key) {
                    root.left = helper(root.left);
                    break;
                } else {
                	//if node not found but less than current node then we move to the left
                    root = root.left;
                }
            } else {
            	//similarly do for the right
                if (root.right != null && root.right.data == key) {
                    root.right = helper(root.right);
                    break;
                } else {
                    root = root.right;
                }
            }
        }
        //return the root node
        return dummy;
    }
    public Node helper(Node root) {
    	//we have to delete the root node
    	//if the left child is null simply return the right child as there is no connecting
    	//and automatically the root node will be lost as we are returning the right child
    	
            if (root.left == null) {
                return root.right;
            } else if (root.right == null){
            	//do the same if right child is null
                return root.left;
            } else {
            	//we keep a reference o the right sub tree
                Node rightChild = root.right;
                //then from the left subtree, find the largest node
                //findLastRight will search for that
                //then assign the right child of the lastRight node to the reference of the 
                //rightChild of root node
                Node lastRight = findLastRight(root.left);
                lastRight.right = rightChild;
                //and then return the left child of the root
                //as all the nodes have been connected and thus we are ready to delete it
                return root.left;
            }
    }
    public Node findLastRight(Node root) {
    	//since right child is bigger than root node
    	//thus we move to the right child until it's right child is null
    	//once we reach that, we return the root
        if (root.right == null) {
            return root;
        }
        return findLastRight(root.right);
    }

}
