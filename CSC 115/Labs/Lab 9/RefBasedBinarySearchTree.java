import java.lang.Math;
/*
 * RefBasedBinarySearchTree.java
 *
 * A ref-based BinaryTree meant to store values of type Integer
 * 
 * sum, find, getMax
 */
public class RefBasedBinarySearchTree extends RefBasedBinaryTree {

    public void insert(Integer value){
        if (root==null) {
            root = new TreeNode(value);
        } else {
            insert(null, root, value);
		}
        
    }
    // not a balanced insert
    private void insert(TreeNode parent, TreeNode t, Integer value) {
        if (t==null) {
            if(value<=parent.getValue()) {
                parent.setLeft(new TreeNode(value));
			} else {
                parent.setRight(new TreeNode(value));
			}            
        }  else {
            if (value>t.getValue()) {
                insert(t, t.getRight(), value);
			} else {
                insert(t, t.getLeft(), value);
			}
        }
    }
    
    public boolean findHelp(TreeNode cur, int val) {
        if (cur == null) {
            return false;
        }
        if (cur.getValue() == val) {
            return true;
        }
        if (cur.getValue() > val) {
            return findHelp(cur.getLeft(), val);
        } else {
            return findHelp(cur.getRight(), val);
        }
    }
    
    public int gmHelp(TreeNode cur) {
        if (cur.getRight() == null) {
            return cur.getValue();
        }
        return gmHelp(cur.getRight());
    }
    public static void main(String[] args) {
        // use these trees to test the methods you will implement
        RefBasedBinarySearchTree emptyTree = new RefBasedBinarySearchTree();
        
        RefBasedBinarySearchTree tree1 = new RefBasedBinarySearchTree();
        for(int i=2; i<7; i++) {
            tree1.insert(i);
        }

        RefBasedBinarySearchTree tree2 = new RefBasedBinarySearchTree();
        for(int i=-4; i<2; i++) {
            tree2.insert(i);
        }

        RefBasedBinarySearchTree tree3 = new RefBasedBinarySearchTree();
        for(int i=3; i<81*81*81*81; i*=i) {
            tree3.insert(i);
        }
        
        RefBasedBinarySearchTree myTree = new RefBasedBinarySearchTree();
        myTree.insert(2);
        myTree.insert(1);
        myTree.insert(5);
        myTree.insert(7);
        myTree.insert(0);
        myTree.insert(4);
        myTree.insert(6);
        
        System.out.println("myTree tests");
        System.out.println("in");
        myTree.inOrder();
        System.out.println("pre");
        myTree.preOrder();
        System.out.println("post");
        myTree.postOrder();
        System.out.println("toString\n" + myTree);

        System.out.println("sum");
        System.out.println(myTree.sum());

        System.out.println("find");
        System.out.println(myTree.find(2));

        System.out.println("getMax - full");
        try {
            System.out.println(myTree.getMax());
        } catch (TreeEmptyException e) {
            System.out.println("Tree's just a wee sapling :(");
        }
        System.out.println("getMax - empty");
        try {
            System.out.println(emptyTree.getMax());
        } catch (TreeEmptyException e) {
            System.out.println("Tree's just a wee sapling :(");
        }

        System.out.println("\ntree1 tests");
        System.out.println("tree1 pre");
        tree1.preOrder();
        System.out.println("tree1 sum");
        System.out.println(tree1.sum());

        System.out.println("find - should be false");
        System.out.println(tree1.find(0));

        System.out.println("getMax");
        try {
            System.out.println(tree1.getMax());
        } catch (TreeEmptyException e) {
            System.out.println("Tree's just a wee sapling :(");
        }

        System.out.println("\ntree2 tests");
        System.out.println("tree2 pre");
        tree2.preOrder();
        System.out.println("tree2 sum");
        System.out.println(tree2.sum());

        System.out.println("find - should be true");
        System.out.println(tree2.find(-2));

        System.out.println("getMax");
        try {
            System.out.println(tree2.getMax());
        } catch (TreeEmptyException e) {
            System.out.println("Tree's just a wee sapling :(");
        }

        System.out.println("\ntree3 tests");
        System.out.println("tree3 pre");
        tree3.preOrder();
        System.out.println("tree3 sum");
        System.out.println(tree3.sum());

        System.out.println("find - should be false");
        System.out.println(tree3.find(0));

        System.out.println("getMax");
        try {
            System.out.println(tree3.getMax());
        } catch (TreeEmptyException e) {
            System.out.println("Tree's just a wee sapling :(");
        }
    }
}
