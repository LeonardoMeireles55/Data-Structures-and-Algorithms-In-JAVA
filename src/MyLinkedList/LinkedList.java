package MyLinkedList;

public class LinkedList<T> {

    private NodeForList<T> initialNodeForList;
    private NodeForList<T> endNodeForList;

    private final int NOT_FOUND = -1;

    private int listSize = 0;


    public void add(T element) {
        NodeForList<T> value = new NodeForList<T>(element);
        if (listSize == 0) {
            initialNodeForList = value;
        } else {
            endNodeForList.setNext(value);
        }
        endNodeForList = value;
        listSize++;
    }

    public void removeLast() {
        if(this.listSize == 0) {
            throw new IllegalArgumentException("list is empty");
        }
        endNodeForList = null;
        listSize--;
    }

    public void remove(int position) {
        if(position < 0 || position > listSize) {
            throw new IllegalArgumentException("position not exists");
        }
        if(position == 0) {
            this.removeFirst();
        }
        else if (position == listSize - 1) {
            this.removeLast();
        } else {
            NodeForList previousNode = this.searchByPosition(position - 1);
            NodeForList currentNode = previousNode.getNext();
            NodeForList nextNode = currentNode.getNext();

            previousNode.setNext(nextNode);
            currentNode.setNext(null);
        }
        listSize--;
    }

    public void removeFirst() {
        if(listSize == 0) {
            throw new IllegalArgumentException("list is empty");
        }
        initialNodeForList = initialNodeForList.getNext();
        listSize--;
        if(listSize == 0) {
            endNodeForList = null;
        }
    }

    public void addFirst(T element) {
        if(listSize == 0) {
            NodeForList<T> nodeForList = new NodeForList<T>(element);
            initialNodeForList = nodeForList;
            endNodeForList = nodeForList;

        } else {
            NodeForList<T> nodeForList = new NodeForList<T>(element, initialNodeForList);
            initialNodeForList = nodeForList;
        }
        listSize++;
    }

    public void add(T element, int position) {
        if(position < 0 || position > listSize) {
            throw new IllegalArgumentException("position not exists");
        }
        if(position == 0) {
            this.addFirst(element);
        }
        else if (position == listSize) {
            add(element);

        } else {
            NodeForList<T> previousNode = this.searchByPosition(position);
            NodeForList<T> nextNode = previousNode.getNext();
            NodeForList<T> newNode = new NodeForList<T>(element, nextNode);
            previousNode.setNext(newNode);
            listSize++;
        }

    }

    private NodeForList<T> searchByPosition(int position) {
        if(!(position >= 0 && position <= listSize)) {
            throw new IllegalArgumentException("position not exists");
        }
        NodeForList<T> currentNode = initialNodeForList;
        int positionWhile = 0;
        while (positionWhile < position) {
                positionWhile++;
                currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    public T search(int position) {
        return this.searchByPosition(position).getElement();
    }

    public int searchByElement(T element) {
        NodeForList<T> actualNode = initialNodeForList;
        int index = 0;
        while (actualNode != null) {
            if(actualNode.getElement().equals(element)) {
                return index;
            }
                index++;
                actualNode = actualNode.getNext();
        }
        return NOT_FOUND;
    }

    public void linkedSearch(T element) {
        var elementIndex = searchByElement(element);
        var elementFound = search(elementIndex);
        System.out.println("O elemento está na posição: " + elementIndex + " com valor de: " + elementFound);
    }

    public void clear2() {
        NodeForList<T> currentNode = initialNodeForList;

        while (currentNode != null) {
            NodeForList<T> nextNode = currentNode.getNext();
            if(nextNode != null) {
                System.out.println(nextNode.getElement());
            }
            currentNode.setElement(null);
            currentNode.setNext(null);
            currentNode = nextNode;
        }
        System.out.println(currentNode);
        this.listSize = 0;
    }

    public void clear() {

        for(NodeForList<T> currentNode = initialNodeForList; currentNode != null;) {
            NodeForList<T> auxNode = currentNode.getNext(); //2 //3 //4 //null
            currentNode.setElement(null); //null
            currentNode.setNext(null); // null
            currentNode = auxNode; //set value = 2
        }
        initialNodeForList = null;
        endNodeForList = null;
        listSize = 0;
    }

    @Override
    public String toString() {
        if (this.listSize == 0) {
            return "[]";
        }

        StringBuilder stringBuilder = new StringBuilder();
        NodeForList<T> currentNode = initialNodeForList;
        for(int i = 0; i < listSize - 1; i++) {
            stringBuilder.append(currentNode.getElement()).append(",");
            currentNode = currentNode.getNext();
        }
        stringBuilder.append(currentNode.getElement()).append(".");

        return stringBuilder.toString();
    }
}