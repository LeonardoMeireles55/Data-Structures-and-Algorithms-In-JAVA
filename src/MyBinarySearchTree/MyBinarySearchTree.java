package MyBinarySearchTree;

public class MyBinarySearchTree {
    private NodeForTree root;

    public boolean isEmpty() {
        return root == null;
    }

    public void add(int element) {
        if (isEmpty()) {
            this.root = new NodeForTree(element);
        } else {
            NodeForTree auxNode = this.root;
            while (auxNode != null) {
                if (element < auxNode.value) {
                    if (auxNode.left == null) {
                        NodeForTree newNode = new NodeForTree(element);
                        auxNode.left = newNode;
                        newNode.parent = auxNode;
                        return;
                    }
                    auxNode = auxNode.left;
                } else {
                    if (auxNode.right == null) {
                        NodeForTree newNode = new NodeForTree(element);
                        auxNode.right = newNode;
                        newNode.parent = auxNode;
                        return;
                    }
                    auxNode = auxNode.right;
                }
            }
        }
    }
}




