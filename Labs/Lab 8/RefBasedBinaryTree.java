import java.lang.Math;
/*
 * RefBasedBinaryTree.java
 *
 * A ref-based BinaryTree meant to store values of type Integer
 */
public class RefBasedBinaryTree implements BinaryTree {
	protected TreeNode root;

	public RefBasedBinaryTree() {
		root = null;
	}

	public void insert(Integer value){
		insert(null, root, value);
	}

	/*
	 * Purpose: recursively determines the shortest path (root to leaf)
	 *      inserts a new TreeNode with given value at that leaf
	 * Parameters: TreeNode parent - the parent to t
	 *             TreeNode t - the current TreeNode in recursive traversal
	 *             Integer value - the value to be inserted
	 * Returns: nothing
	 */
	private void insert(TreeNode parent, TreeNode t, Integer value) {
		if (t == null) {
			if (parent == null) {
				root = new TreeNode(value);
			} else if (parent.getLeft()==null) {
				parent.setLeft(new TreeNode(value));
			} else {
				parent.setRight(new TreeNode(value));
			}
		} else {
			int htLeft = height(t.getLeft());
			int htRight = height(t.getRight());
			if (htLeft <= htRight) {
				insert(t, t.getLeft(), value);
			} else {
				insert(t, t.getRight(), value);
			}				
		}
	}
	
	public int height() {
		return height(root);
	}
	/*
	 * Purpose: computes and returns the height of a 
	 *          binary tree rooted a t 
	 * Parameters: TreeNode t - the BinaryTree
	 * Returns: int - the height
	 * NOTE: a BinaryTree with no node is height 0
	 */
	public int height(TreeNode t) {
		if (root == null) {
			return 0;
		}
		return heightHelp(t) - 1;
	}
	protected int heightHelp(TreeNode t) {
		if (t == null) {
			return 0;
		}
		return 1 + Math.max(heightHelp(t.getLeft()), heightHelp(t.getRight()));
	}


	public void inOrder(){
		inOrderHelp(root);
	}

	public void inOrderHelp(TreeNode cur) {
		if (cur == null) {
			return;
		}
		inOrderHelp(cur.getLeft());
		System.out.println(cur.data);
		inOrderHelp(cur.getRight());
	}

	public void preOrder(){
		preOrderHelp(root);
	}

	public void preOrderHelp(TreeNode cur) {
		if (cur == null) {
			return;
		}
		System.out.println(cur.data);
		preOrderHelp(cur.getLeft());
		preOrderHelp(cur.getRight());
	}

	public void postOrder(){
		if (root == null) {
			return;
		}
		postOrderHelp(root);
	}

	public void postOrderHelp(TreeNode cur) {
		if (cur == null) {
			return;
		}
		postOrderHelp(cur.getLeft());
		postOrderHelp(cur.getRight());
		System.out.println(cur.data);
	}
	/*
	 * Purpose: returns a String reprensentation of this Shape
	 * Parameters: none
	 * Returns: String - the representation
	 */
	public String toString() {
		return toString(root);
	}

	private String toString(TreeNode t) {
		if(t == null) {
			return "";
		}
		String s = "";		
		s += toString(t.getLeft());
		s += t.getValue() + " ";
		s += toString(t.getRight());		
		return s;
	}

	// provided for testing of RefBasedBinaryTree class
	public static void main(String[] args) {
		
		RefBasedBinaryTree myTree = new RefBasedBinaryTree();
		for(int i=2; i<=8; i++) {
			myTree.insert(i);
		}
		System.out.println("in:");
		myTree.inOrder();
		System.out.println();
		System.out.println("pre:");
		myTree.preOrder();
		System.out.println();
		System.out.println("post:");
		myTree.postOrder();
		System.out.println();
		
		System.out.println("toString\n" + myTree);
	}
    
}
