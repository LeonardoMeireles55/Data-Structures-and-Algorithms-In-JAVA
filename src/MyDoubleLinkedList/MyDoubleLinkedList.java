package MyDoubleLinkedList;

public class MyDoubleLinkedList<T> {
    private NodeForList<T> initialNodeForList;
    private NodeForList<T> endNodeForList;
    private int listSize = 0;

    public MyDoubleLinkedList() {
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

    private NodeForList<T> searchByPosition(int position) {
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
        if (listSize == 0) {
            throw new IllegalArgumentException("list is empty");
        } else if (listSize == 1) {
            initialNodeForList = null;
            endNodeForList = null;
        } else {
            NodeForList<T> newLast = endNodeForList.previous;
            newLast.next = null;
            endNodeForList = newLast;
        }
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

    public int searchByElement(T element) {
        NodeForList<T> currentNode = initialNodeForList;
        int index = 0;
        while (currentNode != null) {
            if(currentNode.value.equals(element)) {
                return index;
            }
            index++;
            currentNode = currentNode.next;
        }
        return -1;
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MyDoubleLinkedList{size=").append(listSize).append(", elements=[");
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
        MyDoubleLinkedList<Integer> myDoubleLinkedList = new MyDoubleLinkedList<Integer>();
        myDoubleLinkedList.add(1);
        myDoubleLinkedList.add(2);
        myDoubleLinkedList.add(5);
        myDoubleLinkedList.add(3);
        myDoubleLinkedList.add(4);

        myDoubleLinkedList.removeFirst();
        myDoubleLinkedList.removeLast();
        System.out.println(myDoubleLinkedList);
    }
}
