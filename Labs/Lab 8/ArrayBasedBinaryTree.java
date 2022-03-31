/*
 * ArrayBasedBinaryTree.java
 *
 * An array-based BinaryTree meant to store values of type Integer
 */
public class ArrayBasedBinaryTree implements BinaryTree {
    private static final int CAPACITY = 5;
    protected Integer[] data;
    protected int root;
    protected int size;
    
	public ArrayBasedBinaryTree() {
		// TODO...
		// allocate space for data array.
		// What index are you choosing the root to be?
		// initialize your size as the number of elements in the empty tree
		data = new Integer[CAPACITY];
		root = 1;
		size = 0;
	}

	/*
	 * Purpose: inserts the given value into data at next available
	 *  position in a level-order traversal
	 *  The tree remains complete after insertion.
	 * Parameters: Integer value - value to insert
	 * Returns: nothing
	 */
	public void insert(Integer value) {
		// TODO...
		// NOTE: The underlying data structure is an array,
		//  but we are just USING the array to store the data.
		//  The way we traverse the data will expose its binary tree structure
		if (size+1 == data.length) {
			expandAndCopy();
		}
		data[size+1] = value;
		size++;
	}

	protected void expandAndCopy() {
		Integer[] newData = new Integer[data.length*2];
		for(int i=0; i<data.length; i++) {
			newData[i] = data[i];
		}
		data = newData;
	}

	/*
	 * Purpose: calculates and returns the index of t's left child
	 * Parameters: int t - index of current element in this ArrayBasedBinaryTree
	 * Returns: int - index of left child
	 */
	protected int getLeft(int t) {
		return t*2;
	}

	/*
	 * Purpose: calculates and returns the index of t's right child
	 * Parameters: int t - index of current element in this ArrayBasedBinaryTree
	 * Returns: int - index of right child
	 */
	protected int getRight(int t) {
		return t*2+1;
	}


	public void inOrder(){
		if (size < 1) {
			return;
		}
		inOrderHelp(1);

	}

	public void inOrderHelp(int ind){
		if (ind > size) {
			return;
		}
		inOrderHelp(getLeft(ind));
		System.out.println(data[ind]);
		inOrderHelp(getRight(ind));
	}


	public void preOrder(){
		if (size < 1) {
			return;
		}
		preOrderHelp(1);
	}

	public void preOrderHelp(int ind){
		if (ind > size) {
			return;
		}
		System.out.println(data[ind]);
		preOrderHelp(getLeft(ind));
		preOrderHelp(getRight(ind));
	}

	public void postOrder(){
		if (size < 1) {
			return;
		}
		postOrderHelp(1);
	}

	public void postOrderHelp(int ind){
		if (ind > size) {
			return;
		}
		postOrderHelp(getLeft(ind));
		postOrderHelp(getRight(ind));
		System.out.println(data[ind]);
	}

	public int height() {
		return heightHelp(root);
	}

	/*
	 * Purpose: computes and returns the height of a 
	 *          binary tree rooted at index t 
	 * Parameters: TreeNode t - the BinaryTree
	 * Returns: int - the height
	 * NOTE: a BinaryTree with no nodes is height -1
	 *       a BinaryTree with just a root is height 0
	 *
	 *       the height of a node in a tree is equal to 
	 *       1 + the height of its largest subtree
	 */
	
	protected int heightHelp(int ind) {
		if (ind > size) {
			return 0;
		}
		return 1 + Math.max(heightHelp(getLeft(ind)), heightHelp(getRight(ind)));
	}

	/*
	 * Purpose: returns a String reprensentation of a in-order traversal
	 *     of this ArrayBasedBinaryTree
	 * Parameters: none
	 * Returns: String - the representation
	 */
	// written for you - do not change
	// NOTICE: we use the helper methods to get the index of the left/right
	//   children of the current position in the tree.
	// This method will not work until you have completed those methods correctly.
	public String toString() {
		return toString(root);
	}

	private String toString(int t) {
        if (t >= size) {
            return "";
        } 
        String s = "";
        s += toString(getLeft(t));
        s += data[t] + " ";
        s += toString(getRight(t));

        return s;
	}

	public static void main(String[] args) {
		
		ArrayBasedBinaryTree myTree = new ArrayBasedBinaryTree();
		for(int i=2; i<8; i++) {
			myTree.insert(i);
		}
		System.out.println("in");
		myTree.inOrder();
		System.out.println("pre");
		myTree.preOrder();
		System.out.println("post");
		myTree.postOrder();
		System.out.println("toString\n" + myTree);
	}
    
}
