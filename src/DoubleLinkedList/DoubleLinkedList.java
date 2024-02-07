package DoubleLinkedList;

public class DoubleLinkedList<T> {
    private NodeForList<T> initialNodeForList;
    private NodeForList<T> endNodeForList;

    private int listSize = 0;

    public DoubleLinkedList() {
        initialNodeForList = endNodeForList = null;
    }

    public void add(T element) {
        NodeForList<T> newNode = new NodeForList<>(element);
        if (listSize == 0) {
            initialNodeForList = newNode;
        } else {
            endNodeForList.setNext(newNode);
            newNode.setPrevious(endNodeForList);
        }
        endNodeForList = newNode;
        listSize++;
    }

    private static class NodeForList<T> {
        T data;
        NodeForList<T> next;
        NodeForList<T> previous;

        public NodeForList(T data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }

        public void setNext(NodeForList<T> next) {
            this.next = next;
        }

        public void setPrevious(NodeForList<T> previous) {
            this.previous = previous;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DoubleLinkedList{size=").append(listSize).append(", elements=[");
        NodeForList<T> currentNode = initialNodeForList;
        while (currentNode != null) {
            sb.append(currentNode.data);
            currentNode = currentNode.next;
            if (currentNode != null) {
                sb.append(", ");
            }
        }
        sb.append("]}");
        return sb.toString();
    }

    public static void main(String[] args) {
        DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<Integer>();
        doubleLinkedList.add(1);
        doubleLinkedList.add(2);
        doubleLinkedList.add(3);
        doubleLinkedList.add(4);
        doubleLinkedList.add(5);

        System.out.println(doubleLinkedList.initialNodeForList.next.previous.data);
    }
}
