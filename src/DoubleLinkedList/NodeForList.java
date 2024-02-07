package DoubleLinkedList;

public class NodeForList<T> {
    private T element;
    private NodeForList<T> next;
    private NodeForList<T> previous;

    public NodeForList(T element) {
        this.element = element;
        this.next = null;
        this.previous = null;
    }

    public NodeForList(T element, NodeForList<T> next, NodeForList<T> previous) {
        this.element = element;
        this.next = next;
        this.previous = previous;
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

    public NodeForList<T> getPrevious() {
        return previous;
    }

    public void setPrevious(NodeForList<T> previous) {
        this.previous = previous;
    }

    @Override
    public String toString() {
        return "NodeForList{" +
                "element=" + element +
                ", next=" + next +
                ", previous=" + previous +
                '}';
    }
}
