public class ArrayBasedBinarySearchTree extends ArrayBasedBinaryTree{
    public void insert(Integer value) {
        if (size == 0) {
            data[root] = value;
            size++;
            return;
        }
        insertHelp(value, 0);
    }

    public boolean isLeafLeft(Integer pos) {
        if (data[pos*2+1] == null) {
            return true;
        }
        return false;
    }

    public boolean isLeafRight(Integer pos) {
        if (data[pos*2+2] == null) {
            return true;
        }
        return false;
    }

    public void insertHelp(Integer value, Integer pos) {
        if (data[pos] >= value) {
            if (isLeafLeft(pos)) {
                data[pos*2+1] = value;
                size++;
                return;
            }
            insertHelp(value, (pos*2+1));
        } else {
            if (isLeafRight(pos)) {
                data[pos*2+2] = value;
                size++;
                return;
            }
            insertHelp(value, (pos*2+2));
        }


    }
    public static void main(String[] args) {
        ArrayBasedBinarySearchTree emptyTree = new ArrayBasedBinarySearchTree();
        
        ArrayBasedBinarySearchTree myTree = new ArrayBasedBinarySearchTree();
        myTree.insert(2);
        myTree.insert(1);
        myTree.insert(5);
        myTree.insert(7);
        myTree.insert(0);
        myTree.insert(4);
        myTree.insert(6);
        
        System.out.println("in");
        myTree.inOrder();
        System.out.println("pre");
        myTree.preOrder();
        System.out.println("post");
        myTree.postOrder();
        
        System.out.println("toString\n" + myTree);
    }

}
