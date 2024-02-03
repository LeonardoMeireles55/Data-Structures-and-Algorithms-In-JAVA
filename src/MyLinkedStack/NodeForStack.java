package MyLinkedStack;

public class NodeForStack<T> {
    private T element;
    private NodeForStack<T> next;


    @Override
    public String toString() {
        return "Node{" +
                "element=" + element +
                ", next=" + next +
                '}';
    }
}
