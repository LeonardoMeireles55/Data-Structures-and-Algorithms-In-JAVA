package MyLinkedList;

/**
 * A generic singly linked list implementation.
 *
 * @param <T> Type of elements stored in the linked list
 */
public class LinkedList<T> {

    public NodeForList<T> initialNodeForList;
    private NodeForList<T> endNodeForList;
    private static final Integer NOT_FOUND = -1;
    private Integer listSize = 0;

    /**
     * Adds an element to the end of the list.
     *
     * @param element Element to be added
     */
    public void add(T element) {
        NodeForList<T> value = new NodeForList<>(element);
        if (listSize == 0) {
            initialNodeForList = value;
        } else {
            endNodeForList.setNext(value);
        }
        endNodeForList = value;
        listSize++;
    }

    /**
     * Removes the last element from the list.
     *
     * @throws IllegalArgumentException if the list is empty
     */
    public void removeLast() {
        if (this.listSize == 0) {
            throw new IllegalArgumentException("List is empty");
        }

        if (listSize == 1) {
            initialNodeForList = null;
            endNodeForList = null;
        } else {
            NodeForList<T> currentNode = initialNodeForList;
            for (Integer i = 0; i < listSize - 2; i++) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(null);
            endNodeForList = currentNode;
        }
        listSize--;
    }

    /**
     * Removes an element at the specified position.
     *
     * @param position Position of the element to remove
     * @throws IllegalArgumentException if the position is invalid
     */
    public void remove(Integer position) {
        if (position < 0 || position >= listSize) {
            throw new IllegalArgumentException("Position not exists");
        }

        if (position == 0) {
            this.removeFirst();
        } else if (position == listSize - 1) {
            this.removeLast();
        } else {
            NodeForList<T> previousNode = this.searchByPosition(position - 1);
            NodeForList<T> currentNode = previousNode.getNext();
            NodeForList<T> nextNode = currentNode.getNext();

            previousNode.setNext(nextNode);
            currentNode.setNext(null);
            listSize--;
        }
    }

    /**
     * Removes the first element from the list.
     *
     * @throws IllegalArgumentException if the list is empty
     */
    public void removeFirst() {
        if (listSize == 0) {
            throw new IllegalArgumentException("List is empty");
        }

        initialNodeForList = initialNodeForList.getNext();
        listSize--;

        if (listSize == 0) {
            endNodeForList = null;
        }
    }

    /**
     * Adds an element to the beginning of the list.
     *
     * @param element Element to be added
     */
    public void addFirst(T element) {
        if (listSize == 0) {
            NodeForList<T> nodeForList = new NodeForList<>(element);
            initialNodeForList = nodeForList;
            endNodeForList = nodeForList;
        } else {
            NodeForList<T> nodeForList = new NodeForList<>(element, initialNodeForList);
            initialNodeForList = nodeForList;
        }
        listSize++;
    }

    /**
     * Adds an element at the specified position.
     *
     * @param element Element to be added
     * @param position Position to add the element
     * @throws IllegalArgumentException if the position is invalid
     */
    public void add(T element, Integer position) {
        if (position < 0 || position > listSize) {
            throw new IllegalArgumentException("Position not exists");
        }

        if (position == 0) {
            this.addFirst(element);
        } else if (position == listSize) {
            add(element);
        } else {
            NodeForList<T> previousNode = this.searchByPosition(position - 1);
            NodeForList<T> nextNode = previousNode.getNext();
            NodeForList<T> newNode = new NodeForList<>(element, nextNode);
            previousNode.setNext(newNode);
            listSize++;
        }
    }

    /**
     * Searches for a node at the specified position.
     *
     * @param position Position to search for
     * @return The node at the specified position
     * @throws IllegalArgumentException if the position is invalid
     */
    private NodeForList<T> searchByPosition(Integer position) {
        if (position < 0 || position >= listSize) {
            throw new IllegalArgumentException("Position not exists");
        }

        NodeForList<T> currentNode = initialNodeForList;
        for (Integer i = 0; i < position; i++) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    /**
     * Gets the element at the specified position.
     *
     * @param position Position of the element to retrieve
     * @return The element at the specified position
     */
    public T search(Integer position) {
        return this.searchByPosition(position).getElement();
    }

    /**
     * Searches for the position of an element.
     *
     * @param element Element to search for
     * @return The position of the element or NOT_FOUND if not found
     */
    public Integer searchByElement(T element) {
        NodeForList<T> actualNode = initialNodeForList;
        Integer index = 0;

        while (actualNode != null) {
            if (actualNode.getElement().equals(element)) {
                return index;
            }
            index++;
            actualNode = actualNode.getNext();
        }
        return NOT_FOUND;
    }

    /**
     * Searches for an element and prints its position and value.
     *
     * @param element Element to search for
     */
    public void linkedSearch(T element) {
        Integer elementIndex = searchByElement(element);
        if (elementIndex != NOT_FOUND) {
            T elementFound = search(elementIndex);
            System.out.println("Element found at position: " + elementIndex + " with value: " + elementFound);
        } else {
            System.out.println("Element not found");
        }
    }

    /**
     * Clears the list and releases all nodes.
     */
    public void clear() {
        for (NodeForList<T> currentNode = initialNodeForList; currentNode != null;) {
            NodeForList<T> auxNode = currentNode.getNext();
            currentNode.setElement(null);
            currentNode.setNext(null);
            currentNode = auxNode;
        }
        initialNodeForList = null;
        endNodeForList = null;
        listSize = 0;
    }

    /**
     * Returns the size of the list.
     *
     * @return The size of the list
     */
    public Integer size() {
        return listSize;
    }

    /**
     * Returns a string representation of the list.
     *
     * @return String representation of the list
     */
    @Override
    public String toString() {
        if (this.listSize == 0) {
            return "[]";
        }

        StringBuilder stringBuilder = new StringBuilder("[");
        NodeForList<T> currentNode = initialNodeForList;

        for (Integer i = 0; i < listSize - 1; i++) {
            stringBuilder.append(currentNode.getElement()).append(", ");
            currentNode = currentNode.getNext();
        }
        stringBuilder.append(currentNode.getElement()).append("]");

        return stringBuilder.toString();
    }
}
