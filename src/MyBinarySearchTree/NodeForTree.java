package MyBinarySearchTree;

public class NodeForTree {
    int value;
    NodeForTree left;
    NodeForTree right;
    NodeForTree parent;

    public NodeForTree(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.parent = null;
    }
}
