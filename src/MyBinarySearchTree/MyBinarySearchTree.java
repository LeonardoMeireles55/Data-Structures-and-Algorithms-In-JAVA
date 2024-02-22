package MyBinarySearchTree;


public class MyBinarySearchTree {

    static class NodeForTree {
        int value;
        NodeForTree left;
        NodeForTree right;
        NodeForTree parent;

        public NodeForTree(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "NodeForTree{" +
                    "value=" + value +
                    ", left=" + (left != null ? left.value : null) +
                    ", right=" + (right != null ? right.value : null) +
                    ", parent=" + (parent != null ? parent.value : null) +
                    '}';
        }
    }
    private NodeForTree root;

    public boolean isEmpty() {
        return this.root == null;
    }

    @Override
    public String toString() {
        return "MyBinarySearchTree{" +
                "root=" + root +
                '}';
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

    public NodeForTree search(int value) {
        NodeForTree auxNode = this.root;

        while (auxNode != null) {
            if(auxNode.value == value) {
                return auxNode;
            }
            if(value < auxNode.value) {
                auxNode = auxNode.left;
            }
            if(value > auxNode.value) {
                auxNode = auxNode.right;
            }
        }
        return null;
    }

    public int minValue() {
        NodeForTree node = this.root;
        while (node.left != null) {
            node = node.left;
        }
        return node.value;
    }

    public int maxValue() {
        NodeForTree node = this.root;
        while (node.right != null) {
            node = node.right;
        }
        return node.value;
    }

    public int successor(NodeForTree node) {
        if(node == null) return -1;
        if(node.right != null) {
            return this.minValue();
        }
        else {
            NodeForTree auxNode = node.parent;

            while (auxNode != null && auxNode.value < node.value) {
                auxNode = auxNode.parent;
            }
            return auxNode.value;
        }
    }

    public int predecessor(NodeForTree node) {
        if(node == null) return -1;
        if(node.left != null) {
            return this.minValue();
        }
        else {
            NodeForTree auxNode = node.parent;

            while (auxNode != null && auxNode.value > node.value) {
                auxNode = auxNode.parent;
            }
            return auxNode.value;
        }
    }

    public static void main(String[] args) {
        MyBinarySearchTree myBinarySearchTree = new MyBinarySearchTree();

        myBinarySearchTree.add(12);
        myBinarySearchTree.add(7);
        myBinarySearchTree.add(3);
        myBinarySearchTree.add(14);
        myBinarySearchTree.add(13);
        myBinarySearchTree.add(15);
        myBinarySearchTree.add(11);
        myBinarySearchTree.add(10);

        System.out.println(myBinarySearchTree.minValue());
        System.out.println(myBinarySearchTree.maxValue());
        System.out.println(myBinarySearchTree.root.left.right.left);
        System.out.println(myBinarySearchTree.predecessor(myBinarySearchTree.root.left.right.left));

    }
}




