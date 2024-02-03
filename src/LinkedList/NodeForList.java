package LinkedList;

public class NodeForList<T> {
    private T element;
    private NodeForList<T> next;

    public NodeForList(T element) {
        this.element = element;
        this.next = null;
    }

    public NodeForList(T element, NodeForList<T> next) {
        this.element = element;
        this.next = next;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public NodeForList<T> getNext() {
        return next;
    }

    public void setNext(NodeForList<T> next) {
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
