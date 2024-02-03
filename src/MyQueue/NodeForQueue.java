package MyQueue;

public class NodeForQueue<T> {
    private T element;
    private NodeForQueue<T> next;

    @Override
    public String toString() {
        return "Node{" +
                "element=" + element +
                ", next=" + next +
                '}';
    }
}
