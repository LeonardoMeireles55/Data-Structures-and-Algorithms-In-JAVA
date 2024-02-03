package MyQueue;

public class NodeForQueue<T> {
    private T element;
    private NodeForQueue<T> next;

    public NodeForQueue(T element) {
        this.element = element;
        this.next = null;
    }

    public NodeForQueue(T element, NodeForQueue<T> next) {
        this.element = element;
        this.next = next;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public NodeForQueue<T> getNext() {
        return next;
    }

    public void setNext(NodeForQueue<T> next) {
        this.next = next;
    }


    @Override
    public String toString() {
        return "Node{" +
                "element=" + element +
                ", next=" + next +
                '}';
    }
}
