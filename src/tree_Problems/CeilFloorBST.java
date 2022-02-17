package tree_Problems;


public class CeilFloorBST {
	
	//we need a find if the key is present in the BST
	//if not present return a number which is just bigger than the key
	public static int findCeil(Node root, int key) {
		
		//base cond
		//if root becomes null
		if(root==null)
			return 999;
		int val=root.data;
		
		//if the key is found, then return it
		if(val==key)
			return val;
		
		//if key is bigger than the current root value, then move to it's right
		//as we may find a number which is equal or bigger than key
		if(val<key)
			return findCeil(root.right, key);
		
		//if the key is less than root val, then keep that val and move to it's left
		//to find a value which is just bigger than our key
		//we keep the current root value to compare with the other values
		//out of all the values, the min is taken and that is how we get our result.
		//if we reach null, the fn will return 999, thus it will never be the lesser value
		return Math.min(val, findCeil(root.left, key));
		
	}
	
	//similar to ceil
	public static int findFloor(Node root, int key) {
		
		if(root==null)
			return -1;
		int val=root.data;
		
		if(val==key)
			return val;
		
		//if key is smaller than current root value, then move to it's left
		//because we need to find a smaller or equal value to our key
		if(val>key)
			return findFloor(root.left, key);
		
		//if the key is bigger than the current node, then move it to it's right, because we need to find a
		//value which is nearer to the key but less than it
		return Math.max(val, findFloor(root.right, key));
	}

}
