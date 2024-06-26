package MyLinkedStack;

import java.util.NoSuchElementException;

@SuppressWarnings("hiding")
public class MyLinkedStack<Element> {
    private NodeForStack node;
    private int size = 0;

    private class NodeForStack {
        Element currentElement;
        NodeForStack previous;
    }

    public boolean isEmpty() {
        return node == null;
    }

    public int getSize() {
        return getSizeRecursive(node);
    }
    
    private int getSizeRecursive(NodeForStack currentNode) {
        if (currentNode == null) {
            return 0;
        } else {
            return 1 + getSizeRecursive(currentNode.previous);
        }
    }

    public void push(Element newElement) {
        NodeForStack auxNodeForStack = node;
        node = new NodeForStack();
        node.currentElement = newElement;
        node.previous = auxNodeForStack;
        size++;
    }

    public Element peek() {
        if (isEmpty())
            throw new NoSuchElementException("Stack underflow");
        return node.currentElement;
    }

    public void pop() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        node = node.previous;
        size--;
    }

    @Override
    public String toString() {
        if (this.size == 0) {
            return "[]";
        }
    
        StringBuilder stringBuilder = new StringBuilder();
        NodeForStack currentNode = node;
    
        for (int i = 0; i < this.size; i++) {
            stringBuilder.append(String.valueOf(currentNode.currentElement)).append(", ");
            currentNode = currentNode.previous;
        }
    
        stringBuilder.setLength(stringBuilder.length() - 2);
        return "[" + stringBuilder.toString() + "]";
    }
}
