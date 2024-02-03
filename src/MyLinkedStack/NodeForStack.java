package MyLinkedStack;

public class NodeForStack<T> {
    private T element;
    private NodeForStack<T> next;

    public NodeForStack(T element) {
        this.element = element;
        this.next = null;
    }

    public NodeForStack(T element, NodeForStack<T> next) {
        this.element = element;
        this.next = next;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public NodeForStack<T> getNext() {
        return next;
    }

    public void setNext(NodeForStack<T> next) {
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
