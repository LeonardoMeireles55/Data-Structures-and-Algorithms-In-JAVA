package DoubleLinkedList;

public class DoubleLinkedList<T> {
    private NodeForList<T> initialNodeForList;
    private NodeForList<T> endNodeForList;
    private int listSize = 0;

    public DoubleLinkedList() {
        initialNodeForList = endNodeForList = null;
    }

    private static class NodeForList<T> {
        T value;
        NodeForList<T> next;
        NodeForList<T> previous;

        public NodeForList(T value) {
            this.value = value;
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

    public NodeForList<T> searchByPosition(int position) {
        if (!(position >= 0 && position < listSize)) {
            throw new IllegalArgumentException("Position not exists");
        }

        NodeForList<T> currentNode;

        if (position <= (listSize / 2)) {
            currentNode = initialNodeForList;
            int positionWhile = 0;

            while (positionWhile < position) {
                positionWhile++;
                currentNode = currentNode.next;
            }
        } else {
            currentNode = endNodeForList;
            int positionWhile = listSize - 1;

            while (positionWhile > position) {
                positionWhile--;
                currentNode = currentNode.previous;
            }
        }

        return currentNode;
    }

    public T search(int position) {
        return this.searchByPosition(position).value;
    }

    public void addAtPosition(T element, int position) {
        if (position < 0 || position > listSize) {
            throw new IllegalArgumentException("Invalid position");
        }

        NodeForList<T> newNode = new NodeForList<>(element);

        if (position == 0) {
            newNode.setNext(initialNodeForList);
            if (initialNodeForList != null) {
                initialNodeForList.setPrevious(newNode);
            }
            initialNodeForList = newNode;
        } else if (position == listSize-1) {
            endNodeForList.setNext(newNode);
            newNode.setPrevious(endNodeForList);
            endNodeForList = newNode;
        }
        else {
            NodeForList<T> current = initialNodeForList;
            for (int i = 0; i < position; i++) {
                current = current.next;
            }

            newNode.setNext(current.next);
            newNode.setPrevious(current);
            current.next.setPrevious(newNode);
            current.setNext(newNode);
        }
        listSize++;
    }

    public void removeLast() {
        if(this.listSize == 0) {
            throw new IllegalArgumentException("list is empty");
        }
        endNodeForList.value = null;
        endNodeForList.previous = null;
        endNodeForList.next = null;
        listSize--;
    }

    public void removeFirst() {
        if(listSize == 0) {
            throw new IllegalArgumentException("list is empty");
        }
        initialNodeForList = initialNodeForList.next;
        listSize--;
        if(listSize == 0) {
            endNodeForList = null;
        }
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DoubleLinkedList{size=").append(listSize).append(", elements=[");
        NodeForList<T> currentNode = initialNodeForList;

        while (currentNode != null) {
            sb.append(currentNode.value);
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

        System.out.println(doubleLinkedList.search(3));

    }
}
